package com.example.Assignment2.repo;

import com.example.Assignment2.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepo extends JpaRepository<Assignment, Integer> {
}
