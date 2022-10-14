package com.example.LMSBackend.ServiceImplementation;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LMSBackend.Dto.UpdateMarksDto;
import com.example.LMSBackend.Model.Course;
import com.example.LMSBackend.Model.Marks;
import com.example.LMSBackend.Model.UpdateMarks;
import com.example.LMSBackend.Model.User;
import com.example.LMSBackend.Repository.CourseRepository;
import com.example.LMSBackend.Repository.UpdateMarksRepository;
import com.example.LMSBackend.Repository.UserRepository;
import com.example.LMSBackend.Service.UpdateMarksService;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
@RequiredArgsConstructor
@Transactional

public class UpdateMarksServiceImpl implements UpdateMarksService {

  @Autowired
  private final UpdateMarksRepository updatemarksrepo;

  @Autowired
  private final CourseRepository courserepo;

  @Autowired
  private final UserRepository userrepo;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public boolean marks(UpdateMarksDto updateMarks) {
    boolean response = false;
    try {
      // find relevant course module
      java.util.Optional<Course> existingCourse = courserepo.findById(updateMarks.getCourseId());
      // find relevant user by user ID
      Optional<User> existingUser = userrepo.findById(updateMarks.getUserId());
      // creating marks object
      UpdateMarks updateMark = new UpdateMarks(updateMarks.getUMarks(), existingUser.get(), existingCourse.get());
      updatemarksrepo.save(updateMark);
      response = true;
    } catch (Exception e) {
      System.out.println("Exception in UpdateMarks service layer");
    }
    return response;
  }

  @Override
  public void updateStudentMarks(Long userId, String courseId) {
    List<UpdateMarks> marksList = updatemarksrepo.getUpdateMarksById(userId, courseId);
    for (UpdateMarks mark : marksList) {
      responsemarkslist.add(new UpdateMarksDto(mark.getUMarks(), mark.getCourseId(), mark.getUserId()));
    }
    // if(userId != null && courseId != null){
    // }
  }

}
