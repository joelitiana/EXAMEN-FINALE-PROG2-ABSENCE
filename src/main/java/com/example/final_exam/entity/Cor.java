package com.example.final_exam.entity;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Cor {
    private int idCor;
    private String idStudents;
    private LocalDate convocationDate;
}