package models;

public class Model {

	private String vehicleModel;
	private double valueVehicleModel;
	
	public Model(String vehicleModel, double valueVehicleModel) {
		this.vehicleModel = vehicleModel;
		this.valueVehicleModel = valueVehicleModel;
	}
	
	public String getVehicleModel() {
		return this.vehicleModel;
	}
	
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	
	public double getValueVehicleModel() {
		return this.valueVehicleModel;
	}
	
	public void setValueVehicleModel(double valueVehicleModel) {
		this.valueVehicleModel = valueVehicleModel;
	}
	

	@Override
	public String toString() {
		return this.vehicleModel;
	}
}
