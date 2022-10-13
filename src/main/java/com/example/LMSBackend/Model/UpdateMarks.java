package com.example.LMSBackend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class UpdateMarks {

    private Double marks;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course courseId;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student studentId;

    @OneToOne
    @JoinColumn(name = "marks_id")
    private Marks marksId;

    public UpdateMarks(Double marks, Marks marksId, Course courseId, Student studentId) {
      this.marks = marks;
    }
}
