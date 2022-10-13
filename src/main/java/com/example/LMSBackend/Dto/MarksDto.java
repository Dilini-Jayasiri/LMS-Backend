package com.example.LMSBackend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarksDto {
    private Double marks;
    private String courseId;
    private Long studentId;
}
