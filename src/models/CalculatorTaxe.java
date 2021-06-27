package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class CalculatorTaxe {

	private ArrayList<Brand> brand;
	private Taxe taxe;
	private Disccount disccount;
	
	public CalculatorTaxe(double disccountForEarlyPayment, LocalDate maxRangeForEarlyPayment, boolean isPublicTransport, double valueOfDisccountByTypeTransport,
						  boolean isOfBoyaca, double valueOfDisccountByPlaceRegistration, double initialValueOfRange, double firstCutOfRange, 
						  double secondCutOfRange, double lastCutOfRange, double taxeForTheFirstRange, double taxeForTheSecondRange, double taxeForTheThirdRange) {
		
		brand = new ArrayList<Brand>();	
		taxe = new Taxe( initialValueOfRange, firstCutOfRange,  secondCutOfRange, taxeForTheFirstRange,  taxeForTheSecondRange, taxeForTheThirdRange);
		disccount = new Disccount(disccountForEarlyPayment,  maxRangeForEarlyPayment, isPublicTransport,  valueOfDisccountByTypeTransport,  isOfBoyaca,  valueOfDisccountByPlaceRegistration);
	}


	public double calculateTaxeByComercialValue(double totalValue) {
		if(totalValue > 0 && totalValue <= taxe.getInitialValueOfRange()) {
			return totalValue * taxe.getTaxeForTheFirstRange();
		}
		else if(totalValue > taxe.getInitialValueOfRange() && totalValue <= taxe.getFirstCutOfRange()) {
			return totalValue * taxe.getTaxeForTheSecondRange();
		}
		else if(totalValue < 0) {
			return 0;
		}
		else {
			return totalValue * taxe.getTaxeForTheThirdRange();
		}
	}
	
	public double calculateDisccountByEarlyPayment(LocalDate dateToPay, double totalValue) {
		if(dateToPay.isBefore(disccount.getMaxRangeForEarlyPayment()) && dateToPay.isAfter(LocalDate.of(2021, 1, 1))){
			return totalValue - (totalValue * disccount.getDisccountForEarlyPay()) / 100;
		}
		else
			return totalValue;
	}
	
	public double calculateDisccountByTypeVehicle(boolean isPublicTransport, double valueOfTaxe) {
		if(isPublicTransport) {
			return (valueOfTaxe - disccount.getValueOfDisccountByTypeTransport());
		}
		else
			return valueOfTaxe;
	}
	
	
	public double calculateDisccountByPlaceOfRegistration(boolean isOfBoyaca, double valueOfTaxe){
		if(isOfBoyaca) {
			return valueOfTaxe - (valueOfTaxe * disccount.getValueOfDisccountByPlaceRegistration())/100;
		}
		else
			return valueOfTaxe;
		
	}
		
	public ArrayList<Line> findLine(byte lineOption) {
		return brand.get(lineOption - 1).getLine();
	}
	
	public ArrayList<Model> findModel(byte modelOption, byte lineOption){
		return brand.get(lineOption - 1).getLine().get(modelOption - 1).getModel();
	}
	
	public boolean determinateBoolean(byte option) {
		if(option == 1) {
			return true;
		}
		else
			return false;
	}
	
	public void addNewBrand(String newVehicleBrand, double newValueBrand) {
		getBrand().add(new Brand(newVehicleBrand, newValueBrand));
	}
	
	public void addNewLine(String nameBrand, String newVehicleLine, double newVehicleValue){
		for(int i = 0; i < brand.size(); i++) {
			if(brand.get(i).getVehicleBrand() == nameBrand) {
				brand.get(i).getLine().add(new Line(newVehicleLine, newVehicleValue));
				return;
			}
		}
	}
	
	public void addNewModel(String nameBrand, String nameLine, String newVehicleModel, double newVehicleValue) {
		for(int i = 0; i < brand.size(); i++) {
			if(brand.get(i).getVehicleBrand() == nameBrand && brand.get(i).getLine().get(i).getVehicleLine() == nameLine){
				brand.get(i).getLine().get(i).getModel().add(new Model(newVehicleModel, newVehicleValue));
			}
		}
		
	}
	
	public ArrayList<Line> findLinesByNameOfBrand(String nameOfBrand){
		for(int i = 0; i < brand.size(); i++) {
			if(brand.get(i).getVehicleBrand() == nameOfBrand){
				return brand.get(i).getLine();
			}
		}
		return null; //sé que es una mala práctica pero no sé qué más hacerle
	}
	
	public void updateInitialRangeForPaymentOfTaxe(double updateValue) {
		taxe.setInitialValueOfRange(updateValue);
	}
	
	public void updateFirstCutForPaymentTaxe(double updateValue) {
		taxe.setFirstCutOfRange(updateValue);
	}
	
	public void updateSecondCutForPaymentTaxe(double updateValue) {
		taxe.setSecondCutOfRange(updateValue);
	}
	
	public void updateMaxRangeForEarlyPayment(LocalDate updateDate) {
		disccount.setMaxRangeForEarlyPayment(updateDate);
	}
	
	public void updateDisccountForEarlyPay(double updateDisccount) {
		disccount.setDisccountForEarlyPay(updateDisccount);
	}
	
	public void updateValueOfDisccountByTypeTransport(double updateDisccount) {
		disccount.setValueOfDisccountByTypeTransport(updateDisccount);
	}
	
	public void updateValueOfDisccountIfIsOfBoyaca(double updateDisccount) {
		disccount.setValueOfDisccountByPlaceRegistration(updateDisccount);
	}
	
	
	public ArrayList<Brand> getBrand() {
		return brand;
	}


	public Taxe getTaxe() {
		return taxe;
	}

	public void setTaxe(Taxe taxe) {
		this.taxe = taxe;
	}

	public Disccount getDisccount() {
		return disccount;
	}

	public void setDisccount(Disccount disccount) {
		this.disccount = disccount;
	}
	
	
	
}
