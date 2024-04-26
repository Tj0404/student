package com.example.student.dto;

import com.example.student.entity.Student;
import com.example.student.gender.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class StudentDto {
    private String studentNo;
    private String name;
    private String phone;
    private Gender gender;
    private String address;
    private ExamDto examDto;
    private int rank;


    public StudentDto(String studentNo, String name, String phone, Gender gender, String address, ExamDto examDto) {
        this.studentNo = studentNo;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.examDto = examDto;
    }

    public StudentDto(String studentNo, String name, String phone, Gender gender, String address) {
        this.studentNo = studentNo;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
    }

    public static StudentDto fromStudent(Student student){
        return new StudentDto(
                student.getStudentNo(),
                student.getName(),
                student.getPhone(),
                student.getGender(),
                student.getAddress()
        );
    }

    public Student fromStudentDto(StudentDto dto){
        Student student = new Student();
        student.setStudentNo(dto.getStudentNo());
        student.setName(dto.getName());
        student.setPhone(dto.getPhone());
        student.setGender(dto.getGender());
        student.setAddress(dto.getAddress());
        return student;
    }


}
