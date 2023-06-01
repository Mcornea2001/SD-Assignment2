package com.example.Assignment2.controller;

import com.example.Assignment2.model.*;
import com.example.Assignment2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final LabsService labsService;
    private final AssignmentService assignmentService;
    private final SubmissionService submissionService;

    @Autowired
    public TeacherController(TeacherService teacherService, StudentService strudentService, LabsService labsService, AssignmentService assignmentService, SubmissionService submissionService) {
        this.teacherService = teacherService;
        this.studentService = strudentService;
        this.labsService = labsService;
        this.assignmentService = assignmentService;
        this.submissionService = submissionService;
    }

    @PostMapping("/login")
    public void login(@RequestBody TeacherDTO teacher) {
        if(teacherService.findByUsername(teacher.username) != null) {
            if (teacherService.findByUsername(teacher.username).getPassword().equals(teacher.password))
                teacherService.login(teacherService.findByUsername(teacher.username).getId());
            else
                System.out.println("Wrong password");
        }
        else
            System.out.println("Username not found");
    }

    @PostMapping("/logout")
    public void logout(@RequestBody TeacherDTO teacher) {
        if(teacherService.findByUsername(teacher.username) != null) {
            teacherService.logout(teacherService.findByUsername(teacher.username).getId());
        }
        else
            System.out.println("Username not found");
    }

    @GetMapping("/students/all")
    public List<Student> getStudents() {
        return studentService.findAllStudents();
    }

    @PostMapping("/students/add")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @DeleteMapping("/students/delete/{studentId}")
    public void deleteStudent(@PathVariable("studentId") int studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping("/students/update/{studentId}")
    public void updateStudent(
            @PathVariable("studentId") int studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String hobby,
            @RequestParam(required = false) String token,
            @RequestParam(required = false) int groupNumber,
            @RequestParam(required = false) boolean isLogged) {
        studentService.updateStudent(studentId, name, username, password, email, hobby, token, groupNumber, isLogged);
    }

    @GetMapping("/labs/all")
    public List<Labs> getLabs() {
        return labsService.findAllLabs();
    }

    @PostMapping("/labs/add")
    public void addLab(@RequestBody Labs lab) {
        labsService.addLab(lab);
    }

    @DeleteMapping("/labs/delete/{labId}")
    public void deleteLab(@PathVariable("labId") int labId) {
        labsService.deleteLab(labId);
    }

    @PutMapping("/labs/update/{labId}")
    public void updateLab(
            @PathVariable("labId") int labId,
            @RequestParam(required = false)Date date,
            @RequestParam(required = false)String title,
            @RequestParam(required = false)String description,
            @RequestParam(required = false)int assignmentId,
            @RequestParam(required = false)List<Student> students){
        labsService.updateLab(labId, date, title, description, assignmentId, students);
    }

    @GetMapping("/assignments/all")
    public List<Assignment> getAssignments() {
        return assignmentService.findAllAssignments();
    }

    @PostMapping("/assignments/add")
    public void addAssignment(@RequestBody Assignment assignment) {
        assignmentService.addAssignment(assignment);
    }

    @DeleteMapping("/assignments/delete/{assignmentId}")
    public void deleteAssignment(@PathVariable("assignmentId") int assignmentId) {
        assignmentService.deleteAssignment(assignmentId);
    }

    @PutMapping("/assignments/update/{assignmentId}")
    public void updateAssignment(
            @PathVariable("assignmentId") int assignmentId,
            @RequestParam(required = false)String name,
            @RequestParam(required = false)String description,
            @RequestParam(required = false)Date deadline){
        assignmentService.updateAssignment(assignmentId, name, description, deadline);
    }

    @PutMapping("/submission/grade/{submissionId}")
    public void gradeSubmission(
            @PathVariable("submissionId") int submissionId,
            @RequestParam(required = false)int grade){
        submissionService.gradeSubmission(submissionId, grade);
    }
}
