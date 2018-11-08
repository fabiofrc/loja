/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccti.loja.util.demo;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author PMBV-164029
 */
@ManagedBean
public class MarkersView {

    private MapModel simpleModel;

    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();

        //Shared coordinates
//      LatLng coord1 = new LatLng(314257.173330389, -751049.598949888);
        LatLng coord2 = new LatLng(2.815398574786915, -60.687733378976986);
        //Basic marker
        simpleModel.addOverlay(new Marker(coord2, "AB. SIMP.-cidade satélite"));
        simpleModel.getPolygons();
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }
}
