package com.example.final_exam.repository.impl;

import com.example.final_exam.entity.Cor;
import com.example.final_exam.repository.CorRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class CorRepositoryImpl implements CorRepository {
    private JdbcTemplate jdbcTemplate;

    public CorRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Cor> getAllCors() {
        String sql = "SELECT * FROM cor";
        return jdbcTemplate.query(sql, new CorRowMapper());
    }

    @Override
    public Cor getCorById(int idCor) {
        String sql = "SELECT * FROM cor WHERE id_cor = ?";
        return jdbcTemplate.queryForObject(sql, new CorRowMapper(), idCor);
    }

    @Override
    public void addCor(Cor cor) {
        String sql = "INSERT INTO cor (id_cor, id_students, id_course) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, cor.getIdCor(), cor.getIdStudents(), cor.getIdCourse());
    }

    @Override
    public void updateCor(Cor cor) {
        String sql = "UPDATE cor SET id_students = ?, id_course = ? WHERE id_cor = ?";
        jdbcTemplate.update(sql, cor.getIdStudents(), cor.getIdCourse(), cor.getIdCor());
    }

    @Override
    public void deleteCor(int idCor) {
        String sql = "DELETE FROM cor WHERE id_cor = ?";
        jdbcTemplate.update(sql, idCor);
    }

    private static class CorRowMapper implements RowMapper<Cor> {
        @Override
        public Cor mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            Cor cor = new Cor();
            cor.setIdCor(rs.getInt("id_cor"));
            cor.setIdStudents(rs.getString("id_students"));
            cor.setIdCourse(rs.getInt("id_course"));
            return cor;
        }
    }
}