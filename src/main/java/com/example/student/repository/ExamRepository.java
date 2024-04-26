package com.example.student.repository;

import com.example.student.dto.ResultDto;
import com.example.student.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, String> {
}
