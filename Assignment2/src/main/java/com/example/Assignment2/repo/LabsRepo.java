package com.example.Assignment2.repo;

import com.example.Assignment2.model.Labs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabsRepo extends JpaRepository<Labs, Integer> {
}
