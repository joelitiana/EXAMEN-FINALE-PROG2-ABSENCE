package com.example.final_exam.controller;

import com.example.final_exam.entity.Reason;
import com.example.final_exam.repository.ReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reasons")
public class ReasonController {

    @Autowired
    private ReasonRepository reasonRepository;

    @GetMapping
    public List<Reason> getAllReasons() {
        return reasonRepository.getAllReasons();
    }

    @GetMapping("/{id}")
    public Reason getReasonById(@PathVariable int id) {
        return reasonRepository.getReasonById(id);
    }

    @PostMapping
    public int createReason(@RequestBody Reason reason) {
        return reasonRepository.createReason(reason);
    }

    @DeleteMapping("/{id}")
    public int deleteReason(@PathVariable int id) {
        return reasonRepository.deleteReason(id);
    }
}
