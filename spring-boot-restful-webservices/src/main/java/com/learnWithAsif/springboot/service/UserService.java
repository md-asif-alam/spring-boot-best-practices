package com.learnWithAsif.springboot.service;

import com.learnWithAsif.springboot.dto.UserDto;
import com.learnWithAsif.springboot.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto userDto);

    void deleteUser(Long userId);
}
