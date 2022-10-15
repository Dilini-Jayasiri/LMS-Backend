package com.example.LMSBackend.Repository;

import com.example.LMSBackend.Model.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarksRepository extends JpaRepository<Marks, Long> {
    @Query(value = "SELECT * FROM marks WHERE user_id=?;", nativeQuery = true)
    public List<Marks> getMarksById(Long user_id);

    @Query(value = "SELECT * FROM marks WHERE user_id=? AND course_id=?;", nativeQuery = true)
    public Marks updateMarks(Long user_id, String course_id);
}
