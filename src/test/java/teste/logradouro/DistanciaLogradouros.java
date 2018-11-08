/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.logradouro;

import com.ccti.loja.facade.LogradouroFacade;
import com.ccti.loja.model.Logradouro;
import com.ccti.loja.util.geometry.GoogleMapsTileMath;
import com.vividsolutions.jts.algorithm.distance.DiscreteHausdorffDistance;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.CoordinateSequence;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequence;
import com.vividsolutions.jts.geom.util.GeometryTransformer;
import com.vividsolutions.jts.operation.distance.DistanceOp;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author PMBV-164029
 */
public class DistanciaLogradouros {

    public static double distance(Geometry a, Geometry b) {
        return a.distance(b);
    }

    public static boolean isWithinDistance(Geometry a, Geometry b, double dist) {
        return a.isWithinDistance(b, dist);
    }

    public static Geometry nearestPoints(Geometry a, Geometry b) {
        Coordinate[] pts = DistanceOp.nearestPoints(a, b);
        return a.getFactory().createLineString(pts);
    }

    public static Geometry discreteHausdorffDistanceLine(Geometry a, Geometry b) {
        DiscreteHausdorffDistance dist = new DiscreteHausdorffDistance(a, b);
        dist.distance();
        return a.getFactory().createLineString(dist.getCoordinates());
    }

    public static Geometry densifiedDiscreteHausdorffDistanceLine(Geometry a, Geometry b, double frac) {
        DiscreteHausdorffDistance hausDist = new DiscreteHausdorffDistance(a, b);
        hausDist.setDensifyFraction(frac);
        hausDist.distance();
        return a.getFactory().createLineString(hausDist.getCoordinates());
    }

    public static Geometry discreteOrientedHausdorffDistanceLine(Geometry a, Geometry b) {
        DiscreteHausdorffDistance dist = new DiscreteHausdorffDistance(a, b);
        dist.orientedDistance();
        return a.getFactory().createLineString(dist.getCoordinates());
    }

    public static double discreteHausdorffDistance(Geometry a, Geometry b) {
        DiscreteHausdorffDistance dist = new DiscreteHausdorffDistance(a, b);
        return dist.distance();
    }

    public static double discreteOrientedHausdorffDistance(Geometry a, Geometry b) {
        DiscreteHausdorffDistance dist = new DiscreteHausdorffDistance(a, b);
        return dist.orientedDistance();
    }

   

    public static void main(String[] args) {
        LogradouroFacade lf = new LogradouroFacade();
        Logradouro l = lf.buscaById(1L);
        Logradouro lo = lf.buscaById(100L);

//        System.out.println(lo.getNome() + " local: " + lo.getGeom() + " Biarro: " + lo.getBairro().getNome());
//        System.out.println(l.getNome() + " local: " + l.getGeom() + " Biarro: " + l.getBairro().getNome());
//        double distancia = distance(lo.getGeom(), l.getGeom());
//        System.out.println("distancia : " + distancia / 1000);
        Geometry geometry = lo.getGeom();
        String lista = Arrays.toString(geometry.getCoordinates());

        System.out.println(lista);

        geometry.getCoordinates();

        Coordinate c = new Coordinate();

        GeometryFactory factory = new GeometryFactory();
        GeometryTransformer transformer = new GeometryTransformer();
        Geometry lineString = transformer.transform(lo.getGeom());

//        Point[] teste = new Point[2];
//        gFactory.createMultiPoint(teste);
        MultiLineString geom = lo.getGeom();
        System.out.println("teste: " + geom);
//        Point p = (Point) gTransform.transform(geom);
//        System.out.println("Ponto" + p);

        for (int i = 0; i < geom.getNumGeometries(); i++) {
            System.out.println(i);
        }

        GoogleMapsTileMath gmtm = new GoogleMapsTileMath();
        System.out.println(gmtm.metersToLngLat(lo.getGeom()));
        
        Geometry pontos = gmtm.metersToLngLat(lo.getGeom());
        System.out.println(pontos.getNumGeometries());
    }
}
