package com.example.LMSBackend.Controller;

import com.example.LMSBackend.Dto.EnrollDto;
import com.example.LMSBackend.Model.Student;
import com.example.LMSBackend.Service.EnrollService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/enroll")
@CrossOrigin
public class EnrollController {
    @Autowired
    private final EnrollService enrollservice;

    @PostMapping(value = "/new", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public boolean enroll(@RequestBody EnrollDto newEnrollment){
        return enrollservice.enroll(newEnrollment);
    }

}
