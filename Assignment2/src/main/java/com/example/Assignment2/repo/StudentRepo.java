package com.example.Assignment2.repo;

import com.example.Assignment2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    Student findByUsername(String username);
}
