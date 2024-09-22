package com.example.final_exam.controller;

import com.example.final_exam.entity.Student;
import com.example.final_exam.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentRepository.getStudentById(id);
    }

    @PostMapping
    public int createStudent(@RequestBody Student student) {
        return studentRepository.createStudent(student);
    }

    @DeleteMapping("/{id}")
    public int deleteStudent(@PathVariable String id) {
        return studentRepository.deleteStudent(id);
    }
}
