package com.socilamedia.socialmedia.dao;

import com.socilamedia.socialmedia.entity.SocialMediaUser;
import com.socilamedia.socialmedia.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    VerificationToken findByToken(String token);
    VerificationToken findByUser(SocialMediaUser user);
}
