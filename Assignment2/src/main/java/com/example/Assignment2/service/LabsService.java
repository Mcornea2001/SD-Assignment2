package com.example.Assignment2.service;

import com.example.Assignment2.model.Labs;
import com.example.Assignment2.model.Student;
import com.example.Assignment2.repo.LabsRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class LabsService {
    private final LabsRepo labRepo;

    @Autowired
    public LabsService(LabsRepo labRepo) { this.labRepo = labRepo; }

    public List<Labs> findAllLabs() { return labRepo.findAll(); }
    public Labs findLabById(int id) { return labRepo.findById(id).orElseThrow(() -> new IllegalStateException("lab with id " + id + " does not exists")); }
    public void deleteLab(int id) { labRepo.deleteById(id); }
    public Labs addLab(Labs labs) { return labRepo.save(labs); }

    @Transactional
    public void updateLab(int id, Date date, String title, String description, int assignmentId, List<Student> students) {
        Labs labs = labRepo.findById(id).orElseThrow(() -> new IllegalStateException("lab with id " + id + " does not exists"));

        if (date != null && labs.getDate() != date) {
            labs.setDate(date);
        }

        if (title != null && labs.getTitle() != title) {
            labs.setTitle(title);
        }

        if (description != null && labs.getDescription() != description) {
            labs.setDescription(description);
        }

        if (assignmentId != 0 && labs.getAssignmentId() != assignmentId) {
            labs.setAssignmentId(assignmentId);
        }

        if (students != null && labs.getAttendedStudents() != students) {
            labs.setAttendedStudents(students);
        }
    }


}
