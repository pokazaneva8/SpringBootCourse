package com.example.test_security2db_themeleaf.repository;

import com.example.test_security2db_themeleaf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}