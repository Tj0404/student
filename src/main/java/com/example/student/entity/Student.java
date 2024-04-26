package com.example.student.entity;

import com.example.student.gender.Gender;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Student {
    @Id
    @Column(name = "student_no", length = 6)
    private String studentNo;
    @Column(name = "name", length = 10)
    private String name;
    @Column(name = "phone", length = 15)
    private String phone;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "address", length = 20)
    private String address;
}
