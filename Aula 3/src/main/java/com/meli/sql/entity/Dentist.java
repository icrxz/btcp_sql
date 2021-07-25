package com.meli.sql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dentists")
public class Dentist extends Person {
    @Column(name = "code_mp")
    private String codeMp;

    @OneToMany(mappedBy = "dentist")
    private List<Diary> diaries = new ArrayList<>();

    public String getCodeMp() {
        return codeMp;
    }

    public void setCodeMp(String code_mp) {
        this.codeMp = code_mp;
    }

    public List<Diary> getDiaries() {
        return diaries;
    }

    public void setDiaries(List<Diary> diaries) {
        this.diaries = diaries;
    }

    public Dentist() {
        super();
    }

    public Dentist(String name, String last_name, String address, String dni, LocalDate birth_date, String phone, String email, String codeMp) {
        super(name, last_name, address, dni, birth_date, phone, email);
        this.codeMp = codeMp;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s %s, Endereço: %s, Email: %s, CRM: %s", getName(), getLastName(), getAddress(), getEmail(), getCodeMp());
    }
}
