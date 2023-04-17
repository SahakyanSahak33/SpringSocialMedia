package com.socilamedia.socialmedia.dto;

import com.socilamedia.socialmedia.entity.SocialMediaUser;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private SocialMediaUser user;
}
