package com.example.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Exam {
    @Id
    @Column(name = "exam_no", length = 6)
    private String examNo;
    @Column(name = "kor", length = 10)
    private int kor;
    @Column(name = "math", length = 15)
    private int math;
    @Column(name = "eng", length = 4)
    private int eng;
    @Column(name = "hist", length = 20)
    private int hist;

}
