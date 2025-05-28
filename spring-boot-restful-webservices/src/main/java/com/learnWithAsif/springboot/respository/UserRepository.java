package com.learnWithAsif.springboot.respository;

import com.learnWithAsif.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
