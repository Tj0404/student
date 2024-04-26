package com.example.student.dto;

import com.example.student.entity.Exam;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamDto {
    @NotBlank(message = "학생번호가 입력 되지 않았습니다!")
    private String examNo;
    @Range(min = 0, max = 100, message = "점수는 0점부터 100점까지 입니다.")
    private int kor;
    @Range(min = 0, max = 100, message = "점수는 0점부터 100점까지 입니다.")
    private int math;
    @Range(min = 0, max = 100, message = "점수는 0점부터 100점까지 입니다.")
    private int eng;
    @Range(min = 0, max = 100, message = "점수는 0점부터 100점까지 입니다.")
    private int hist;

    public Exam fromExamDto(ExamDto examDto){
        Exam exam = new Exam();
        exam.setExamNo(examDto.getExamNo());
        exam.setKor(examDto.getKor());
        exam.setMath(examDto.getMath());
        exam.setEng(examDto.getEng());
        exam.setHist(examDto.getHist());
        return exam;
    }

    public static ExamDto fromExam(Exam exam){
        return new ExamDto(
                exam.getExamNo(),
                exam.getKor(),
                exam.getMath(),
                exam.getEng(),
                exam.getHist()
        );
    }

}
