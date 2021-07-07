package models;

import java.util.ArrayList;

public class Brand {

	private String vehicleBrand;
	private ArrayList<Line> line;
	
	public Brand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
		line = new ArrayList<Line>();
	}

	public ArrayList<Line> getLine() {
		return line;
	}

	public void setLine(ArrayList<Line> line) {
		this.line = line;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}


	
	@Override
	public String toString() {
		return (this.vehicleBrand);
	}
}
