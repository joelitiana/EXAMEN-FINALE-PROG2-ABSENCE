package com.example.final_exam.controller;

import com.example.final_exam.entity.Absence;
import com.example.final_exam.repository.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/absences")
public class AbsenceController {

    @Autowired
    private AbsenceRepository absenceRepository;

    @GetMapping
    public List<Absence> getAllAbsences() {
        return absenceRepository.getAllAbsences();
    }

    @GetMapping("/{id}")
    public Absence getAbsenceById(@PathVariable int id) {
        return absenceRepository.getAbsenceById(id);
    }

    @PostMapping
    public int createAbsence(@RequestBody Absence absence) {
        return absenceRepository.createAbsence(absence);
    }

    @DeleteMapping("/{id}")
    public int deleteAbsence(@PathVariable int id) {
        return absenceRepository.deleteAbsence(id);
    }
}
