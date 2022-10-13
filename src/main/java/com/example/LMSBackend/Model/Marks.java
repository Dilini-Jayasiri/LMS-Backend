package com.example.LMSBackend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long marksId;

    private Double marks;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course courseId;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student studentId;

    public Marks(Double marks, Course courseId, Student studentId) {
        this.marks = marks;
        this.courseId = courseId;
        this.studentId = studentId;
    }
}
