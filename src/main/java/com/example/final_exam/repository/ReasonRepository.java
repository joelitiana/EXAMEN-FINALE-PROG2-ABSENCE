package com.example.final_exam.repository;

import com.example.final_exam.entity.Reason;
import java.util.List;

public interface ReasonRepository {
    List<Reason> getAllReasons();
    Reason getReasonById(int idReason);
    void addReason(Reason reason);
    void updateReason(Reason reason);
    void deleteReason(int idReason);
}