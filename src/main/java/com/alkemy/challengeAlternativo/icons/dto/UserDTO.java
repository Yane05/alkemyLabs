package com.alkemy.challengeAlternativo.icons.dto;

import lombok.Data;
import 

@Data
public class UserDTO {
    @Email(message = "Username must be an email")
    private String username;
    @Size(min = 8)
    private String password;
}
