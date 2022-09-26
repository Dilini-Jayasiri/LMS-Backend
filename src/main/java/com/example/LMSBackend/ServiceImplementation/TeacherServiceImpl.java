package com.example.LMSBackend.ServiceImplementation;

import com.example.LMSBackend.Dto.TeacherDetailsDto;
import com.example.LMSBackend.Model.Teacher;
import com.example.LMSBackend.Repository.TeacherRepository;
import com.example.LMSBackend.Service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private final TeacherRepository teacherrepo;

    @Override
    public boolean TeacherRegister(Teacher newTeacher) {
        boolean response;
        try {
            teacherrepo.save(newTeacher);
            response = true;
        }catch (Exception e){
            System.out.println("Couldn't save Teacher in Service Layer");
            response = false;
        }
        return response;
    }

    @Override
    public boolean FindTeacher(TeacherDetailsDto teacherdetailsdto) {
        boolean response;
        try {
            Teacher existingTeacher = teacherrepo.findTeacher(teacherdetailsdto.getTeacherId(), teacherdetailsdto.getPassword());
            if (existingTeacher.getTeacherId().equals(teacherdetailsdto.getTeacherId()) && existingTeacher.getPassword().equals(teacherdetailsdto.getPassword())){
                response = true;
            }else {
                response = false;
            }
        }catch (Exception e){
            System.out.println("Teacher Not found in Service Layer");
            response = false;
        }
        return response;
    }


}
