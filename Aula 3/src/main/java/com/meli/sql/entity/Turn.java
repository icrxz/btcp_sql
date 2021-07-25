package com.meli.sql.entity;

import javax.persistence.*;

@Entity
@Table(name = "turns")
public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int day;

    @ManyToOne
    private Diary diary; //id_diary

    @ManyToOne
    private TurnStatus turn_status; //id_turn_status

    @ManyToOne
    private Patient patient; // id_patient

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }

    public TurnStatus getTurn_status() {
        return turn_status;
    }

    public void setTurn_status(TurnStatus turn_status) {
        this.turn_status = turn_status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Turn() {
    }

    public Turn(int day, Diary diary, TurnStatus turn_status, Patient patient) {
        this.day = day;
        this.diary = diary;
        this.turn_status = turn_status;
        this.patient = patient;
    }

    @Override
    public String toString() {
        return String.format("Dia: %d, Paciente: %s, Status: %s, Dentista: %s", getDay(), getPatient().getName(), getTurn_status().getName(), getDiary().getDentist().getName());
    }
}
