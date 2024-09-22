package com.example.final_exam.repository;

import com.example.final_exam.entity.Cor;
import java.util.List;

public interface CorRepository {
    List<Cor> getAllCors();
    Cor getCorById(int idCor);
    void addCor(Cor cor);
    void updateCor(Cor cor);
    void deleteCor(int idCor);
}