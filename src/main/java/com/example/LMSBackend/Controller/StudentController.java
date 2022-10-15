package com.example.LMSBackend.Controller;

import com.example.LMSBackend.Dto.StudentDetailsDto;
import com.example.LMSBackend.Model.Student;
import com.example.LMSBackend.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/student")
@CrossOrigin
@RequiredArgsConstructor
public class StudentController {
    @Autowired
    private final StudentService studentservice;

    @PostMapping(value = "/register", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public boolean RegisterStudent(@RequestBody Student newStudent){
        return studentservice.register(newStudent);
    }

    @GetMapping(value = "/find", produces =APPLICATION_JSON_VALUE )
    public boolean FindStudent(@RequestBody StudentDetailsDto dto){
     return studentservice.findStudentByCredentials(dto);
    }



}
