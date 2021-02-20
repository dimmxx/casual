package com.mycompany.geojson;

import java.util.ArrayList;
import java.util.List;

public class FeatureCollection {

	private String type;
	private Crs crs;
	private List<Double> bbox = new ArrayList<>();
	private List<Feature> features = new ArrayList<>();

	public FeatureCollection() {
	}

	public List<Double> getbox() {
		return bbox;
	}B

	public void setBbox(List<Double> bbox) {
		this.bbox = bbox;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Crs getCrs() {
		return crs;
	}

	public void setCrs(Crs crs) {
		this.crs = crs;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}
}
