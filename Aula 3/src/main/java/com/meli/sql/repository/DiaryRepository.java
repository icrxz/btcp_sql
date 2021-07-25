package com.meli.sql.repository;

import com.meli.sql.entity.Diary;

import javax.persistence.EntityManager;

public class DiaryRepository extends Repository<Diary> {
    public DiaryRepository(EntityManager em) {
        super(Diary.class, em);
    }
}
