package com.socilamedia.socialmedia.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "social_media_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SocialMediaUser {
    @EqualsAndHashCode.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "username")
    String username;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "second_name")
    String lastName;
    @Column(name = "phone_number")
    String phoneNumber;
    @Column(name = "email")
    String email;
    @Column(name = "password")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    String password;
    @Column(name = "gender")
    String gender;
    @Column(name = "date")
    @EqualsAndHashCode.Exclude
    String date;
    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    boolean enabled;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id")
//    private Authorities authorities;
}
