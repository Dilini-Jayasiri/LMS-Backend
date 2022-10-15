package com.example.LMSBackend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentCourseEnroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollId;

    private Date enrollDate;
    @OneToOne
    @JoinColumn(name = "course_id")
    private Course courseId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User UserId;

    public StudentCourseEnroll(Date enrollDate, Course courseId, User userId) {
        this.enrollDate = enrollDate;
        this.courseId = courseId;
        this.UserId = userId;
    }
}
