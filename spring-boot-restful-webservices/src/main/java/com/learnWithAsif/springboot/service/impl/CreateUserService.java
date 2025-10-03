package com.learnWithAsif.springboot.service.impl;

import com.learnWithAsif.springboot.dto.CreateUserResponse;
import com.learnWithAsif.springboot.dto.RegisterUserRequest;
import com.learnWithAsif.springboot.entity.Users;
import com.learnWithAsif.springboot.respository.UserDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateUserService {
    private final UserDetailsRepository userDetailsRepository;
    private final PasswordEncoder passwordEncoder;


    public CreateUserResponse registerUser(RegisterUserRequest registerUserRequest){
        //TODO check if user is already present
        if(userDetailsRepository.findByUsername(registerUserRequest.getUsername()).isPresent()){
            throw new RuntimeException("User already exist");
        }

        //TODO encode password in request
        Users users=new Users();
        users.setUsername(registerUserRequest.getUsername());
        users.setRole(registerUserRequest.getRole());
        users.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));

        //TODO save user
        Users savedUser = userDetailsRepository.save(users);

        return new CreateUserResponse(savedUser.getId(), savedUser.getUsername(), savedUser.getRole());
    }
}
