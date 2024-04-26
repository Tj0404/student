package com.example.student.dto;

import com.example.student.service.StudentService;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResultDto {


    private String studentNo;
    private String name;
    private int kor;
    private int math;
    private int eng;
    private int hist;
    private int sum;
    private int avg;
    private int rank;



}
