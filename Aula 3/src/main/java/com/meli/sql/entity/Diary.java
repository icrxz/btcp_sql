package com.meli.sql.entity;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "diarys")
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "ending_time")
    private LocalTime endingTime;

    @ManyToOne
    private Dentist dentist;

    @OneToMany(mappedBy = "diary")
    private List<Turn> turns = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime start_time) {
        this.startTime = start_time;
    }

    public LocalTime getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(LocalTime ending_time) {
        this.endingTime = ending_time;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public List<Turn> getTurns() {
        return turns;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = turns;
    }

    public Diary() {
    }

    public Diary(LocalTime startTime, LocalTime endingTime, Dentist dentist) {
        this.startTime = startTime;
        this.endingTime = endingTime;
        this.dentist = dentist;
    }

    @Override
    public String toString() {
        return String.format("Dentista: %s %s, Hora de inicio: %s, Hora de fim: %s", getDentist().getName(), getDentist().getLastName(), getStartTime(), getEndingTime());
    };
}
