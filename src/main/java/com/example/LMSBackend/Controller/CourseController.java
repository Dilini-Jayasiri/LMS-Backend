package com.example.LMSBackend.Controller;

import com.example.LMSBackend.Dto.CourseDto;
import com.example.LMSBackend.Service.CourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //define a controller
@RequestMapping(value = "/course") //map the web requests
@CrossOrigin(origins ="http://localhost:3000") //configuring allowed origins
@RequiredArgsConstructor
public class CourseController {
    @Autowired // inject CourseRepository
    private CourceService courseService;
    //end points
    //get all course details 
    @GetMapping("/getCourses")
    public List<CourseDto> getCourse(){
        return courseService.getAllCourses();
    }
 //get course details using given id
    @GetMapping("/getCourseByCourseId/{courseId}")
    public CourseDto getCourseByCourseId(@PathVariable String courseId){
         return courseService.getCourseByCourseID(courseId);
    }

//save the course data
    @PostMapping("/saveCourse")
    public CourseDto saveCourse(@RequestBody CourseDto courseDto){
        return courseService.saveCourse(courseDto);
    }

}
