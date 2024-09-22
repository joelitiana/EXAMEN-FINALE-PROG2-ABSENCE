package com.example.final_exam.controller;

import com.example.final_exam.entity.Cor;
import com.example.final_exam.service.CorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cors")
public class CorController {

    @Autowired
    private CorService corService;

    @GetMapping
    public List<Cor> getAllCors() {
        return corService.getAllCors();
    }

    @GetMapping("/{id}")
    public Cor getCorById(@PathVariable int id) {
        return corService.getCorById(id);
    }

    @PostMapping
    public void createCor(@RequestBody Cor cor) {
        corService.createCor(cor);
    }

    @DeleteMapping("/{id}")
    public void deleteCor(@PathVariable int id) {
        corService.deleteCor(id);
    }
}
