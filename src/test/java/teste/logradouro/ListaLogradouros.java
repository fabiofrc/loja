/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.logradouro;

import com.ccti.loja.facade.LogradouroFacade;
import com.ccti.loja.model.Logradouro;
import java.util.List;

/**
 *
 * @author PMBV-164029
 */
public class ListaLogradouros {

    public static void main(String[] args) {
        LogradouroFacade logradouroFacade = new LogradouroFacade();
        List<Logradouro> logradouros = logradouroFacade.getAll();

        for (Logradouro l : logradouros) {
            System.out.println(l.getNome() + " Location: " + l.getGeom());
        }

    }
}
