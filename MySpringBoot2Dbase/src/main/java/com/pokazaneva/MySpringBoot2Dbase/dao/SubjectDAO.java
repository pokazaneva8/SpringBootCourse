package com.pokazaneva.MySpringBoot2Dbase.dao;

import com.pokazaneva.MySpringBoot2Dbase.entity.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectDAO {

    List<Subject> getAllSubjects();
    Subject saveSubject(Subject subject);
    Subject getSubject(int id);
    void deleteSubject(int id);
}
