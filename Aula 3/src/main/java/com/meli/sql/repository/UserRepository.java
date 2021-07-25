package com.meli.sql.repository;

import com.meli.sql.entity.User;

import javax.persistence.EntityManager;

public class UserRepository extends Repository<User> {
    public UserRepository(EntityManager em) {
        super(User.class, em);
    }
}
