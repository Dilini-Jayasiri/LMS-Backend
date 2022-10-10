package com.example.LMSBackend.Repository;

import com.example.LMSBackend.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, String>{

    @Query(value = "SELECT * FROM COURSE WHERE courseId = ?1",nativeQuery = true)
    Course getCourseByCourseID(String courseId);

}
