package com.example.LMSBackend.Service;

import com.example.LMSBackend.Dto.GetMarksDto;
import com.example.LMSBackend.Dto.MarksDto;
import com.example.LMSBackend.Model.Marks;

import java.util.List;

public interface MarksService {
    boolean marks(MarksDto newMarks);

    public List<GetMarksDto> getStudentMarks(Long studentId);
}
