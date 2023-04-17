package com.socilamedia.socialmedia.service;

import com.socilamedia.socialmedia.entity.SocialMediaUser;
import com.socilamedia.socialmedia.entity.VerificationToken;

public interface VerificationTokenService {
    VerificationToken findByToken(String token);
    VerificationToken findByUser(SocialMediaUser user);
    void save(SocialMediaUser user, String token);
}
