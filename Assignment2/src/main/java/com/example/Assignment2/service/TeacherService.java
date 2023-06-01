package com.example.Assignment2.service;

import com.example.Assignment2.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Assignment2.repo.TeacherRepo;


@Service
public class TeacherService {
    private final TeacherRepo teacherRepo;

    @Autowired
    public TeacherService(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public void login(int id) {
        Teacher teacher = teacherRepo.findById(id).orElseThrow(() -> new IllegalStateException("teacher with id " + id + " does not exists"));
        teacher.setLoggedIn(true);
        teacherRepo.save(teacher);
    }

    public void logout(int id) {
        Teacher teacher = teacherRepo.findById(id).orElseThrow(() -> new IllegalStateException("teacher with id " + id + " does not exists"));
        teacher.setLoggedIn(false);
        teacherRepo.save(teacher);
    }

    public Teacher findByUsername(String username) {
        return teacherRepo.findTeacherByUsername(username);
    }
}
