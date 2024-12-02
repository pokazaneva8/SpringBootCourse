package com.pokazaneva.MySpringBoot2Dbase.service;

import com.pokazaneva.MySpringBoot2Dbase.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {
    List<Subject> getAllSubjects();
    Subject saveSubject(Subject subject);
    Subject getSubject(int id);
    void deleteSubject(int id);
    
}
