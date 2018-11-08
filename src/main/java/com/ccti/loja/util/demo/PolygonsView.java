/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccti.loja.util.demo;

import com.ccti.loja.model.Ponto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Polygon;

/**
 *
 * @author PMBV-164029
 */
@ManagedBean
public class PolygonsView implements Serializable {

    private MapModel polygonModel;
    private Polygon polygon;
    private List<Ponto> pontos;
    private List<LatLng> latLngs;

    @PostConstruct
    public void init() {
        polygonModel = new DefaultMapModel();
        pontos = new ArrayList<>();
        latLngs = new ArrayList<>();
        Ponto p1 = new Ponto();
        p1.setLat(2.8151413934930862);
        p1.setLng(-60.67793198945856);

        Ponto p2 = new Ponto();
        p2.setLat(2.82129229720268);
        p2.setLng(-60.680442537096496);

        Ponto p3 = new Ponto();
        p3.setLat(2.826307295660806);
        p3.setLng(-60.67836114290094);

        Ponto p4 = new Ponto();
        p4.setLat(2.828537975550921);
        p4.setLng(-60.67223310470581);

        Ponto p5 = new Ponto();
        p5.setLat(2.8268814492469216);
        p5.setLng(-60.66767522218561);

        pontos.add(p1);
        pontos.add(p2);
        pontos.add(p3);
        pontos.add(p4);
        pontos.add(p5);

//        for (Ponto ponto : pontos) {
////            System.out.println(ponto.getLat() + " " + ponto.getLng());
//            LatLng coord1 = new LatLng(ponto.getLat(), ponto.getLng());
//            System.out.println(coord1.getLat() + " - " + coord1.getLng());
//
//            polygon = new Polygon();
//            polygon.getPaths().add(coord1);
//
//            polygon.setStrokeColor("#FF9900");
//            polygon.setFillColor("#FF9900");
//            polygon.setStrokeOpacity(0.7);
//            polygon.setFillOpacity(0.7);
//
//            polygonModel.addOverlay(polygon);
//        }
        for (Ponto ponto : pontos) {
            LatLng coord1 = new LatLng(ponto.getLat(), ponto.getLng());
            latLngs.add(coord1);

        }
        for (LatLng latLng : latLngs) {
            System.out.println("Lat/Long: " + latLng.getLat());

        }

        polygon = new Polygon();
        polygon.getPaths().addAll(latLngs);
        polygon.setStrokeColor("#FF9900");
        polygon.setFillColor("#FF9900");
        polygon.setStrokeOpacity(0.7);
        polygon.setFillOpacity(0.7);
        polygonModel.addOverlay(polygon);

    }

    public MapModel getPolygonModel() {
        return polygonModel;
    }

    public void onPolygonSelect(OverlaySelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Polygon Selected", null));
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }

    public List<Ponto> getPontos() {
        return pontos;
    }

    public void setPontos(List<Ponto> pontos) {
        this.pontos = pontos;
    }

    public List<LatLng> getLatLngs() {
        return latLngs;
    }

    public void setLatLngs(List<LatLng> latLngs) {
        this.latLngs = latLngs;
    }

}
