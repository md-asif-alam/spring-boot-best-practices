package com.learnWithAsif.springboot.controller;

import com.learnWithAsif.springboot.dto.UserDto;
import com.learnWithAsif.springboot.entity.User;
import com.learnWithAsif.springboot.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
@Slf4j
public class UserController {


    private UserService userService;

    // Create user API: Post
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        log.info("Create user api initiated");
        UserDto savedUserDto = userService.createUser(userDto);
        log.info("create user api created successfully");
        return new ResponseEntity<>(savedUserDto, HttpStatus.CREATED);
    }

    //Get User by id API: GET
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        log.info("Get user by id api initiated");
        UserDto userDto = userService.getUserById(userId);
        log.info("Get user by id api executed successfully");
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }

    //Get ALL users API: GET
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        log.info("Get all user api initiated");
        List<UserDto> allUsersDto = userService.getAllUsers();
        log.info("Get all user api executed successfully");
        return new ResponseEntity<>(allUsersDto,HttpStatus.OK);
    }

    //Update User API: PUT
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,@Valid @RequestBody UserDto userDto){
        userDto.setId(userId);
        log.info("Update user api initiated");
        UserDto updatedUserDto = userService.updateUser(userDto);
        log.info("Update user api executed successfully");
        return new ResponseEntity<>(updatedUserDto,HttpStatus.OK);
    }

    //Delete User API: DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        log.info("Delete user api initiated");
        userService.deleteUser(userId);
        log.info("Delete user api executed successfully");
        return new ResponseEntity<>("user deleted successfully!",HttpStatus.OK);
    }

}
