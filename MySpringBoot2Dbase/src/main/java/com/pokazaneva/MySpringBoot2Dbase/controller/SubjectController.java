package com.pokazaneva.MySpringBoot2Dbase.controller;

import com.pokazaneva.MySpringBoot2Dbase.entity.Subject;
import com.pokazaneva.MySpringBoot2Dbase.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pokazaneva.MySpringBoot2Dbase.service.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subjects")
    public Result<List<Subject>> getAllSubjects() {
        return new Result<>(Result.SUCCESS_MESSAGE, subjectService.getAllSubjects());
    }
    @GetMapping("/subjects/{id}")
    public Result<Object> getSubject(@PathVariable("id") int id) {
        return new Result<>(Result.SUCCESS_MESSAGE, subjectService.getSubject(id));
    }
    @PostMapping("/subjects")
    public Result<Subject> saveSubject(@RequestBody Subject subject) {
        return new Result<>(Result.SUCCESS_MESSAGE, subjectService.saveSubject(subject));
    }
    @PutMapping("/subjects")
    public Result<Subject> updateSubject(@RequestBody Subject subject) {
        return new Result<>(Result.SUCCESS_MESSAGE, subjectService.saveSubject(subject));
    }
    @DeleteMapping("/subjects/{id}")
    public Result<Object> deleteSubject(@PathVariable("id") int id) {
        subjectService.deleteSubject(id);
        return new Result<>(Result.SUCCESS_MESSAGE, null);
    }
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        return new Result<>(Result.ERROR_MESSAGE, e.getMessage());
    }
}