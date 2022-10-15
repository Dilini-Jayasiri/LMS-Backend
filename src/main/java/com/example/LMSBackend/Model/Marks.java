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
    @JoinColumn(name = "user_id")
    private User userId;

    public Marks(Double marks, Course courseId, User userId) {
        this.marks = marks;
        this.courseId = courseId;
        this.userId = userId;
    }

    public Marks(Course courseId, User userId) {
        this.courseId = courseId;
        this.userId = userId;
    }

}
