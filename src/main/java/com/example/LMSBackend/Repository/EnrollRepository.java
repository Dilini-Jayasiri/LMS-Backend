package com.example.LMSBackend.Repository;

import com.example.LMSBackend.Model.StudentCourseEnroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollRepository extends JpaRepository<StudentCourseEnroll, Long> {
}
