package com.example.student.controller;

import com.example.student.dto.ExamDto;
import com.example.student.dto.ResultDto;
import com.example.student.dto.StudentDto;
import com.example.student.service.StudentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("student")
@Slf4j
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public String homeView(){
        return "pages/home";
    }

    @GetMapping("show")
    public String allView(Model model){
        List<StudentDto> studentDtos = studentService.findAll();
        model.addAttribute("studentDtos", studentDtos);
        return "pages/find_all";
    }

    @GetMapping("insert")
    public String insertForm(Model model){
        model.addAttribute("examDto", new ExamDto());
        return "pages/insert";
    }

    @PostMapping("insert")
    public String insert(@Valid @ModelAttribute("examDto")ExamDto examDto,
                         BindingResult bindingResult,
                         Model model){
        if(bindingResult.hasErrors()){
            log.info("------Validation error -------");
            return "pages/insert";
        }
        model.addAttribute("examDto", new ExamDto());
        log.info("-----result " + examDto);
        studentService.insert(examDto);
        return "redirect:/student";
    }

    @GetMapping("result")
    public String resultView(Model model){
        List<StudentDto> dtoList = studentService.findAllWithExam();
        model.addAttribute("dtos", dtoList);
        return "pages/result";
    }

}
