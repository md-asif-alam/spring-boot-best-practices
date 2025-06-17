package com.learnWithAsif.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @NotEmpty(message = "first name should not be null or empty")
    private String firstName;
    @NotEmpty(message = "last name should not be null or empty")
    private String lastName;
    @NotEmpty(message = "email should not be null or empty")
    @Email(message = "email should be valid")
    private String email;
}
