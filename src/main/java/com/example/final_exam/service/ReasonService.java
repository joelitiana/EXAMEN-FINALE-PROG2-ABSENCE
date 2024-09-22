package com.example.final_exam.service;

import com.example.final_exam.entity.Reason;
import com.example.final_exam.repository.ReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReasonService {

    @Autowired
    private ReasonRepository reasonRepository;

    public List<Reason> getAllReasons() {
        return reasonRepository.getAllReasons();
    }

    public Reason getReasonById(int id) {
        return reasonRepository.getReasonById(id);
    }

    public void createReason(Reason reason) {
        reasonRepository.createReason(reason);
    }

    public void deleteReason(int id) {
        reasonRepository.deleteReason(id);
    }
}
