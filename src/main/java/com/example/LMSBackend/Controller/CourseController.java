package com.example.LMSBackend.Controller;

import com.example.LMSBackend.Dto.CourseDto;
import com.example.LMSBackend.Service.CourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
////ddssss
@RestController
@RequestMapping(value = "/course")
@CrossOrigin(origins ="http://localhost:3000")
@RequiredArgsConstructor
public class CourseController {
    @Autowired
    private CourceService courseService;

    @GetMapping("/getCourses")
    public List<CourseDto> getCourse(){
        return courseService.getAllCourses();
    }

    @GetMapping("/getCourseByCourseId/{courseId}")
    public CourseDto getCourseByCourseId(@PathVariable String courseId){
         return courseService.getCourseByCourseID(courseId);
    }


    @PostMapping("/saveCourse")
    public CourseDto saveCourse(@RequestBody CourseDto courseDto){
        return courseService.saveCourse(courseDto);
    }

}
