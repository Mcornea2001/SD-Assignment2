package com.example.Assignment2.repo;

import com.example.Assignment2.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepo extends JpaRepository<Submission, Integer> {
}
