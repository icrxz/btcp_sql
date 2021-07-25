package com.meli.sql.dto;

import com.meli.sql.entity.Dentist;
import com.meli.sql.entity.Turn;
import com.meli.sql.entity.enums.TurnStatusEnum;

import java.time.LocalTime;

public class DentistDiaryDTO {
    private String name;
    private String last_name;
    private Integer day;
    private String pacient;
    private LocalTime startTime;
    private LocalTime endingTime;
    private TurnStatusEnum status;

    public DentistDiaryDTO(String name, String last_name, Integer day, String pacient, LocalTime startTime, LocalTime endingTime, TurnStatusEnum status) {
        this.name = name;
        this.last_name = last_name;
        this.day = day;
        this.pacient = pacient;
        this.startTime = startTime;
        this.endingTime = endingTime;
        this.status = status;
    }

    public DentistDiaryDTO(Turn turn) {
        this.name = turn.getDiary().getDentist().getName();
        this.last_name = turn.getDiary().getDentist().getLastName();
        this.day = turn.getDay();
        this.pacient = turn.getPatient().getName();
        this.startTime = turn.getDiary().getStartTime();
        this.endingTime = turn.getDiary().getEndingTime();
        this.status = turn.getTurn_status().getName();
    }

    @Override
    public String toString() {
        return String.format("Nome: %s %s - Paciente: %s - Dia: %d - Hora de inicio: %s - Hora de fim: %s - Status: %s", name, last_name, pacient, day, startTime, endingTime, status);
    }
}
