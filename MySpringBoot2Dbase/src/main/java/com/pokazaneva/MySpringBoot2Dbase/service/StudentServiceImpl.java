package com.pokazaneva.MySpringBoot2Dbase.service;

import com.pokazaneva.MySpringBoot2Dbase.dao.StudentDAO;
import com.pokazaneva.MySpringBoot2Dbase.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDAO studentDAO;

    @Override
    @Transactional
    public List<Student> getAllStudents(){
        return studentDAO.getAllStudents();
    }

    @Override
    @Transactional
    public Student saveStudent (Student student) {
        return studentDAO.saveStudent(student);
    }

    @Override
    @Transactional
    public Student getStudent (int id) {
        Student student = studentDAO.getStudent(id);
        if (student == null) {
            throw new EntityNotFoundException("Не удалось найти студента с id: " + id );
        }
        return student;
    }

    @Override
    @Transactional
    public void deleteStudent (int id) {
        Student student = studentDAO.getStudent(id);
        if (student == null) {
            throw new EntityNotFoundException("Не удалось найти студента с id: " + id );
        }
        studentDAO.deleteStudent(id);
    }
}
