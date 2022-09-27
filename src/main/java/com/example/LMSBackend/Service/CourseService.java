package com.example.LMSBackend.Service;

import com.example.LMSBackend.Dto.CourseDto;
import com.example.LMSBackend.Model.Course;
import com.example.LMSBackend.Repository.CourseRepository;
import org.apache.catalina.LifecycleState;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseService {
    @Autowired
    private CourseRepository courseRepo;
    @Autowired
    private ModelMapper modelMapper;

    public CourseDto saveCourse(CourseDto courseDto){
           courseRepo.save(modelMapper.map(courseDto, Course.class));
           return courseDto;
    }
    public List<CourseDto> getAllCourses(){
        List<Course> courseList=courseRepo.findAll();
        return modelMapper.map(courseList,new TypeToken<List<CourseDto>>(){}.getType());
    }

    public CourseDto getCourseByCourseID(String courseId){
        Course course= courseRepo.getCourseByCourseID(courseId);
        return modelMapper.map(course,CourseDto.class);

    }

}
