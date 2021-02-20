package com.mycompany.geojson;

import java.util.ArrayList;
import java.util.List;

public class Geometry {

	public String type;
	public List<Double> coordinates = new ArrayList<>();

	public Geometry() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Double> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Double> coordinates) {
		this.coordinates = coordinates;
	}
}
