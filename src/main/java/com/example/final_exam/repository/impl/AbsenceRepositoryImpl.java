package com.example.final_exam.repository.impl;

import com.example.final_exam.entity.Absence;
import com.example.final_exam.repository.AbsenceRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class AbsenceRepositoryImpl implements AbsenceRepository {
    private JdbcTemplate jdbcTemplate;

    public AbsenceRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Absence> getAllAbsences() {
        String sql = "SELECT * FROM absence";
        return jdbcTemplate.query(sql, new AbsenceRowMapper());
    }

    @Override
    public Absence getAbsenceById(int idAbsence) {
        String sql = "SELECT * FROM absence WHERE id_absence = ?";
        return jdbcTemplate.queryForObject(sql, new AbsenceRowMapper(), idAbsence);
    }

    @Override
    public void addAbsence(Absence absence) {
        String sql = "INSERT INTO absence (id_absence, id_students, id_course, date, reason) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, absence.getIdAbsence(), absence.getIdStudents(), absence.getIdCourse(), absence.getDate(), absence.getReason());
    }

    @Override
    public void updateAbsence(Absence absence) {
        String sql = "UPDATE absence SET id_students = ?, id_course = ?, date = ?, reason = ? WHERE id_absence = ?";
        jdbcTemplate.update(sql, absence.getIdStudents(), absence.getIdCourse(), absence.getDate(), absence.getReason(), absence.getIdAbsence());
    }

    @Override
    public void deleteAbsence(int idAbsence) {
        String sql = "DELETE FROM absence WHERE id_absence = ?";
        jdbcTemplate.update(sql, idAbsence);
    }

    private static class AbsenceRowMapper implements RowMapper<Absence> {
        @Override
        public Absence mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            Absence absence = new Absence();
            absence.setIdAbsence(rs.getInt("id_absence"));
            absence.setIdStudents(rs.getString("id_students"));
            absence.setIdCourse(rs.getInt("id_course"));
            absence.setDate(rs.getDate("date"));
            absence.setReason(rs.getString("reason"));
            return absence;
        }
    }
}