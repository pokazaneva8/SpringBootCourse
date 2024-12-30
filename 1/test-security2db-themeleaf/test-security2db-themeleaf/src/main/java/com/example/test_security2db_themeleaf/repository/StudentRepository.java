package com.example.test_security2db_themeleaf.repository;

import com.example.test_security2db_themeleaf.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
