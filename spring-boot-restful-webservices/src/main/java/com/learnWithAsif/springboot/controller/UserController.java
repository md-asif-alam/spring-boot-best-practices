package com.learnWithAsif.springboot.controller;

import com.learnWithAsif.springboot.entity.User;
import com.learnWithAsif.springboot.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //Get User by id API: GET
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        log.info("Get user by id api initiated");
        User user = userService.getUserById(userId);
        log.info("Get user by id api executed successfully");
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
