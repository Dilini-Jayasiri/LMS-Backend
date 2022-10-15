package com.example.LMSBackend.ServiceImplementation;

import com.example.LMSBackend.Dto.EnrollDto;
import com.example.LMSBackend.Model.Course;
import com.example.LMSBackend.Model.StudentCourseEnroll;
import com.example.LMSBackend.Model.User;
import com.example.LMSBackend.Repository.CourseRepository;
import com.example.LMSBackend.Repository.EnrollRepository;
import com.example.LMSBackend.Repository.UserRepository;
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
    private final UserRepository userrepo;

    @Override
    public boolean enroll(EnrollDto newEnrollment) {
        boolean response = false;
        try {
            // find relevant course module
            Optional<Course> existingCourse = courserepo.findById(newEnrollment.getCourseId());
            // find relevant user by user number
            Optional<User> existingUser = userrepo.findById(newEnrollment.getUserId());
            // creating enroll object
            StudentCourseEnroll newEnroll = new StudentCourseEnroll(newEnrollment.getEnrollDate(), existingCourse.get(), existingUser.get());
            enrollrepo.save(newEnroll);
            response = true;
        }catch (Exception e){
            System.out.println("Exception in Enroll service layer");
        }
        return response;
    }
}
