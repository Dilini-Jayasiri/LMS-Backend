package com.example.LMSBackend.Service;

import com.example.LMSBackend.Dto.StudentDetailsDto;
import com.example.LMSBackend.Model.Student;

public interface StudentService {
    boolean register(Student newStudent);
    boolean findStudentByCredentials(StudentDetailsDto studentdto);
}
