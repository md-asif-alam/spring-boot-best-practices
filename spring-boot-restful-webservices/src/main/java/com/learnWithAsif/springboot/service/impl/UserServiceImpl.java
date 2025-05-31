package com.learnWithAsif.springboot.service.impl;

import com.learnWithAsif.springboot.entity.User;
import com.learnWithAsif.springboot.respository.UserRepository;
import com.learnWithAsif.springboot.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        log.info("create user api requested");
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        log.info("Get user by id api requested");
        Optional<User> userGetById =userRepository.findById(userId);
        return userGetById.get();
    }

    @Override
    public List<User> getAllUsers() {
        log.info("Get all user api requested");
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    @Override
    public User updateUser(User user) {

        log.info("Update user api requested");
        User existingUser = userRepository.findById(user.getId()).get();

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        log.info("Update user api operation done");
        User updatedUser = userRepository.save(existingUser);

        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
        log.info("Delete user api requested");
        userRepository.deleteById(userId);
    }
}
