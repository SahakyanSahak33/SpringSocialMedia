package com.socilamedia.socialmedia.service;

import com.socilamedia.socialmedia.dao.UserRepository;
import com.socilamedia.socialmedia.entity.SocialMediaUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final VerificationTokenService tokenService;
    private final EmailService emailService;



    @Override
    @Transactional
    public SocialMediaUser saveUser(SocialMediaUser socialMediaUser) {
        SocialMediaUser user = userRepository.save(socialMediaUser);
        socialMediaUser.setEnabled(false);

        Optional<SocialMediaUser> saved = Optional.of(user);

        saved.ifPresent(u->{
            try {
                String token = UUID.randomUUID().toString();
                tokenService.save(saved.get(),token);

                emailService.sendHtmlMail(u);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return saved.get();
    }

    @Override
    public SocialMediaUser searchUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public boolean checkUserPassword(String password) {

        return false;
    }

    public VerificationTokenService getTokenService() {
        return tokenService;
    }
}
