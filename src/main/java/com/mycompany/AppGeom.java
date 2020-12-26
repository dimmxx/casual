package com.mycompany;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

import java.util.Objects;

public class AppGeom {

    public static void main(String[] args) throws ParseException {

        String line = "MULTILINESTRING ((6.8874692950082 50.79530933242,6.88736460212707 50.7953158826381))";


        String point = "POINT (6.92386290288517 50.7735481605227)";


        Geometry geometry = new WKTReader(new GeometryFactory(new PrecisionModel(), 4326)).read(line);




        String l = "2554023";




        int num = 5;

        System.out.println(num += 5);
        System.out.println(num =+ 5);








    }



}













