package com.learnWithAsif.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "User DTO schema information"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @NotEmpty(message = "first name should not be null or empty")
    @Schema(description = "User first Name")
    private String firstName;
    @NotEmpty(message = "last name should not be null or empty")
    @Schema(description = "User last name")
    private String lastName;
    @NotEmpty(message = "email should not be null or empty")
    @Email(message = "email should be valid")
    @Schema(description = "user email")
    private String email;
}
