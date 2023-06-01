package com.example.Assignment2.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Labs {
    @Id
    @SequenceGenerator(name = "lab_sequence",
            sequenceName = "lab_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "lab_sequence"
    )
    private int id;
    private Date date;
    private String title;
    private String description;

    private int assignmentId;

    @ManyToMany
    private List<Student> attendedStudents;

    public Labs(){};

    public Labs(int id, Date date, String title, String description, int assignmentId, List<Student> attendedStudents) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.description = description;
        this.assignmentId = assignmentId;
        this.attendedStudents = attendedStudents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public List<Student> getAttendedStudents() {
        return attendedStudents;
    }

    public void setAttendedStudents(List<Student> attendedStudents) {
        this.attendedStudents = attendedStudents;
    }
}
