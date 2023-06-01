package com.example.Assignment2.model;

import jakarta.persistence.*;

@Entity
@Table
public class Teacher {
    @Id
    @SequenceGenerator(name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private int id;
    private String username;
    private String password;
    private boolean loggedIn;

    public Teacher(){};
    public Teacher(int id, String username, String password, boolean loggedIn) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.loggedIn = loggedIn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
