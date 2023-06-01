package com.example.Assignment2.service;

import com.example.Assignment2.model.Student;
import com.example.Assignment2.repo.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) { this.studentRepo = studentRepo; }

    public List<Student> findAllStudents() { return studentRepo.findAll(); }
    public Student addStudent(Student student) { return studentRepo.save(student); }
    public void deleteStudent(int id) { studentRepo.deleteById(id); }

    @Transactional
    public void updateStudent(int id, String name, String username, String password, String email, String hobby, String token, int groupNumber, boolean loggedIn) {
        Student student = studentRepo.findById(id).orElseThrow(() -> new IllegalStateException("student with id " + id + " does not exists"));

        if (name != null && name.length() > 0 && !student.getName().equals(name)) {
            student.setName(name);
        }

        if (username != null && username.length() > 0 && !student.getUsername().equals(username)) {
            student.setUsername(username);
        }

        if (password != null && password.length() > 0 && !student.getPassword().equals(password)) {
            student.setPassword(password);
        }

        if (email != null && email.length() > 0 && !student.getEmail().equals(email)) {
            student.setEmail(email);
        }

        if (hobby != null && hobby.length() > 0 && !student.getHobby().equals(hobby)) {
            student.setHobby(hobby);
        }

        if (token != null && token.length() > 0 && !student.getToken().equals(token)) {
            student.setToken(token);
        }

        if (groupNumber != 0 && student.getGroupNumber() != groupNumber) {
            student.setGroupNumber(groupNumber);
        }

        if (loggedIn != student.isLoggedIn()) {
            student.setLoggedIn(loggedIn);
        }
    }
    public void login(int id) {
        Student student = studentRepo.findById(id).orElseThrow(() -> new IllegalStateException("student with id " + id + " does not exists"));
        student.setLoggedIn(true);
        studentRepo.save(student);
    }

    public Student findByUsername(String username) {
        return studentRepo.findByUsername(username);
    }
}
