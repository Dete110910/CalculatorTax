package models;

import java.util.ArrayList;

public class Brand {

	private String vehicleBrand;
	private double valueVehicleBrand;
	private ArrayList<Line> line;
	
	public Brand(String vehicleBrand, double valueVehicleBrand) {
		this.vehicleBrand = vehicleBrand;
		this.valueVehicleBrand = valueVehicleBrand;
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

	public double getValueVehicleBrand() {
		return valueVehicleBrand;
	}

	public void setValueVehicleBrand(double valueVehicleBrand) {
		this.valueVehicleBrand = valueVehicleBrand;
	}
	
	@Override
	public String toString() {
		return (this.vehicleBrand);
	}
}
