package com.example.final_exam.service;

import com.example.final_exam.entity.Course;
import com.example.final_exam.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    public Course getCourseById(int id) {
        return courseRepository.getCourseById(id);
    }

    public void createCourse(Course course) {
        courseRepository.createCourse(course);
    }

    public void deleteCourse(int id) {
        courseRepository.deleteCourse(id);
    }
}
