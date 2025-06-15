package com.learnWithAsif.springboot.service.impl;

import com.learnWithAsif.springboot.dto.UserDto;
import com.learnWithAsif.springboot.entity.User;
import com.learnWithAsif.springboot.exception.ResourceNotFoundException;
import com.learnWithAsif.springboot.mapper.UserMapper;
import com.learnWithAsif.springboot.respository.UserRepository;
import com.learnWithAsif.springboot.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("create user api requested");

        //converting UserDto to User JPA entity
//        User user= UserMapper.mapToUser(userDto);
        User user= modelMapper.map(userDto,User.class);


        User savedUser = userRepository.save(user);

        //Converting User JPA entity to UserDto
//        UserDto savedUserDto=UserMapper.mapToUserDto(savedUser);
        UserDto savedUserDto=modelMapper.map(savedUser,UserDto.class);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        log.info("Get user by id api requested");
//        Optional<User> userGetById =userRepository.findById(userId);
//        User user = userGetById.get();

        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );

//        UserDto userDto=UserMapper.mapToUserDto(user);
        UserDto userDto=modelMapper.map(user,UserDto.class);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        log.info("Get all user api requested");
        List<User> allUsers = userRepository.findAll();

//        List<UserDto> allUsersDto = allUsers.stream()
//                .map(UserMapper::mapToUserDto)
//                .toList();
//
        List<UserDto> allUsersDto = allUsers.stream()
                .map(user -> modelMapper.map(user,UserDto.class))
                .toList();

        return allUsersDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {

        log.info("Update user api requested");
//        User existingUser = userRepository.findById(userDto.getId()).get();

        User existingUser = userRepository.findById(userDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userDto.getId())
        );

        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());

        log.info("Update user api operation done");
        User updatedUser = userRepository.save(existingUser);

//        return UserMapper.mapToUserDto(updatedUser);

        return modelMapper.map(updatedUser,UserDto.class);
    }

    @Override
    public void deleteUser(Long userId) {
        log.info("Delete user api requested");

        User existingUser = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );


        userRepository.deleteById(userId);
    }
}
