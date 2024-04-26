package com.example.student.service;

import com.example.student.dto.ExamDto;
import com.example.student.dto.ResultDto;
import com.example.student.dto.StudentDto;
import com.example.student.entity.Exam;
import com.example.student.entity.Student;
import com.example.student.repository.ExamRepository;
import com.example.student.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    private final ExamRepository examRepository;
    public StudentService(StudentRepository studentRepository, ExamRepository examRepository) {
        this.studentRepository = studentRepository;
        this.examRepository = examRepository;
    }



    public List<StudentDto> findAll() {
        List<StudentDto> dtos = studentRepository.findAll()
                .stream()
                .map(x -> StudentDto.fromStudent(x))
                .toList();
        return dtos;
    }

    public void insert(ExamDto examDto) {
        Exam exam = examDto.fromExamDto(examDto);
        examRepository.save(exam);
    }

    public List<ExamDto> findExamAll() {
        List<ExamDto> dtos = examRepository.findAll()
                .stream()
                .map(x -> ExamDto.fromExam(x))
                .toList();
        return dtos;
    }

    public List<StudentDto> findAllWithExamPast() {
        List<Student> studentList = studentRepository.findAll();
        StudentDto dto = new StudentDto();
        log.info("##############" + studentList.toString());
        List<StudentDto> dtoList = new ArrayList<>();

        for(Student student : studentList){
            log.info("XXXXXXXXXX " + student.getStudentNo());
            dto.setStudentNo(student.getStudentNo());
            dto.setName(student.getName());
            dto.setPhone(student.getPhone());
            dto.setGender(student.getGender());
            dto.setAddress(student.getAddress());
//            Exam e = examRepository.findById(student.getStudentNo()).orElse(null);
//            ExamDto ex;
//            if (e != null){
//                ex = ExamDto.fromExam(e);
//            } else {
//                ex = null;
//            }
//            dto.setExamDto(ex);

            ExamDto examDto = examRepository.findById(dto.getStudentNo())
                            .map(x -> ExamDto.fromExam(x))
                            .orElse(null);
            dto.setExamDto(examDto);
            dtoList.add(dto);
            dto = new StudentDto();
        }
        log.info("============" + dtoList.toString());
        return dtoList;
    }


    public List<StudentDto> findAllWithExam() {
        List<Student> studentList = studentRepository.findAll();
        StudentDto dto = new StudentDto();
        log.info("##############" + studentList.toString());
        List<StudentDto> dtoList = new ArrayList<>();

        for(Student student : studentList){
            log.info("XXXXXXXXXX " + student.getStudentNo());
            dto.setStudentNo(student.getStudentNo());
            dto.setName(student.getName());
            dto.setPhone(student.getPhone());
            dto.setGender(student.getGender());
            dto.setAddress(student.getAddress());

            ExamDto examDto = examRepository.findById(dto.getStudentNo())
                    .map(x -> ExamDto.fromExam(x))
                    .orElse(null);
            dto.setExamDto(examDto);

            dtoList.add(dto);

            int sumOuter, sumInner;
            for (int i = 0; i <= dtoList.size() - 1; i++) {
                if(dtoList.get(i).getExamDto() == null){
                    continue;
                } else {
                    dtoList.get(i).setRank(1);
                    // 총점 구하고
                    sumOuter = dtoList.get(i).getExamDto().getKor() + dtoList.get(i).getExamDto().getMath() + dtoList.get(i).getExamDto().getEng() + dtoList.get(i).getExamDto().getHist();
                }

                for (int j = 0; j <= dtoList.size() - 1; j++) {

                    if (dtoList.get(j).getExamDto() != null) {
                        sumInner = dtoList.get(j).getExamDto().getKor() + dtoList.get(j).getExamDto().getMath() + dtoList.get(j).getExamDto().getEng() + dtoList.get(j).getExamDto().getHist();
                        if(sumOuter < sumInner){
                            dtoList.get(i).setRank(dtoList.get(i).getRank()+1);
                        }
                    }

                }
            }

            dto = new StudentDto();
        }
        log.info("============" + dtoList.toString());
        return dtoList;
    }



//    public int[] rankView() {
//        int[] ranks = examRepository.rankList();
//
//        return ranks;
//    }

}
