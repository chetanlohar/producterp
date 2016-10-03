package com.skills.producterp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by chetanlo on 8/10/2016.
 */
public abstract class AbstractJpaDao<T extends Serializable>  {

    private Class<T> clazz;

    EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void persist(T entity){
        entityManager.persist(entity);
    }

    public T find(Long Id){
        return entityManager.find(clazz,Id);
    }

    public List<T> findAll(){
        return entityManager.createQuery("from " + clazz.getName())
                .getResultList();
    }

    public void merge(T entity){
        entityManager.merge(entity);
    }
}
