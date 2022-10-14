package com.example.LMSBackend.Service;

// import com.example.LMSBackend.Dto.GetMarksDto;
import com.example.LMSBackend.Dto.UpdateMarksDto;
import com.example.LMSBackend.Model.UpdateMarks;

public interface UpdateMarksService {
  boolean marks(UpdateMarksDto updateMarks);

  public void updateStudentMarks(Long userId, String courseId);
}
