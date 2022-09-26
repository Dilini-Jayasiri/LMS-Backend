package com.example.LMSBackend.Repository;

import com.example.LMSBackend.Model.Student;
import com.example.LMSBackend.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Query(value = "select * from teacher where teacher_id=? and password=?;", nativeQuery = true)
    Teacher findTeacher(Long teacherId, String password);
}
