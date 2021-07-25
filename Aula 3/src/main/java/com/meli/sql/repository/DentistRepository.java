package com.meli.sql.repository;

import com.meli.sql.dto.DentistDiaryDTO;
import com.meli.sql.entity.Dentist;
import com.meli.sql.entity.Turn;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class DentistRepository extends Repository<Dentist> {
    public DentistRepository(EntityManager em) {
        super(Dentist.class, em);
    }

    public List<Dentist> getDentistWithMoreThan2TurnAtDay(int day) {
        String qryString = "SELECT de FROM Dentist de INNER JOIN de.diaries di INNER JOIN di.turns t WHERE t.day =: tDay GROUP BY de.id HAVING COUNT(t.id) > 2";
        TypedQuery<Dentist> qry = this.manager.createQuery(qryString, this.cls);
        qry.setParameter("tDay", day);

        return qry.getResultList();
    }

    public List<DentistDiaryDTO> getDentistDiary(long id) {
        String qryString = "SELECT t FROM Dentist d INNER JOIN d.diaries di INNER JOIN di.turns t INNER JOIN t.patient p WHERE d.id =: dId";
        TypedQuery<Turn> qry = this.manager.createQuery(qryString, Turn.class);
        qry.setParameter("dId", id);

        return qry.getResultList().stream().map(DentistDiaryDTO::new).collect(Collectors.toList());
    }
}
