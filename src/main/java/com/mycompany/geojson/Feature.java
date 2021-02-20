package com.mycompany.geojson;

import java.util.HashMap;
import java.util.Map;

public class Feature {

	private String type;
	private Map<String, Object> properties = new HashMap<String, Object>();
	private Geometry geometry;

	public Feature() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
}
