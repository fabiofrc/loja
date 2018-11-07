package com.ccti.loja.facade;

import com.ccti.loja.dao.GenericDAOImp;
import com.ccti.loja.dao.JPAMF;
import com.ccti.loja.model.Bairro;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class BairroFacade extends GenericDAOImp<Bairro> implements Serializable {

    public BairroFacade() {
        super(Bairro.class);
    }

    EntityManager em = new JPAMF().getEntityManager();

    public long contaEnderecoTotal() {
        Query q = em.createQuery("select count(c) from Bairro c");
        long contador = (long) q.getSingleResult();
        return contador;
    }
}
