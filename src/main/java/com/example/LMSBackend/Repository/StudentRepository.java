package com.example.LMSBackend.Repository;

import com.example.LMSBackend.Dto.StudentDetailsDto;
import com.example.LMSBackend.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "select * from student where student_id=? and password=?;", nativeQuery = true)
    Student findStudent(Long studentId, String password);
}
