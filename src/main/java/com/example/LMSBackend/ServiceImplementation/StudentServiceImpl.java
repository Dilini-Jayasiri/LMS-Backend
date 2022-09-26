package com.example.LMSBackend.ServiceImplementation;

import com.example.LMSBackend.Dto.StudentDetailsDto;
import com.example.LMSBackend.Model.Student;
import com.example.LMSBackend.Repository.StudentRepository;
import com.example.LMSBackend.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private final StudentRepository studentrepo;

    @Override
    public boolean register(Student newStudent) {
        boolean response = false;
        try{
            studentrepo.save(newStudent);
            response = true;
        }catch (Exception e){
            System.out.println("Student not saved in Repo");
            response = false;
        }
        return response;
    }

    @Override
    public boolean findStudentByCredentials(StudentDetailsDto studentdto) {
        boolean response;
        try {
            Student existing = studentrepo.findStudent(studentdto.getStudentId(), studentdto.getPassword());
            if (existing.getStudentId().equals(studentdto.getStudentId()) && existing.getPassword().equals(studentdto.getPassword())){
                response = true;
            }else {
                response = false;
            }

        }catch (Exception e){
            System.out.println("Student was Not found in service layer");
            response = false;
        }
        return response;
    }
}
