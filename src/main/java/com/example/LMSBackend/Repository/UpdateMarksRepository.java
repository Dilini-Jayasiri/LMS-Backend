package com.example.LMSBackend.Repository;

import com.example.LMSBackend.Model.UpdateMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UpdateMarksRepository extends JpaRepository<UpdateMarks, Long> {
  @Query(value ="SELECT * FROM marks WHERE user_id=? AND course_id=?;" , nativeQuery = true)
  public List<UpdateMarks> getUpdateMarksById(Long user_id, String courseId);
}
