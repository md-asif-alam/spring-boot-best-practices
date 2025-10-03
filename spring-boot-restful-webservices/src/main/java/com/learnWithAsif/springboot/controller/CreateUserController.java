package com.learnWithAsif.springboot.controller;

import com.learnWithAsif.springboot.dto.CreateUserResponse;
import com.learnWithAsif.springboot.dto.RegisterUserRequest;
import com.learnWithAsif.springboot.entity.ROLE;
import com.learnWithAsif.springboot.service.impl.CreateUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/register")
public class CreateUserController {
    private final CreateUserService createUserService;

    @PostMapping
    public ResponseEntity<CreateUserResponse> registerUser(@RequestBody RegisterUserRequest registerUserRequest){
        registerUserRequest.setRole(ROLE.ROLE_USER);
        CreateUserResponse createUserResponse = createUserService.registerUser(registerUserRequest);
        return new ResponseEntity<>(createUserResponse, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/create")
    public ResponseEntity<CreateUserResponse> registerByAdmin(@RequestBody RegisterUserRequest registerUserRequest){
        CreateUserResponse createUserResponse = createUserService.registerUser(registerUserRequest);
        return new ResponseEntity<>(createUserResponse, HttpStatus.CREATED);
    }
}
