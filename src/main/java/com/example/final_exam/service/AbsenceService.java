package com.example.final_exam.service;

import com.example.final_exam.entity.Absence;
import com.example.final_exam.repository.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenceService {

    @Autowired
    private AbsenceRepository absenceRepository;

    public List<Absence> getAllAbsences() {
        return absenceRepository.getAllAbsences();
    }

    public Absence getAbsenceById(int id) {
        return absenceRepository.getAbsenceById(id);
    }

    public void createAbsence(Absence absence) {
        absenceRepository.createAbsence(absence);
    }

    public void deleteAbsence(int id) {
        absenceRepository.deleteAbsence(id);
    }
}
