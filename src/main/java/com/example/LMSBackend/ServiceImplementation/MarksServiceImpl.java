package com.example.LMSBackend.ServiceImplementation;

import com.example.LMSBackend.Dto.GetMarksDto;
import com.example.LMSBackend.Dto.MarksDto;
import com.example.LMSBackend.Model.Course;
import com.example.LMSBackend.Model.Marks;
import com.example.LMSBackend.Model.Student;
import com.example.LMSBackend.Model.StudentCourseEnroll;
import com.example.LMSBackend.Repository.CourseRepository;
import com.example.LMSBackend.Repository.MarksRepository;
import com.example.LMSBackend.Repository.StudentRepository;
import com.example.LMSBackend.Service.MarksService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.internal.bytebuddy.description.method.MethodDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional

public class MarksServiceImpl implements MarksService {

    @Autowired
    private final MarksRepository marksrepo;

    @Autowired
    private final CourseRepository courserepo;

    @Autowired
    private final StudentRepository studentrepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean marks(MarksDto newMarks) {
        boolean response = false;
        try {
            // find relevant course module
            Optional<Course> existingCourse = courserepo.findById(newMarks.getCourseId());
            // find relevant student by Student number
            Optional<Student> existingStudent = studentrepo.findById(newMarks.getStudentId());
            // creating marks object
            Marks newMark = new Marks(newMarks.getMarks(), existingCourse.get(), existingStudent.get());
            marksrepo.save(newMark);
            response = true;
        }catch (Exception e){
            System.out.println("Exception in Marks service layer");
        }
        return response;

    }

    @Override
    public List<GetMarksDto> getStudentMarks(Long studentId) {
        List<Marks> marksList = marksrepo.getMarksById(studentId);
        List<GetMarksDto> responsemarkslist = new ArrayList<>();
        for (Marks mark:marksList) {
            responsemarkslist.add(new GetMarksDto(mark.getMarks(), mark.getCourseId().getCourseName(), mark.getStudentId().getStudentId(), mark.getStudentId().getName() ));
        }
        return responsemarkslist;
    }


}
