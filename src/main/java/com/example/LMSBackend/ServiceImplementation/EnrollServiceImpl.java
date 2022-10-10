package com.example.LMSBackend.ServiceImplementation;

import com.example.LMSBackend.Dto.EnrollDto;
import com.example.LMSBackend.Model.Course;
import com.example.LMSBackend.Model.Student;
import com.example.LMSBackend.Model.StudentCourseEnroll;
import com.example.LMSBackend.Repository.CourseRepository;
import com.example.LMSBackend.Repository.EnrollRepository;
import com.example.LMSBackend.Repository.StudentRepository;
import com.example.LMSBackend.Service.EnrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class EnrollServiceImpl implements EnrollService {
    @Autowired
    private final EnrollRepository enrollrepo;
    @Autowired
    private final CourseRepository courserepo;
    @Autowired
    private final StudentRepository studentrepo;

    @Override
    public boolean enroll(EnrollDto newEnrollment) {
        boolean response = false;
        try {
            // find relevant course module
            Optional<Course> existingCourse = courserepo.findById(newEnrollment.getCourseId());
            // find relevant student by Student number
            Optional<Student> existingStudent = studentrepo.findById(newEnrollment.getStudentId());
            // creating enroll object
            StudentCourseEnroll newEnroll = new StudentCourseEnroll(newEnrollment.getEnrollDate(), existingCourse.get(), existingStudent.get());
            enrollrepo.save(newEnroll);
            response = true;
        }catch (Exception e){
            System.out.println("Exception in Enroll service layer");
        }
        return response;
    }
}
