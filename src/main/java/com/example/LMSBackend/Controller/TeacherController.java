package com.example.LMSBackend.Controller;

import com.example.LMSBackend.Dto.StudentDetailsDto;
import com.example.LMSBackend.Dto.TeacherDetailsDto;
import com.example.LMSBackend.Model.Student;
import com.example.LMSBackend.Model.Teacher;
import com.example.LMSBackend.Service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/teacher")
@CrossOrigin
public class TeacherController {
    @Autowired
    private final TeacherService teacherservice;

    @PostMapping(value = "/register", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public boolean RegisterTeacher(@RequestBody Teacher newTeacher){
        return teacherservice.TeacherRegister(newTeacher);
    }

    @GetMapping(value = "/find", produces =APPLICATION_JSON_VALUE )
    public boolean FindTeacher(@RequestBody TeacherDetailsDto teacherdetailsdto){
        return teacherservice.FindTeacher(teacherdetailsdto);
    }

}
