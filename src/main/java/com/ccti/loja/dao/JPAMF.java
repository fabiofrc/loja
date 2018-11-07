package com.ccti.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class JPAMF {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lojaPU");

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

}
