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
    @Id
    private Double UMarks;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course courseId;

    @OneToOne
    @JoinColumn(name = "student_id")
    private User userId;

    // @OneToOne
    // @JoinColumn(name = "marks_id")
    // private Marks marksId;

    public UpdateMarks(Double UMarks, User userId, Course courseId) {
      this.UMarks = UMarks;
    }
}
