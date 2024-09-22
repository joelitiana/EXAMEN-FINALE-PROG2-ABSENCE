package com.example.final_exam.entity;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Absence {
    private int idAbsence;
    private String idStudents;
    private int idCourse;
    private LocalDate absenceDate;
    private String reason;
}