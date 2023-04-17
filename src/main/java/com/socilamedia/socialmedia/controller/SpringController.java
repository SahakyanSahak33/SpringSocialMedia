package com.socilamedia.socialmedia.controller;

import com.socilamedia.socialmedia.dto.UserLogInDTO;
import com.socilamedia.socialmedia.entity.SocialMediaUser;
import com.socilamedia.socialmedia.entity.VerificationToken;
import com.socilamedia.socialmedia.service.UserService;
import com.socilamedia.socialmedia.service.VerificationTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequiredArgsConstructor
public class SpringController {

    private final UserService userService;
    private final VerificationTokenService verificationTokenService;



    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/loginUser")
    public String login(Model model) {
        UserLogInDTO userLogInDTO = new UserLogInDTO();
        model.addAttribute("userLogIn", userLogInDTO);
        return "login";
    }

    @RequestMapping("/asking")
    public String asking(@ModelAttribute("userLogIn") UserLogInDTO userLogInDTO) {
        SocialMediaUser user = userService.searchUserByUsername(userLogInDTO.getUsername());
        System.out.println(user);
        String password = userLogInDTO.getPassword();
        if(BCrypt.checkpw(password, user.getPassword())) {
            return "redirect:/";
        }
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        SocialMediaUser user = new SocialMediaUser();
        model.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping("/activation")
    public String activation(@ModelAttribute("user") SocialMediaUser user, Model model) {
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        user.setEnabled(true);
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        user.setDate(currentTime);
        userService.saveUser(user);
        VerificationToken verificationToken = verificationTokenService.findByToken(userService.getTokenService().findByUser(user).getToken());
        if (verificationToken==null) {
            model.addAttribute("message", "Your verification token is invalid.");
        } else {
            if (!user.isEnabled()) {
                Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
                if (verificationToken.getExpiryDate().before(currentTimeStamp)) {
                    model.addAttribute("message", "Your verification token has expired");
                } else {
                    model.addAttribute("message", "your account is successfully activated");
                }
            } else {
                model.addAttribute("message", "your account is already activated");
            }
        }


        return "activation";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") SocialMediaUser user, Model model) {

        return "redirect:/activation";
    }
}
