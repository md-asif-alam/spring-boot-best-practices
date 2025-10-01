package com.learnWithAsif.springboot.service.impl;

import com.learnWithAsif.springboot.entity.ROLE;
import com.learnWithAsif.springboot.entity.Users;
import com.learnWithAsif.springboot.respository.UserDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AdminInitializer {
    @Bean
    public CommandLineRunner createAdminUser(UserDetailsRepository userDetailsRepository, PasswordEncoder passwordEncoder){
        return args -> {
            if (userDetailsRepository.findByUsername("admin").isEmpty()){
                Users admin=new Users();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123"));//securely store password
                admin.setRole(ROLE.ROLE_ADMIN);

                userDetailsRepository.save(admin);
                log.info("Admin user has created");
            }
            if (userDetailsRepository.findByUsername("user").isEmpty()){
                Users user=new Users();
                user.setUsername("user");
                user.setPassword(passwordEncoder.encode("user123"));//securely store password
                user.setRole(ROLE.ROLE_USER);

                userDetailsRepository.save(user);
                log.info("user has created");
            }
        };
    }
}
