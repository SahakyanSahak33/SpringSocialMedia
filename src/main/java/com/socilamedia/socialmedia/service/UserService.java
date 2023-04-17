package com.socilamedia.socialmedia.service;


import com.socilamedia.socialmedia.entity.SocialMediaUser;

public interface UserService{
    SocialMediaUser saveUser(SocialMediaUser socialMediaUser);
    SocialMediaUser searchUserByUsername(String username);

    boolean checkUserPassword(String password);

    VerificationTokenService getTokenService();
}
