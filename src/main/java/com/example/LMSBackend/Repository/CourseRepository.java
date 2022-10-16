package com.example.LMSBackend.Repository;

import com.example.LMSBackend.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, String>{
//select data from course table when given course id
    @Query(value = "SELECT * FROM course WHERE course_id =?;",nativeQuery = true)
    Course getCourseByCourseID(String course_id);

}
