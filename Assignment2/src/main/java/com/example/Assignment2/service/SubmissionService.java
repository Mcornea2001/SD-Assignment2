package com.example.Assignment2.service;

import com.example.Assignment2.model.Submission;
import com.example.Assignment2.repo.SubmissionRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionService {
    private final SubmissionRepo submissionRepo;

    @Autowired
    public SubmissionService(SubmissionRepo submissionRepo) { this.submissionRepo = submissionRepo; }
    public List<Submission> findAllSubmissions() { return submissionRepo.findAll(); }
    public Submission addSubmission(Submission submission) { return submissionRepo.save(submission); }
    public void deleteSubmission(int id) { submissionRepo.deleteById(id); }
    @Transactional
    public void updateSubmission(int id, int studentId, int assignmentId, String link, int grade) {
        Submission submission = submissionRepo.findById(id).orElseThrow(() -> new IllegalStateException("submission with id " + id + " does not exists"));

        if (studentId != 0 && submission.getStudentId() != studentId) {
            submission.setStudentId(studentId);
        }

        if (assignmentId != 0 && submission.getAssignmentId() != assignmentId) {
            submission.setAssignmentId(assignmentId);
        }

        if (link != null && link.length() > 0 && !submission.getLink().equals(link)) {
            submission.setLink(link);
        }

        if (grade != 0 && submission.getGrade() != grade) {
            submission.setGrade(grade);
        }
    }

    public void gradeSubmission(int submissionId, int grade) {
        Submission submission = submissionRepo.findById(submissionId).orElseThrow(() -> new IllegalStateException("submission with id " + submissionId + " does not exists"));
        submission.setGrade(grade);
        submissionRepo.save(submission);
    }
}
