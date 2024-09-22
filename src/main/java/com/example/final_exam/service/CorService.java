package com.example.final_exam.service;

import com.example.final_exam.entity.Cor;
import com.example.final_exam.repository.CorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorService {

    @Autowired
    private CorRepository corRepository;

    public List<Cor> getAllCors() {
        return corRepository.getAllCors();
    }

    public Cor getCorById(int id) {
        return corRepository.getCorById(id);
    }

    public void createCor(Cor cor) {
        corRepository.createCor(cor);
    }

    public void deleteCor(int id) {
        corRepository.deleteCor(id);
    }
}
