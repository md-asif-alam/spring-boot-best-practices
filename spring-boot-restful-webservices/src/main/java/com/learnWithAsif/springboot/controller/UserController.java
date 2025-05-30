package com.learnWithAsif.springboot.controller;

import com.learnWithAsif.springboot.entity.User;
import com.learnWithAsif.springboot.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
@Slf4j
public class UserController {


    private UserService userService;

    // Create user API: Post
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        log.info("Create user api initiated");
        User savedUser = userService.createUser(user);
        log.info("create user api created successfully");
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

}
