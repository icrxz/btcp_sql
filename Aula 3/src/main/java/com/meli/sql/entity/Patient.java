package com.meli.sql.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient extends Person {
    @OneToMany(mappedBy = "patient")
    private List<Turn> turns = new ArrayList<>();

    public List<Turn> getTurns() {
        return turns;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = turns;
    }

    public Patient() {
        super();
    }

    public Patient(String name, String last_name, String address, String dni, LocalDate birth_date, String phone, String email) {
        super(name, last_name, address, dni, birth_date, phone, email);
    }

    @Override
    public String toString() {
        return String.format("Nome: %s %s - CPF: %s - Email: %s", getName(), getLastName(), getDni(), getEmail());
    }
}
