package models;

import java.util.ArrayList;

public class Line {

	private String vehicleLine;
	private double valueVehicleLine;
	private ArrayList<Model> model;
	

	public Line(String vehicleLine, double valueVehicleLine) {
		this.vehicleLine = vehicleLine;
		this.valueVehicleLine = valueVehicleLine;
		model = new ArrayList<Model>();
	}
	
	public ArrayList<Model> getModel() {
		return model;
	}
	
	public void setModel(ArrayList<Model> model) {
		this.model = model;
	}
	public String getVehicleLine() {
		return this.vehicleLine;
	}
	
	public void setVehicleLine(String vehicleLine) {
		this.vehicleLine = vehicleLine;
	}
	
	public double getValueVehicleLine() {
		return this.valueVehicleLine;
	}
	
	public void setValueVehicle(double valueVehicleLine) {
		this.valueVehicleLine = valueVehicleLine;
	}
	
	@Override
	public String toString() {
		return this.vehicleLine;
	}
	
}
