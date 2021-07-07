package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class CalculatorTaxe {

	private ArrayList<Brand> brandList;
	private Taxe taxe;
	private Disccount disccount;
	
	public CalculatorTaxe(double disccountForEarlyPayment, LocalDate maxRangeForEarlyPayment, boolean isPublicTransport, double valueOfDisccountByTypeTransport,
						  boolean isOfBoyaca, double valueOfDisccountByPlaceRegistration, double initialValueOfRange, double firstCutOfRange, 
						  double secondCutOfRange, double lastCutOfRange, double taxeForTheFirstRange, double taxeForTheSecondRange, double taxeForTheThirdRange) {
		
		brandList = new ArrayList<Brand>();	
		taxe = new Taxe( initialValueOfRange, firstCutOfRange,  secondCutOfRange, taxeForTheFirstRange,  taxeForTheSecondRange, taxeForTheThirdRange);
		disccount = new Disccount(disccountForEarlyPayment,  maxRangeForEarlyPayment, isPublicTransport,  valueOfDisccountByTypeTransport,  isOfBoyaca,  valueOfDisccountByPlaceRegistration);
	}


	public double calculateTaxeByComercialValue(double totalValue) {
		if(totalValue > taxe.getInitialValueOfRange() && totalValue <= taxe.getFirstCutOfRange() ) {
			return (totalValue * taxe.getTaxeForTheFirstRange()) / 100;
		}
		else if(totalValue > taxe.getFirstCutOfRange() && totalValue <= taxe.getSecondCutOfRange()) {
			return (totalValue * taxe.getTaxeForTheSecondRange()) / 100;
		}
		else if(totalValue < 0) {
			return 0;
		}
		else {
			return totalValue * taxe.getTaxeForTheThirdRange() / 100;
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
		return brandList.get(lineOption - 1).getLine();
	}
	
	public ArrayList<Model> findModel(byte modelOption, byte lineOption){
		return brandList.get(lineOption - 1).getLine().get(modelOption - 1).getModel();
	}
	
	public boolean determinateBoolean(byte option) {
		if(option == 1) {
			return true;
		}
		else
			return false;
	}
	
	public void addNewBrand(String newVehicleBrand) {
		brandList.add(new Brand(newVehicleBrand));
	}
	
	public void addNewLine(String nameBrand, String newVehicleLine){
		for(int i = 0; i < brandList.size(); i++) {
			if(brandList.get(i).getVehicleBrand().equals(nameBrand)) {
				brandList.get(i).getLine().add(new Line(newVehicleLine));
				return;
			}
		}
	}
	 
	public void addNewModel(String nameBrand, String nameLine, String newVehicleModel, double newVehicleValue) {
		for(int i = 0; i < brandList.size(); i++) {
			if(brandList.get(i).getVehicleBrand().equals(nameBrand) && brandList.get(i).getLine().get(i).getVehicleLine().equals(nameLine)){
				brandList.get(i).getLine().get(i).getModel().add(new Model(newVehicleModel, newVehicleValue));
			}
		}
		
	}
	
	public ArrayList<Line> findLinesByNameOfBrand(String nameOfBrand){
		for(int i = 0; i < brandList.size(); i++) {
			if(brandList.get(i).getVehicleBrand().equals(nameOfBrand)){
				return brandList.get(i).getLine();
			}
		}
		return null; //sé que es una mala práctica pero no sé qué más hacerle
	}
	public void addAll(String[][] matrix) {
		String line;
		int model;
		brandList.add(new Brand(matrix[0][1]));
		
		for(int i = 0; i < matrix.length; i++) {
			model = 1970;
			if(exsistBrand(matrix[i][1])) {
				brandList.add(new Brand(matrix[i][1]));
				
			}
			
			line = matrix[i][5] + matrix[i][6]; 
			int[] positionLine = existLine(matrix[i][1], line);
			if(positionLine[1] == -1) {
				brandList.get(positionLine[0]).getLine().add(new Line(line));
			}
			
			for(int k = 11; k < 52; k++) {				
				if(this.validateValueModel(matrix, i, k) && positionLine[1] != -1) {
					brandList.get(positionLine[0]).getLine().get(positionLine[1]).getModel().add(new Model(String.valueOf(model), Double.parseDouble(matrix[i][k]) * 1000));
					System.out.println("Agregué modelo " + String.valueOf(model) + Double.parseDouble(matrix[i][k]) + " posición " + i);
				}
//				else if(this.validateValueModel(matrix, i, k) && positionLine[1] == -1){
//					brandList.get(positionLine[0]).getLine().get(brandList.get(positionLine[0]).getLine().size() - 1).getModel().add(new Model(String.valueOf(model), Double.parseDouble(matrix[i][k]) * 1000));
//					System.out.println("Agregué modelo " + String.valueOf(model) + "valor: " + Double.parseDouble(matrix[i][k]) + " posición " + i);
//				}
				model++;
			}
		}
	}
	
	public boolean validateValueModel(String[][] matrix, int i, int k) {
		if(Integer.parseInt(matrix[i][k]) != 0) {
			System.out.println("soy distinto de 0" + i + k);
			return true;
		}
		return false;
	}
	
	public int[] existLine(String carBrand, String line) {
		int[] position = {-1, -1};
		for(int i = 0; i < brandList.size(); i++) {
			if(brandList.get(i).getVehicleBrand().equals(carBrand)) {
				position[0] = i;
				for(int j = 0; j < brandList.get(i).getLine().size(); j++) {
					if(brandList.get(i).getLine().get(j).getVehicleLine().equals(line)) {
						position[1] = j;
						return position;
					}
				}
			}
		}
		return position;
	}
	
	public boolean existModel(int carBrand, int line, String model) {
		if(line == -1) {
			for(int i = 0; i < brandList.size(); i++) {
				if(brandList.get(carBrand).getLine().get(brandList.get(carBrand).getLine().size() - 1).getModel().get(i).equals(model)) {
					return false;
				}
			}
		}
		else {
			for(int i = 0; i < brandList.size(); i++) {
				if(brandList.get(carBrand).getLine().get(line).getModel().get(i).equals(model)) {
					return false;
				}
			}
		}	
		return true;
	}
	
	public void addBrands(String[][] matrix) {
		brandList.add(new Brand(matrix[0][1]));
		for(int i = 0; i < matrix.length; i++) {
			
		}
	}
	
	public boolean exsistBrand(String newBrand) {
		for(int i = 0; i < brandList.size(); i++) {
			if(brandList.get(i).getVehicleBrand().equals(newBrand)) {
				return false;
			}
		}
		return true;
	}
	
//	public void addLines(String[][] matrix) {
//		brandList.get(0).getLine().add(new Line(matrix[0][2]));
//		for(int i = 0; i < brandList.size(); i++) {
//			if(existLine(matrix[i][2])) {
//			}
//		}
//	}
	
	
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
		return brandList;
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
