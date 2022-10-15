package com.example.LMSBackend.Service;

import com.example.LMSBackend.Dto.EnrollDto;

public interface EnrollService {
    boolean enroll(EnrollDto newEnrollment);
}
