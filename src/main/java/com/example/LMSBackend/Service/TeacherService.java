package com.example.LMSBackend.Service;

import com.example.LMSBackend.Dto.TeacherDetailsDto;
import com.example.LMSBackend.Model.Teacher;

public interface TeacherService {
    boolean TeacherRegister(Teacher newTeacher);
    boolean FindTeacher(TeacherDetailsDto teacherdetailsdto);
}
