/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccti.loja.util.geometry;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author PMBV-164029
 */
public class LongLineSplitter {

    private static final GeometryFactory gf = new GeometryFactory();

    public static List<LineString> split(LineString given, int maxPoint) {
        List<LineString> result = new ArrayList();
        Coordinate[] coordinates = given.getCoordinates();
        int current = 0;
        while (current < coordinates.length) {
            int end = current + maxPoint - 1;
            if (coordinates.length - end < 2) {
                result.add(gf.createLineString(Arrays.copyOfRange(coordinates, current, coordinates.length)));
                return result;
            } else {
                result.add(gf.createLineString(Arrays.copyOfRange(coordinates, current, end + 1)));
                current = end;
            }
        }
        throw new IllegalStateException("Unexpected");
    }
}
