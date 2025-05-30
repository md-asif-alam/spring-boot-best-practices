package com.learnWithAsif.springboot.service;

import com.learnWithAsif.springboot.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();
}
