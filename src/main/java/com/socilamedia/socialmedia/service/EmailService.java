package com.socilamedia.socialmedia.service;

import com.socilamedia.socialmedia.entity.SocialMediaUser;

import javax.mail.MessagingException;

public interface EmailService {
    void sendHtmlMail(SocialMediaUser user) throws MessagingException;

}
