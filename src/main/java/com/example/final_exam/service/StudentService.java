package com.example.final_exam.service;

import com.example.final_exam.entity.Student;
import com.example.final_exam.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public Student getStudentById(String id) {
        return studentRepository.getStudentById(id);
    }

    public void createStudent(Student student) {
        studentRepository.createStudent(student);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteStudent(id);
    }
}
