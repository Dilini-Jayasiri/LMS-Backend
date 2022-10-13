package com.example.LMSBackend.Repository;

import com.example.LMSBackend.Model.Marks;
import com.example.LMSBackend.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarksRepository extends JpaRepository<Marks, Long> {
    @Query(value ="SELECT * FROM marks WHERE user_id=?;" , nativeQuery = true)
    public List<Marks> getMarksById(Long user_id);
}
