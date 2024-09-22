package com.example.final_exam.repository.impl;

import com.example.final_exam.entity.Reason;
import com.example.final_exam.repository.ReasonRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class ReasonRepositoryImpl implements ReasonRepository {
    private JdbcTemplate jdbcTemplate;

    public ReasonRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Reason> getAllReasons() {
        String sql = "SELECT * FROM reason";
        return jdbcTemplate.query(sql, new ReasonRowMapper());
    }

    @Override
    public Reason getReasonById(int idReason) {
        String sql = "SELECT * FROM reason WHERE id_reason = ?";
        return jdbcTemplate.queryForObject(sql, new ReasonRowMapper(), idReason);
    }

    @Override
    public void addReason(Reason reason) {
        String sql = "INSERT INTO reason (id_reason, description) VALUES (?, ?)";
        jdbcTemplate.update(sql, reason.getIdReason(), reason.getDescription());
    }

    @Override
    public void updateReason(Reason reason) {
        String sql = "UPDATE reason SET description = ? WHERE id_reason = ?";
        jdbcTemplate.update(sql, reason.getDescription(), reason.getIdReason());
    }

    @Override
    public void deleteReason(int idReason) {
        String sql = "DELETE FROM reason WHERE id_reason = ?";
        jdbcTemplate.update(sql, idReason);
    }

    private static class ReasonRowMapper implements RowMapper<Reason> {
        @Override
        public Reason mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            Reason reason = new Reason();
            reason.setIdReason(rs.getInt("id_reason"));
            reason.setDescription(rs.getString("description"));
            return reason;
        }
    }
}