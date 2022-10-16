package com.example.LMSBackend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity// @Entity annotation indicates that the class is a persistent Java class.
@NoArgsConstructor//@NoArgsConstructor will generate a constructor with no parameters.
@AllArgsConstructor//@NoArgsConstructor will generate a constructor with  parameters.
@Data//impliment getters and setters and to string

public class Course {

    @Id //  @Id annotation is for the primary key.

    //crete a database colums
    private String courseId;
    private String CourseName;
    private String Description;
    private String academicYear;
}
