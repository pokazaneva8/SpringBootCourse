package com.pokazaneva.MySpringBoot2Dbase.service;

import com.pokazaneva.MySpringBoot2Dbase.dao.SubjectDAO;
import com.pokazaneva.MySpringBoot2Dbase.entity.Subject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectDAO subjectDAO;

    @Override
    @Transactional
    public List<Subject> getAllSubjects() {
        return subjectDAO.getAllSubjects();
    }
    @Override
    @Transactional
    public Subject saveSubject(Subject subject) {
        return subjectDAO.saveSubject(subject);
    }
    @Override
    @Transactional
    public Subject getSubject(int id) {
        Subject subject = subjectDAO.getSubject(id);
        if (subject == null) {
            throw new EntityNotFoundException("Не удалось найти дисциплину с id: " + id);
        }
        return subject;
    }
    @Override
    @Transactional
    public void deleteSubject(int id) {
        Subject subject = subjectDAO.getSubject(id);
        if (subject == null) {
            throw new EntityNotFoundException("Не удалось найти дисциплину с id: " + id);
        }
        subjectDAO.deleteSubject(id);
    }
}
