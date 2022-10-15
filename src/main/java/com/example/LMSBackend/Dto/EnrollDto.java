package com.example.LMSBackend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnrollDto {
    private Date enrollDate;
    private String courseId;
    private Long userId;
}
