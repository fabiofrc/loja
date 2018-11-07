package com.ccti.loja.facade;

import com.ccti.loja.dao.GenericDAOImp;
import com.ccti.loja.dao.JPAMF;
import com.ccti.loja.model.Endereco;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EnderecoFacade extends GenericDAOImp<Endereco> implements Serializable {

    public EnderecoFacade() {
        super(Endereco.class);
    }

    EntityManager em = new JPAMF().getEntityManager();

    public long contaTotal() {
        Query q = em.createQuery("select count(c) from Endereco c");
        long contador = (long) q.getSingleResult();
        return contador;
    }
}
