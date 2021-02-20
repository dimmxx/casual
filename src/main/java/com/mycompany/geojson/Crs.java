package com.mycompany.geojson;

import java.util.HashMap;
import java.util.Map;

public class Crs {

	private String type;
	private Map<String, Object> properties = new HashMap<String, Object>();

	public Crs() {
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
}
