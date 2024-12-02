package com.pokazaneva.MySpringBoot2Dbase.service;

import com.pokazaneva.MySpringBoot2Dbase.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudent(int id);
    void deleteStudent(int id);
}
