package com.meli.sql.repository;

import com.meli.sql.entity.Patient;
import com.meli.sql.entity.Turn;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class PatientRepository extends Repository<Patient> {
    public PatientRepository(EntityManager em) {
        super(Patient.class, em);
    }

    public List<Patient> getAllPatientsTreated(int day) {
        String qryString = "SELECT DISTINCT pa FROM Patient pa INNER JOIN pa.turns t INNER JOIN t.turn_status ts WHERE t.day =: tDay AND ts.id = 1";
        TypedQuery<Patient> qry = this.manager.createQuery(qryString, this.cls);
        qry.setParameter("tDay", day);

        return qry.getResultList();
    }

}
