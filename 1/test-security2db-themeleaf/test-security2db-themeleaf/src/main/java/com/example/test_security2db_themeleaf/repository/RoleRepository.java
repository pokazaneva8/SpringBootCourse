package com.example.test_security2db_themeleaf.repository;

import com.example.test_security2db_themeleaf.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}