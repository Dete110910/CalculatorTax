package models;

import java.util.ArrayList;

public class Line {

	private String vehicleLine;
	private ArrayList<Model> model;
	

	public Line(String vehicleLine) {
		this.vehicleLine = vehicleLine;
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
	
	
	@Override
	public String toString() {
		return this.vehicleLine;
	}
	
}
