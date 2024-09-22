package com.example.final_exam.entity;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Reason {
    private int idReason;
    private int idAbsence;
    private String reasonDescription;
    private LocalDate reasonDate;
}