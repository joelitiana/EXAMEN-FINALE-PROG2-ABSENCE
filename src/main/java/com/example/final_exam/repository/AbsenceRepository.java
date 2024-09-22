package com.example.final_exam.repository;

import com.example.final_exam.entity.Absence;
import java.util.List;

public interface AbsenceRepository {
    List<Absence> getAllAbsences();
    Absence getAbsenceById(int idAbsence);
    void addAbsence(Absence absence);
    void updateAbsence(Absence absence);
    void deleteAbsence(int idAbsence);
}