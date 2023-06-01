package com.example.Assignment2.service;

import com.example.Assignment2.model.Assignment;
import com.example.Assignment2.repo.AssignmentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;

import java.util.List;

@Service
public class AssignmentService {
    private final AssignmentRepo assignmentRepo;

    @Autowired
    public AssignmentService(AssignmentRepo assignmentRepo) {
        this.assignmentRepo = assignmentRepo;
    }

    public List<Assignment> findAllAssignments() {
        return assignmentRepo.findAll();
    }
    public Assignment findAssignmentById(int id) {
        return assignmentRepo.findById(id).orElseThrow(() -> new IllegalStateException("assignment with id " + id + " does not exists"));
    }

    public Assignment addAssignment(Assignment assignment) {
        return assignmentRepo.save(assignment);
    }

    public void deleteAssignment(int id) {
        assignmentRepo.deleteById(id);
    }

    @Transactional
    public void updateAssignment(int id, String name, String description, Date deadline) {
        Assignment assignment = assignmentRepo.findById(id).orElseThrow(() -> new IllegalStateException("assignment with id " + id + " does not exists"));

        if (name != null && name.length() > 0 && !assignment.getName().equals(name)) {
            assignment.setName(name);
        }

        if (description != null && description.length() > 0 && !assignment.getDescription().equals(description)) {
            assignment.setDescription(description);
        }

        if (deadline != null && !assignment.getDeadline().equals(deadline)) {
            assignment.setDeadline(deadline);
        }
    }
}
