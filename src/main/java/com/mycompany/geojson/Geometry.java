package com.mycompany.geojson;

import java.util.ArrayList;
import java.util.List;

public class Geometry {

	public String type;
	public List<String> coordinates = new ArrayList<>();

	public Geometry() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<String> coordinates) {
		this.coordinates = coordinates;
	}
}
