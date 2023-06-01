package com.example.Assignment2.repo;

import com.example.Assignment2.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Integer>{
    Teacher findTeacherByUsername(String username);

}
