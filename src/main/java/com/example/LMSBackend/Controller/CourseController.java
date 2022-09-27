package com.example.LMSBackend.Controller;

import com.example.LMSBackend.Dto.CourseDto;
import com.example.LMSBackend.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/course")
@CrossOrigin

public class CourseController {
    @Autowired
    private CourseService courseService;

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