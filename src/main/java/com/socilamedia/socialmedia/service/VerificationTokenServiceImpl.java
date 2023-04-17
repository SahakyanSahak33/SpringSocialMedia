package com.socilamedia.socialmedia.service;

import com.socilamedia.socialmedia.dao.VerificationTokenRepository;
import com.socilamedia.socialmedia.entity.SocialMediaUser;
import com.socilamedia.socialmedia.entity.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Calendar;

@Service
public class VerificationTokenServiceImpl implements VerificationTokenService{

    @Autowired
    private VerificationTokenRepository tokenRepository;

    @Override
    @Transactional
    public VerificationToken findByToken(String token) {
        return tokenRepository.findByToken(token);
    }

    @Override
    @Transactional
    public VerificationToken findByUser(SocialMediaUser user) {
        return tokenRepository.findByUser(user);
    }

    @Override
    @Transactional
    public void save(SocialMediaUser user, String token) {
        VerificationToken verificationToken = new VerificationToken(token,user);
        verificationToken.setExpiryDate(calculateExpiryDate());
        tokenRepository.save(verificationToken);
    }

    private Timestamp calculateExpiryDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, 1440);
        return new Timestamp(cal.getTime().getTime());
    }
}
