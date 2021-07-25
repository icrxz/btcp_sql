package com.meli.sql.repository;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;

public abstract class Repository<T> {
    protected final Class<T> cls;

    protected EntityManager manager;

    public Repository(Class<T> cls, EntityManager em) {
        this.cls = cls;
        this.manager = em;
    }

    public void save(T object) {
        manager.persist(object);
    }

    public void saveAll(Collection<T> objectList) {
        objectList.forEach(obj -> manager.persist(obj));
    }

    public T findOne( Long id ){
        return manager.find(cls, id);
    }

    public List<T> findAll(){
        return manager.createQuery("from " + cls.getName()).getResultList();
    }
}
