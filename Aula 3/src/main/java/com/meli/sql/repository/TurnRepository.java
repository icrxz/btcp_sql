package com.meli.sql.repository;

import com.meli.sql.entity.Patient;
import com.meli.sql.entity.Turn;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class TurnRepository extends Repository<Turn> {
    public TurnRepository(EntityManager em) {
        super(Turn.class, em);
    }

    public List<Turn> getAllClosedTurns() {
        TypedQuery<Turn> qry = this.manager.createQuery("from Turn where turn_status.name = 'CONCLUIDO' OR turn_status.name = 'CANCELADO'", this.cls);

        return qry.getResultList();
    }

    public List<Turn> getPendingTurnsAtDay(int day) {
        TypedQuery<Turn> qry = this.manager.createQuery("from Turn where turn_status.name = 'PENDENTE' and day =: tDay", this.cls);
        qry.setParameter("tDay", day);

        return qry.getResultList();
    }

    public List<Turn> getRescheduledTurnsByDentist(long dentistId) {
        TypedQuery<Turn> qry = this.manager.createQuery("from Turn where turn_status.name = 'REMARCADO' and diary.dentist.id =: dentistId", this.cls);
        qry.setParameter("dentistId", dentistId);

        return qry.getResultList();
    }

    public List<Turn> getAllRescheduledTurns() {
        TypedQuery<Turn> qry = this.manager.createQuery("from Turn where turn_status.name = 'REMARCADO'", this.cls);

        return qry.getResultList();
    }
}
