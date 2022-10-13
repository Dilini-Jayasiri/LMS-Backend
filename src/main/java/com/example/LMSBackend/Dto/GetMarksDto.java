package com.example.LMSBackend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetMarksDto {
    private double marks;
    private String courseName;
    private Long studentId;
    private String name;

}
