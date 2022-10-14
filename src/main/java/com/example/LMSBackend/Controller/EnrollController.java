package com.example.LMSBackend.Controller;

import com.example.LMSBackend.Dto.EnrollDto;
import com.example.LMSBackend.Service.EnrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/enroll")
@CrossOrigin(origins ="http://localhost:3006")
public class EnrollController {
    @Autowired
    private final EnrollService enrollservice;

    @PostMapping(value = "/new", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public boolean enroll(@RequestBody EnrollDto newEnrollment){
        return enrollservice.enroll(newEnrollment);
    }

}
