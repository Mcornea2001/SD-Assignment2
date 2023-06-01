package com.example.Assignment2.controller;

import com.example.Assignment2.model.Assignment;
import com.example.Assignment2.model.Labs;
import com.example.Assignment2.model.StudentDTO;
import com.example.Assignment2.model.Submission;
import com.example.Assignment2.service.AssignmentService;
import com.example.Assignment2.service.LabsService;
import com.example.Assignment2.service.StudentService;
import com.example.Assignment2.service.SubmissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    private final LabsService labsService;
    private final AssignmentService assignmentService;
    private final SubmissionService submissionService;

    public StudentController(StudentService studentService, LabsService labsService, AssignmentService assignmentService, SubmissionService submissionService) {
        this.studentService = studentService;
        this.labsService = labsService;
        this.assignmentService = assignmentService;
        this.submissionService = submissionService;
    }

    @PostMapping("/login")
    public void login(@RequestBody StudentDTO student) {
        if(studentService.findByUsername(student.username) != null) {
            if (studentService.findByUsername(student.username).getPassword().equals(student.password)){
                if (studentService.findByUsername(student.username).getToken().equals(student.token))
                    studentService.login(studentService.findByUsername(student.username).getId());
                else System.out.println("Wrong token");
            }
            else
                System.out.println("Wrong password");
        }
        else
            System.out.println("Username not found");
    }

    @GetMapping("/labs")
    public List<Labs> getLabs() {
        return labsService.findAllLabs();
    }

    @GetMapping("/assignments/{labId}")
    public Assignment getAssignments(int labId) {
        Labs lab = labsService.findLabById(labId);
        return assignmentService.findAssignmentById(lab.getId());
    }

    @PostMapping("/submit")
    public void submit(@RequestBody Submission submission) {
        submissionService.addSubmission(submission);
    }
}
