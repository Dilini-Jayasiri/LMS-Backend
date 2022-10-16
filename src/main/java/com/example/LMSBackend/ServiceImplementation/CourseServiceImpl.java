package com.example.LMSBackend.ServiceImplementation;

import com.example.LMSBackend.Dto.CourseDto;
import com.example.LMSBackend.Model.Course;
import com.example.LMSBackend.Repository.CourseRepository;
import com.example.LMSBackend.Service.CourceService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //mark as a service class
@RequiredArgsConstructor
@Transactional
public class CourseServiceImpl implements CourceService {
    @Autowired
    private CourseRepository courseRepo;
    @Autowired
    private ModelMapper modelMapper;
//save course data
    public CourseDto saveCourse(CourseDto courseDto){
        courseRepo.save(modelMapper.map(courseDto, Course.class));
        return courseDto;
    }
    //get course
    public List<CourseDto> getAllCourses(){
        List<Course> courseList=courseRepo.findAll();
        return modelMapper.map(courseList,new TypeToken<List<CourseDto>>(){}.getType());
    }
//get course using give id
    public CourseDto getCourseByCourseID(String courseId){
        Course course= courseRepo.getCourseByCourseID(courseId);
        return modelMapper.map(course,CourseDto.class);

    }
}
