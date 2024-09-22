package com.example.final_exam.repository;

import com.example.final_exam.entity.Course;
import java.util.List;

public interface CourseRepository {
    List<Course> getAllCourses();
    Course getCourseById(int idCourse);
    void addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(int idCourse);
    void createCourse(Course course);
}