package com.meli.sql.repository;

import com.meli.sql.entity.TurnStatus;

import javax.persistence.EntityManager;

public class TurnStatusRepository extends Repository<TurnStatus> {
    public TurnStatusRepository(EntityManager em) {
        super(TurnStatus.class, em);
    }
}
