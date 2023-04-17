package com.socilamedia.socialmedia.service;

import com.socilamedia.socialmedia.entity.SocialMediaUser;
import com.socilamedia.socialmedia.entity.VerificationToken;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{

    private final VerificationTokenService verificationTokenService;
    private final TemplateEngine templateEngine;
    private final JavaMailSender javaMailSender;
    @Override
    public void sendHtmlMail(SocialMediaUser user) throws MessagingException {
        System.out.println("---------------------------------|sendHtmlMail|--------------------------------");
        try {
            System.out.println(user);
            System.out.println(verificationTokenService);
            VerificationToken verificationToken = verificationTokenService.findByUser(user);
//        System.out.println(verificationToken);
/*        if(verificationToken!=null) {
            String token = verificationToken.getToken();
            Context context = new Context();
            context.setVariable("title", "Verify your email address");
            context.setVariable("link", "http://localhost:8080/activation?token="+token);
            String body = templateEngine.process("verification", context);

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(user.getEmail());
            helper.setSubject("email address verification");
            helper.setText(body, true);
            javaMailSender.send(message);
        }*/
        } catch (Exception er) {
            er.printStackTrace();
        }

    }
}
