package com.learnWithAsif.springboot.mapper;

import com.learnWithAsif.springboot.dto.UserDto;
import com.learnWithAsif.springboot.entity.User;

public class UserMapper {

    //Convert User JPA entity to UserDto
    public static UserDto mapToUserDto(User user){

        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );

    }

    //Convert UserDto to User JPA entity
    public static User mapToUser(UserDto userDto){

        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );

    }



}
