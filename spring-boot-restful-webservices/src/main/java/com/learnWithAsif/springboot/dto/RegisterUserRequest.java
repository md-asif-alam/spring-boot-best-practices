package com.learnWithAsif.springboot.dto;

import com.learnWithAsif.springboot.entity.ROLE;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RegisterUserRequest {
    private String username;
    private String password;
    private ROLE role;
}
