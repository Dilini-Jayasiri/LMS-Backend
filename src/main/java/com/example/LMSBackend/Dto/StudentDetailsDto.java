package com.example.LMSBackend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDetailsDto {
    private Long studentId;
    private String password;

}
