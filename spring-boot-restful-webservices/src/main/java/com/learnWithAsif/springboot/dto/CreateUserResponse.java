package com.learnWithAsif.springboot.dto;

import com.learnWithAsif.springboot.entity.ROLE;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateUserResponse {
    private Long id;
    private String username;
    private ROLE role;
}
