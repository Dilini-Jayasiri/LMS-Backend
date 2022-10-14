package com.example.LMSBackend.Controller;

import com.example.LMSBackend.Dto.GetMarksDto;
import com.example.LMSBackend.Dto.MarksDto;
import com.example.LMSBackend.Model.Marks;
import com.example.LMSBackend.Service.MarksService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/marks")
@CrossOrigin(origins ="http://localhost:3006")
public class MarksController {
    @Autowired
    private final MarksService marksservice;


    @PostMapping(value = "/new", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public boolean marks(@RequestBody MarksDto newMarks) {
        return marksservice.marks(newMarks);
    }

    @GetMapping("/view/{userId}")
    public List<GetMarksDto> getMarks(@PathVariable Long userId ) {
        return marksservice.getStudentMarks(userId);}
}
