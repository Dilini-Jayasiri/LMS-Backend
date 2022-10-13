package com.example.LMSBackend.Dto;

import com.example.LMSBackend.Model.Course;
import com.example.LMSBackend.Model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnrollDto {
    private Date enrollDate;
    private String courseId;
    private Long userId;
}
