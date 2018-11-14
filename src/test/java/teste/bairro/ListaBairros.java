/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.bairro;

import com.ccti.loja.facade.BairroFacade;
import com.ccti.loja.model.Bairro;
import com.vividsolutions.jts.geom.Coordinate;
import java.util.List;
import org.postgis.Geometry;

/**
 *
 * @author PMBV-164029
 */
public class ListaBairros {
    public static void main(String[] args) {
        BairroFacade bairroFacade = new BairroFacade();
        List<Bairro> bairros = bairroFacade.getAll();
        
        for (Bairro bairro : bairros) {
              System.out.println(bairro.getNome());
        }
        
        
      
    }
}
