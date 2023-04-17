package com.socilamedia.socialmedia.dao;


import com.socilamedia.socialmedia.entity.SocialMediaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<SocialMediaUser, Long> {
    SocialMediaUser getUserByUsername (String username);
}
