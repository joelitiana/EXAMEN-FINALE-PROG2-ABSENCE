package com.example.final_exam.repository;

import com.example.final_exam.entity.Student;
import java.util.List;

public interface StudentRepository {
    List<Student> getAllStudents();
    Student getStudentById(String idStudents);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(String idStudents);
}