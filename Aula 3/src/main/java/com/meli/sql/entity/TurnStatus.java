package com.meli.sql.entity;

import com.meli.sql.entity.enums.TurnStatusEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "turn_status")
public class TurnStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TurnStatusEnum name;

    private String description;

    @OneToMany(mappedBy = "turn_status")
    private List<Turn> turns = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TurnStatusEnum getName() {
        return name;
    }

    public void setName(TurnStatusEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Turn> getTurns() {
        return turns;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = turns;
    }

    public TurnStatus() {
    }

    public TurnStatus(TurnStatusEnum name, String description) {
        this.name = name;
        this.description = description;
    }
}
