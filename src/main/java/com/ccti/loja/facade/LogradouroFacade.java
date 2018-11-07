package com.ccti.loja.facade;

import com.ccti.loja.dao.GenericDAOImp;
import com.ccti.loja.dao.JPAMF;
import com.ccti.loja.model.Logradouro;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class LogradouroFacade extends GenericDAOImp<Logradouro> implements Serializable {

    public LogradouroFacade() {
        super(Logradouro.class);
    }

    EntityManager em = new JPAMF().getEntityManager();

    public long contaTotal() {
        Query q = em.createQuery("select count(c) from Logradouro c");
        long contador = (long) q.getSingleResult();
        return contador;
    }

    public Logradouro buscaByCep(String cep) {
        Query q = em.createQuery("select DISTINCT(c.cep) from Logradouro c WHERE c.cep = :cep");
        q.setParameter("cep", cep);
        return (Logradouro) q.getSingleResult();
    }

    public Logradouro buscaById(Long id) {
        Query q = em.createQuery("select c from Logradouro c WHERE c.id = :id");
        q.setParameter("id", id);
        return (Logradouro) q.getSingleResult();
    }
}
