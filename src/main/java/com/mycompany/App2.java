package com.mycompany;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.geojson.Crs;
import com.mycompany.geojson.Feature;
import com.mycompany.geojson.FeatureCollection;
import com.mycompany.geojson.Geometry;

import java.io.File;
import java.io.IOException;

public class App2 {

    public static void main(String[] args) throws IOException {

        Geometry geometry = new Geometry();
        geometry.setType("Point");

        Feature feature = new Feature();
        feature.setType("Feature");
        feature.setGeometry(geometry);


        FeatureCollection featureCollection = new FeatureCollection();
        featureCollection.setType("FeatureCollection");
        featureCollection.setCrs(new Crs());
        featureCollection.getFeatures().add(feature);





        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(new File("geojson.json"), featureCollection);







    }




}
