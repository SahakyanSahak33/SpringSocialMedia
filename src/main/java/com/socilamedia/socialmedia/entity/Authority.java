/*
package com.socilamedia.socialmedia.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "authority")
    String authority;
    @OneToOne(mappedBy = "authorities" , cascade = CascadeType.ALL)
    private SocialMediaUser socialMediaUser;
}
*/
