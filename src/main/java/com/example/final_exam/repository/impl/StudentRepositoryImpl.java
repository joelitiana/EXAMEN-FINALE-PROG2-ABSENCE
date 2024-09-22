package com.example.final_exam.repository.impl;

import com.example.final_exam.entity.Student;
import com.example.final_exam.repository.StudentRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private JdbcTemplate jdbcTemplate;

    public StudentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    @Override
    public Student getStudentById(String idStudents) {
        String sql = "SELECT * FROM students WHERE id_students = ?";
        return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), idStudents);
    }

    @Override
    public void addStudent(Student student) {
        String sql = "INSERT INTO students (id_students, firstname, lastname, email, phone, class) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, student.getIdStudents(), student.getFirstname(), student.getLastname(), student.getEmail(), student.getPhone(), student.getClass());
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "UPDATE students SET firstname = ?, lastname = ?, email = ?, phone = ?, class = ? WHERE id_students = ?";
        jdbcTemplate.update(sql, student.getFirstname(), student.getLastname(), student.getEmail(), student.getPhone(), student.getClass(), student.getIdStudents());
    }

    @Override
    public void deleteStudent(String idStudents) {
        String sql = "DELETE FROM students WHERE id_students = ?";
        jdbcTemplate.update(sql, idStudents);
    }

    private static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            Student student = new Student();
            student.setIdStudents(rs.getString("id_students"));
            student.setFirstname(rs.getString("firstname"));
            student.setLastname(rs.getString("lastname"));
            student.setEmail(rs.getString("email"));