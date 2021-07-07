package presenters;

import java.time.LocalDate;
import java.io.FileNotFoundException;
import java.io.IOException;


import models.*;
import views.Console;
import resources.LoaderProperties;
import resources.LoaderVehicles;

public class PresenterApp {
	
	private CalculatorTaxe calculatorTaxe;
	private Console console;
	private LoaderProperties loaderFile;
	private LoaderVehicles loaderVehicles;
	
	public PresenterApp() throws FileNotFoundException, IOException{
		loaderFile = new LoaderProperties();
		calculatorTaxe = new CalculatorTaxe(loaderFile.getDiscountForEarlyPayment(), loaderFile.getMaxRangeForEarlyPayment(), loaderFile.getIsPublicTransport(), loaderFile.getValueOfDisccountByTypeTransport(), 
											loaderFile.getIsOfBoyaca(), loaderFile.getValueOfDisccountByPlaceRegistration(), loaderFile.getInitialValueOfRange(), loaderFile.getFirstCutOfRange(), loaderFile.getSecondCutOfRange(),
											loaderFile.getLastCutOfRange(), loaderFile.getTaxeForTheFirstRange(), loaderFile.getTaxeForTheSecondRange(), loaderFile.getTaxeForTheThirdRange());
		console = new Console();
		loaderVehicles = new LoaderVehicles();
//		this.createBrand();
//		this.createLines();
//		this.createModels();
		this.createBrands();
		this.runApp();
	} 
	
	private void runApp() {
		console.showHeader();
		byte option = console.readOptionMainMenu();
		switch(option) {
			
			case 1:
					this.calculateTaxe();
					break;
			case 2: 
					this.modifyValues();
					break;
			case 3:
					this.addNewBrandLineOrModel();
					break;
			case 0: 
					break;
		}
	}
	
	private void calculateTaxe() {
		byte brandOption = console.readVehicleBrand(calculatorTaxe.getBrand());
		if(calculatorTaxe.findLine(brandOption).size() > 0) {
			byte lineOption = console.readVehicleLine(calculatorTaxe.findLine(brandOption));
			if(calculatorTaxe.findModel(lineOption, brandOption).size() > 0) {
				byte modelOption = console.readVehicleModel(calculatorTaxe.findModel(lineOption, brandOption));
				double totalValue = calculatorTaxe.getBrand().get(brandOption - 1).getLine().get(lineOption - 1).getModel().get(modelOption - 1).getValueVehicleModel();
				System.out.println(totalValue + " valor total");
				totalValue = calculatorTaxe.calculateTaxeByComercialValue(totalValue);
				console.showValueOfTaxe(totalValue);
				this.calculateDisccounts(totalValue);
			}
			else {
				console.showErrorNoElementsInList();
				this.runApp();
			}
				
		}
		else {
			console.showErrorNoElementsInList();
			this.runApp();
		}
	}
	
	private void calculateDisccounts(double totalValue) {
		LocalDate dateToPay = console.readPayDate();
		double valueWithDisccount = calculatorTaxe.calculateDisccountByEarlyPayment(dateToPay, totalValue);
		byte typeVehicle = console.determinateTypeOfVehicle();
		boolean isPublicVehicle = calculatorTaxe.determinateBoolean(typeVehicle);
		valueWithDisccount = calculatorTaxe.calculateDisccountByTypeVehicle(isPublicVehicle, valueWithDisccount);
		byte placeOfRegistration = console.determinatePlaceOfRegistration();
		boolean isOfBoyaca = calculatorTaxe.determinateBoolean(placeOfRegistration);
		valueWithDisccount = calculatorTaxe.calculateDisccountByPlaceOfRegistration(isOfBoyaca, valueWithDisccount);
		console.showFinalValueToPay(valueWithDisccount);
		this.runApp();
	}
	
	private void modifyValues() {
		byte option = console.readOptionToModify();
		switch(option) {
				case 1:
						this.modifyInitialRangeForPaymentOfTaxe();
						break;
				case 2:
					 	this.modifyFirsCutForPaymentTaxe();
					 	break;
				case 3: 
						this.modifySecondCutForPaymentTaxe();
						break;
				case 4: 
						this.modifyMaxRangeForEarlyPayment();
						break;
				case 5: 
						this.modifyDisccountForEarlyPay();
						break;
				case 6: this.modifyValueOfDisccountByTypeTransport(); 
						break;
				case 7:
						this.modifyValueOfDisccountIfIsOfBoyaca();
						break;
				case 0: 
						this.runApp();
						break;
		}
	}
	
	private void modifyInitialRangeForPaymentOfTaxe() {
		double value = console.readValueToModify();
		calculatorTaxe.updateInitialRangeForPaymentOfTaxe(value);
		this.modifyValues();
	}
	
	private void modifyFirsCutForPaymentTaxe() {
		double value = console.readValueToModify();
		calculatorTaxe.updateFirstCutForPaymentTaxe(value);
		this.modifyValues();
	}
	
	private void modifySecondCutForPaymentTaxe() {
		double value = console.readValueToModify();
		calculatorTaxe.updateSecondCutForPaymentTaxe(value);
		this.modifyValues();
	}
	
	private void modifyMaxRangeForEarlyPayment() {
		LocalDate updateDate = console.readUpdatePayDate();
		calculatorTaxe.updateMaxRangeForEarlyPayment(updateDate);
		this.modifyValues();
	}
	
	private void modifyDisccountForEarlyPay() {
		double value = console.readValueToModify();
		calculatorTaxe.updateDisccountForEarlyPay(value);
		this.modifyValues();
	}
		
	private void modifyValueOfDisccountByTypeTransport() {
		double value = console.readValueToModify();
		calculatorTaxe.updateValueOfDisccountByTypeTransport(value);
		this.modifyValues();
	}
	
	private void modifyValueOfDisccountIfIsOfBoyaca() {
		double value = console.readValueToModify();
		calculatorTaxe.updateValueOfDisccountIfIsOfBoyaca(value);
		this.modifyValues();	
	}
	
	
	private void addNewBrandLineOrModel() {
		byte option = console.readOptionMenuAddBLM();
		switch(option) {
				case 1:
						this.addNewBrand();
						break;
				case 2: 
						this.addNewLine();
						break;
				case 3: 
						this.addNewModel();
						break;
				case 0:
						this.runApp();
						break;
		}
	}
	
	private void addNewBrand() {
		String nameOfBrand = console.readNewBrand();
		calculatorTaxe.addNewBrand(nameOfBrand);
		console.showBrandAdded();
		this.addNewBrandLineOrModel();
	}
	
	private void addNewLine() {
		String nameOfBrand = console.readNewVehicleBrands(calculatorTaxe.getBrand());
		String nameOfLine = console.readNewLine();
		calculatorTaxe.addNewLine(nameOfBrand, nameOfLine);
		console.showLineAdded();
		this.addNewBrandLineOrModel();
	}
	
	private void addNewModel() {
		String nameOfBrand = console.readNewVehicleBrands(calculatorTaxe.getBrand());
		String nameOfLine = console.readNewVehicleLine(calculatorTaxe.findLinesByNameOfBrand(nameOfBrand));
		String nameOfNewModel = console.readNewModel();
		double valueOfNewModel = console.readValueNewModel();
		calculatorTaxe.addNewModel(nameOfBrand, nameOfLine, nameOfNewModel, valueOfNewModel);
		console.showModelAdded();
		this.addNewBrandLineOrModel();
		
		
	}
	
	
	private void createBrands() {
		calculatorTaxe.addAll(loaderVehicles.getMatrix());
		System.out.println(calculatorTaxe.getBrand().get(1).getLine().get(0).getModel());

	}
	
	
//	private void createBrand() {
//		calculatorTaxe.getBrand().add(new Brand("Chevrolet"));
//		calculatorTaxe.getBrand().add(new Brand("Toyota"));
//		calculatorTaxe.getBrand().add(new Brand("BMW"));
//		calculatorTaxe.getBrand().add(new Brand("Honda"));
//		calculatorTaxe.getBrand().add(new Brand("Tesla"));
//		
//	}
//	
//	private void createLines() {
//		calculatorTaxe.getBrand().get(0).getLine().add(new Line("Línea 1 C"));
//		calculatorTaxe.getBrand().get(0).getLine().add(new Line("Línea 2 C"));
//		calculatorTaxe.getBrand().get(1).getLine().add(new Line("Línea 1 To"));
//		calculatorTaxe.getBrand().get(1).getLine().add(new Line("Línea 2 To"));
//		calculatorTaxe.getBrand().get(2).getLine().add(new Line("Línea 1 B"));
//		calculatorTaxe.getBrand().get(2).getLine().add(new Line("Línea 2 B"));
//		calculatorTaxe.getBrand().get(3).getLine().add(new Line("Línea 1 H"));
//		calculatorTaxe.getBrand().get(3).getLine().add(new Line("Línea 2 H"));
//		calculatorTaxe.getBrand().get(4).getLine().add(new Line("Línea 1 T"));
//		calculatorTaxe.getBrand().get(4).getLine().add(new Line("Línea 2 T"));
//	}
//	
//	private void createModels() {
//		calculatorTaxe.getBrand().get(0).getLine().get(0).getModel().add(new Model("Modelo 1 C", 2000000));
//		calculatorTaxe.getBrand().get(0).getLine().get(1).getModel().add(new Model("Modelo 2 C", 9000000));
//		calculatorTaxe.getBrand().get(1).getLine().get(0).getModel().add(new Model("Modelo 1 To", 5000000));
//		calculatorTaxe.getBrand().get(1).getLine().get(1).getModel().add(new Model("Modelo 1 To", 7000000));
//		calculatorTaxe.getBrand().get(2).getLine().get(0).getModel().add(new Model("Modelo 1 B", 8000000));
//		calculatorTaxe.getBrand().get(2).getLine().get(1).getModel().add(new Model("Modelo 1 B", 7900000));
//		calculatorTaxe.getBrand().get(3).getLine().get(0).getModel().add(new Model("Modelo 1 H", 8900000));
//		calculatorTaxe.getBrand().get(3).getLine().get(1).getModel().add(new Model("Modelo 1 H", 9900000));
//		calculatorTaxe.getBrand().get(3).getLine().get(0).getModel().add(new Model("Modelo 1 T", 1900000));
//		calculatorTaxe.getBrand().get(3).getLine().get(1).getModel().add(new Model("Modelo 1 T", 2900000));
//	}

	

}
