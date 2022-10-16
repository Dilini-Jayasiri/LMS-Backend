package com.example.LMSBackend.Service;

import com.example.LMSBackend.Dto.CourseDto;

import java.util.List;
//impliment interface for course crud operatiions
public interface CourceService {
    public CourseDto saveCourse(CourseDto courseDto);
    public List<CourseDto> getAllCourses();
    public CourseDto getCourseByCourseID(String courseId);
}
