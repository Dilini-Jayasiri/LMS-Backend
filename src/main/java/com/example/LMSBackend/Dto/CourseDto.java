package com.example.LMSBackend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@NoArgsConstructor //add a constructor with parameters 
@AllArgsConstructor//add a constructor non parameters 
@Data //add getters setters ,tostring

//map forntend data
public class CourseDto {
    private String courseId;
    private String CourseName;
    private String Description;
    private String academicYear;
}
