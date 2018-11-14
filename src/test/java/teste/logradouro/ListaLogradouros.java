/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.logradouro;

import com.ccti.loja.facade.LogradouroFacade;
import com.ccti.loja.model.Logradouro;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryCollection;
import com.vividsolutions.jts.geom.GeometryFactory;
import java.util.List;

/**
 *
 * @author PMBV-164029
 */
public class ListaLogradouros {

    public static void main(String[] args) {
        LogradouroFacade logradouroFacade = new LogradouroFacade();

        List<Logradouro> logradouros = logradouroFacade.getAll();

//        for (Logradouro l : logradouros) {
//            System.out.println(l.getNome() + " Location: " + l.getGeom());
//        }
//        List<Coordinate> coordinates = null;
//        for (Logradouro l : logradouros) {
//            System.out.println(l.getGeom().reverse());
//            System.out.println(" ======= ************* =======");
//
//        }
        Logradouro l = logradouroFacade.buscaById(1L);

        GeometryCollection geometryCollection = new GeometryCollection(
                logradouros.toArray(new Geometry[logradouros.size()]), new GeometryFactory());

        Coordinate[] envelope = geometryCollection.getEnvelope().getCoordinates();
        for (Coordinate c : envelope) {
            System.out.println((Math.round(c.x) + " - " + Math.round(c.y)));
        }
    }
}
