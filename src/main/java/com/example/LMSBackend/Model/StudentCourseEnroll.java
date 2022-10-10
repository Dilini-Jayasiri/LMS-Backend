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
    @JoinColumn(name = "course_id_course_id")
    private Course courseId;

    @OneToOne
    @JoinColumn(name = "student_id_student_id")
    private Student studentId;

    public StudentCourseEnroll(Date enrollDate, Course courseId, Student studentId) {
        this.enrollDate = enrollDate;
        this.courseId = courseId;
        this.studentId = studentId;
    }
}
