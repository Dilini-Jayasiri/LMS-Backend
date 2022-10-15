package com.example.LMSBackend.ServiceImplementation;

import com.example.LMSBackend.Dto.GetMarksDto;
import com.example.LMSBackend.Dto.MarksDto;
import com.example.LMSBackend.Model.*;
import com.example.LMSBackend.Repository.CourseRepository;
import com.example.LMSBackend.Repository.MarksRepository;
import com.example.LMSBackend.Repository.UserRepository;
import com.example.LMSBackend.Service.MarksService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private final UserRepository userrepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean marks(MarksDto newMarks) {
        boolean response = false;
        try {
            // find relevant course module
            Optional<Course> existingCourse = courserepo.findById(newMarks.getCourseId());
            // find relevant user by user ID
            Optional<User> existingUser = userrepo.findById(newMarks.getUserId());
            // creating marks object
            Marks newMark = new Marks(newMarks.getMarks(), existingCourse.get(), existingUser.get());
            marksrepo.save(newMark);
            response = true;
        } catch (Exception e) {
            System.out.println("Exception in Marks service layer");
        }
        return response;

    }

    @Override
    public List<GetMarksDto> getStudentMarks(Long userId) {
        List<Marks> marksList = marksrepo.getMarksById(userId);
        List<GetMarksDto> responsemarkslist = new ArrayList<>();
        for (Marks mark : marksList) {
            responsemarkslist.add(new GetMarksDto(mark.getMarks(), mark.getCourseId().getCourseName(),
                    mark.getUserId().getUserId(), mark.getUserId().getName()));
        }
        return responsemarkslist;
    }

    @Override
    public boolean updateMarks(MarksDto updatedMarks) {
        boolean response = false;
        try {
            Marks findMarks = marksrepo.updateMarks(updatedMarks.getUserId(), updatedMarks.getCourseId());
            findMarks.setMarks(updatedMarks.getMarks());
            marksrepo.save(findMarks);
            response = true;
        } catch (Exception e) {
            System.out.println("Exeption in Update Marks in Service Layer");
        }
        return response;
    }

}
