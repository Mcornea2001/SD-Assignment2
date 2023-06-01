package com.example.Assignment2.model;

import jakarta.persistence.*;

@Entity
@Table
public class Submission {
    @Id
    @SequenceGenerator(name = "submission_sequence",
            sequenceName = "submission_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "submission_sequence"
    )
    private int id;
    private int studentId;
    private int assignmentId;
    private String link;
    private int grade;

    public Submission(int id, int studentId, int assignmentId, String link, int grade) {
        this.id = id;
        this.studentId = studentId;
        this.assignmentId = assignmentId;
        this.link = link;
        this.grade = grade;
    }

    public Submission() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
