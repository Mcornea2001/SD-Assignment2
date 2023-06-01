package com.example.Assignment2.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table
public class Assignment {
    @Id
    @SequenceGenerator(name = "assignment_sequence",
            sequenceName = "assignment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "assignment_sequence"
    )
    private int id;
    private String name;
    private String description;
    private Date deadline;

    public Assignment(int id, String name, String description, Date deadline) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadline = deadline;
    }

    public Assignment() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
