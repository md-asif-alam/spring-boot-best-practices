package com.learnWithAsif.springboot.controller;

import com.learnWithAsif.springboot.dto.UserDto;
import com.learnWithAsif.springboot.entity.User;
import com.learnWithAsif.springboot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD Rest API for User Resource",
        description = "CRUD Rest API, Create, Delete, Update, GetALl and GetUserByID"
)

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
@Slf4j
public class UserController {


    private UserService userService;

    @GetMapping("/health")
    @PreAuthorize("hasAuthority('READ')")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")

    public String health(){
        return "healthy";
    }

    @Operation(
            summary = "Create user REST API",
            description = "Create user Rest API is used to save user in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 Created"
    )
    // Create user API: Post
    @PostMapping
    @PreAuthorize("hasAuthority('WRITE')")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        log.info("Create user api initiated");
        UserDto savedUserDto = userService.createUser(userDto);
        log.info("create user api created successfully");
        return new ResponseEntity<>(savedUserDto, HttpStatus.CREATED);
    }

    @Operation(
            summary = "GET user REST API by ID",
            description = "GET user Rest API is used to GET user from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 OK"
    )
    //Get User by id API: GET
    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        log.info("Get user by id api initiated");
        UserDto userDto = userService.getUserById(userId);
        log.info("Get user by id api executed successfully");
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }

    @Operation(
            summary = "GET user REST API",
            description = "GET user Rest API is used to GET all users from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 OK"
    )
    //Get ALL users API: GET
    @GetMapping
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        log.info("Get all user api initiated");
        List<UserDto> allUsersDto = userService.getAllUsers();
        log.info("Get all user api executed successfully");
        return new ResponseEntity<>(allUsersDto,HttpStatus.OK);
    }

    @Operation(
            summary = "Update user REST API by id",
            description = "Update user Rest API is used to update and save user in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 OK"
    )
    //Update User API: PUT
    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('WRITE')")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,@Valid @RequestBody UserDto userDto){
        userDto.setId(userId);
        log.info("Update user api initiated");
        UserDto updatedUserDto = userService.updateUser(userDto);
        log.info("Update user api executed successfully");
        return new ResponseEntity<>(updatedUserDto,HttpStatus.OK);
    }

    @Operation(
            summary = "Delete user REST API by ID",
            description = "Delete user Rest API is used to delete user in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 OK"
    )
    //Delete User API: DELETE
    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('DELETE')")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        log.info("Delete user api initiated");
        userService.deleteUser(userId);
        log.info("Delete user api executed successfully");
        return new ResponseEntity<>("user deleted successfully!",HttpStatus.OK);
    }

}
