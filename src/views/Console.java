package views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.ExceptionDate;

public class Console {

	private Scanner scanner;
	public static final String HEADER = "\n\tBienvenido al sistema de gestión de impuestos para su vehículo\n";
	public static final String MESSAGE_MAIN_MENU = "¿Qué desea realizar?\n" + 
													"\n1.Averiguar el impuesto a pagar por mi vehículo.\n" +
													"2.Actualizar los lineamientos.\n" +
													"3.Agregar nuevas marcas, lineas o modelos\n" +
													" 0.Salir de la aplicación \n";
	public static final String ERROR_INVALID_OPTION = "No pudimos encontrar la opción seleccionada. Por favor, intentelo nuevamente. \n";
	public static final String MESSAGE_FOR_ENTRY_PAY_DATE = "\nPor favor ingrese la fecha en que pagará sus impuestos en formato \"d/M/yyyy\": ";
	public static final String MESSAGE_FOR_UPDATE_PAY_DATE = "\nPor favor ingrese la fecha en que desea asignar para máximo pago anticipado en formato \"d/M/yyyy\": ";
	public static final String VALIDATOR_OF_DATE = "\\d{1,2}/\\d{1,2}/\\d{4}";
	public static final String FORMAT_OF_DATE = "d/M/yyyy";
	public static final String MESSAGE_FOR_READ_BRAND_VEHICLE = "\n Por favor, seleccione la opción que contenga la marca del vehículo";
	public static final String MESSAGE_FOR_READ_LINE_VEHICLE = "\n Por favor, seleccione la opción que contenga la línea del vehículo";
	public static final String MESSAGE_FOR_READ_MODEL_VEHICLE = "\n Por favor, seleccione la opción que contenga el modelo del vehículo";
	public static final String MESSAGE_TO_SHOW_VALUE_OF_TAXE_TO_PAY = "\n El valor que debe pagar de impuestos sin descuento es: %1.2f (COP)\n";
	public static final String MESSAGE_FOR_DETERMINATE_TYPE_VEHICLE = "\n¿Su vehículo es de transporte público?\n" + 
																	  " 1. Sí.\n" + 
																	  " 2. No.\n";
	
	public static final String MESSAGE_FOR_DETERMINATE_PLACE_OF_REGISTRATION = "\n¿Su vehículo está registrado en Boyacá?\n" + 
																				  " 1. Sí.\n" + 
																				  " 2. No.\n";
	public static final String MESSAGE_TO_SHOW_FINAL_VALUE_TO_PAY = "\nEl valor total a pagar, con descuentos incluidos es: %1.2f (COP)\n";
	public static final String MESSAGE_FOR_CHOOSE_VALUE_TO_MODIFY = "\n ¿Qué valor desea modificar?\n" + 
																	"\n 1.Rango inicial para pago de impuestos." +
																	"\n 2.Primer corte para pago de impuestos." + 
																	"\n 3.Segundo corte para pago de impuestos." +
																	"\n 4.Fecha máxima considerada como pronto pago." + 
																	"\n 5.Descuento por fecha considerada como pronto pago." +
																	"\n 6.Descuento si es un vehículo de transporte público." + 
																	"\n 7.Descuento si el vehículo está matriculado en Boyacá." +
																	"\n 0. Volver atrás.";
	public static final String MESSAGE_FOR_READ_VALUE_TO_MODIFY = "\nPor favor, ingrese el valor que desea asignar para el descuento \n";
	public static final String ERROR_INVALID_VALUE = "\nEl valor que desea ingresar no es válido. Por favor, intente nuevamente\n";
	public static final String MESSAGE_MENU_ADD = "\n ¿Qué desea realizar?" + 
												  "\n 1.Añadir una nueva marca" +
												  "\n 2.Añadir una nueva línea" + 
												  "\n 3.Añadir un nuevo modelo" +
												  "\n 0.Volver atrás";
	public static final String MESSAGE_FOR_READ_NAME_OF_NEW_BRAND = "\n Por favor, ingrese el nombre de la marca"; 
	public static final String MESSAGE_FOR_READ_NAME_OF_NEW_LINE = "\n Por favor, ingrese la referencia de la línea"; 
	public static final String MESSAGE_FOR_READ_NAME_OF_NEW_MODEL = "\n Por favor, ingrese la referencia del modelo"; 
	public static final String MESSAGE_FOR_READ_VALUE_OF_NEW_BRAND = "\n Por favor, ingrese el precio que desea asignarle a esta marca"; 
	public static final String MESSAGE_FOR_READ_VALUE_OF_NEW_LINE = "\n Por favor, ingrese el precio que desea asignarle a esta línea"; 
	public static final String MESSAGE_FOR_READ_VALUE_OF_NEW_MODEL = "\n Por favor, ingrese el precio que desea asignarle a este modelo"; 
	public static final String MESSAGE_SHOW_NEW_BRAND_ADD = "\n ¡Marca añadida correctamente!"; 
	public static final String MESSAGE_SHOW_NEW_LINE_ADD = "\n ¡Línea añadida correctamente!"; 
	public static final String MESSAGE_SHOW_NEW_MODEL_ADD = "\n ¡Modelo añadido correctamente!"; 
	public static final String ERROR_NO_ELEMENTS_IN_LIST = "\n ¡Lo sentimos, aún no tenemos elementos en esta lista!"; 
//	public static final String = ""; 
//	
	public Console() {
		scanner = new Scanner(System.in);
	}
	
	private boolean isNumeric(String string){
		try {
			Double.parseDouble(string.trim());
			return true;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}
	
	public void showHeader() {
		System.out.println(HEADER);
	}
	
	public byte readOptionMainMenu() {
		System.out.println(MESSAGE_MAIN_MENU);
		String option = scanner.nextLine().trim();
		while(!isNumeric(option) || Byte.parseByte(option) > 3 || Byte.parseByte(option) < 0 || Byte.parseByte(option) > Byte.MAX_VALUE) {
			System.out.println(ERROR_INVALID_OPTION);
			option = scanner.nextLine().trim();
		}
		return Byte.parseByte(option);
	}

	
	public <E> byte readVehicleBrand(ArrayList< E > listOfBrand) {
		System.out.println(MESSAGE_FOR_READ_BRAND_VEHICLE);
		int i;
		for(i = 0; i < listOfBrand.size(); i++) {
			System.out.println((i + 1) + ") " + listOfBrand.get(i));
		}
		
		String option = scanner.nextLine().trim();
		while(!isNumeric(option) || Byte.parseByte(option) > listOfBrand.size() || Byte.parseByte(option) < 0 || Byte.parseByte(option) > Byte.MAX_VALUE) {
			System.out.println(ERROR_INVALID_OPTION);
			option = scanner.nextLine().trim();
		}
		return Byte.parseByte(option);
	}
	
	public <E> byte readVehicleLine(ArrayList< E > listOfLine) {
			System.out.println(MESSAGE_FOR_READ_LINE_VEHICLE);
			for(int i = 0; i < listOfLine.size(); i++) {
				System.out.println((i + 1) + ") " + listOfLine.get(i));
			}
			
			String option = scanner.nextLine().trim();
			while(!isNumeric(option) || Byte.parseByte(option) > listOfLine.size() || Byte.parseByte(option) < 0 || Byte.parseByte(option) > Byte.MAX_VALUE) {
				System.out.println(ERROR_INVALID_OPTION);
				option = scanner.nextLine().trim();
			}
			return Byte.parseByte(option);
		
	}
	
	public <E> byte readVehicleModel(ArrayList< E > listOfModel) {
		System.out.println(MESSAGE_FOR_READ_LINE_VEHICLE);
		for(int i = 0; i < listOfModel.size(); i++) {
			System.out.println((i + 1) + ") " + listOfModel.get(i));
		}
		
		String option = scanner.nextLine().trim();
		while(!isNumeric(option) || Byte.parseByte(option) > listOfModel.size() || Byte.parseByte(option) < 0 || Byte.parseByte(option) > Byte.MAX_VALUE) {
			System.out.println(ERROR_INVALID_OPTION);
			option = scanner.nextLine().trim();
		}
		return Byte.parseByte(option);
	
}
	
	public void showValueOfTaxe(double valueOfTaxe) {
		System.out.printf(MESSAGE_TO_SHOW_VALUE_OF_TAXE_TO_PAY, valueOfTaxe);
	}
	
	
	public LocalDate readPayDate() {
		System.out.println(MESSAGE_FOR_ENTRY_PAY_DATE);
		try {
			return this.validateDate(scanner.nextLine());
		}
		catch(ExceptionDate exceptionDate) {
			System.out.println(exceptionDate.getMessage());
			return readPayDate();
		}
	}
	
	public LocalDate validateDate(String dayToPay) throws ExceptionDate{
		if(dayToPay.matches( VALIDATOR_OF_DATE )) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMAT_OF_DATE);
			return LocalDate.parse( dayToPay, dateTimeFormatter );
		}
		else {
			throw new ExceptionDate();
			
		}
	}
	
	public byte determinateTypeOfVehicle() {
		System.out.println(MESSAGE_FOR_DETERMINATE_TYPE_VEHICLE);
		String option = scanner.nextLine().trim();
		while(!isNumeric(option) || Byte.parseByte(option) > 2 || Byte.parseByte(option) < 1 || Byte.parseByte(option) > Byte.MAX_VALUE) {
			System.out.println(ERROR_INVALID_OPTION);
			option = scanner.nextLine().trim();
		}
		return Byte.parseByte(option);
	}
	
	public byte determinatePlaceOfRegistration() {
		System.out.println(MESSAGE_FOR_DETERMINATE_PLACE_OF_REGISTRATION);
		String option = scanner.nextLine().trim();
		while(!isNumeric(option) || Byte.parseByte(option) > 2 || Byte.parseByte(option) < 1 || Byte.parseByte(option) > Byte.MAX_VALUE) {
			System.out.println(ERROR_INVALID_OPTION);
			option = scanner.nextLine().trim();
		}
		return Byte.parseByte(option);
	}
	
	public void showFinalValueToPay(double finalValueToPay) {
		System.out.printf(MESSAGE_TO_SHOW_FINAL_VALUE_TO_PAY, finalValueToPay);
	}
	
	
	public byte readOptionToModify() {
		System.out.println(MESSAGE_FOR_CHOOSE_VALUE_TO_MODIFY);
		String option = scanner.nextLine().trim();
		while(!isNumeric(option) || Byte.parseByte(option) < 0 || Byte.parseByte(option) > 10 || Byte.parseByte(option) > Byte.MAX_VALUE) {
			System.out.println(ERROR_INVALID_OPTION);
			option = scanner.nextLine().trim();
		}
		return Byte.parseByte(option);
	}
	
	public double readValueToModify() {
		System.out.println(MESSAGE_FOR_READ_VALUE_TO_MODIFY);
		String option = scanner.nextLine().trim();
		while(!isNumeric(option) || Double.parseDouble(option) < 0 || Double.parseDouble(option) > Double.MAX_VALUE) {
			System.out.println(ERROR_INVALID_VALUE);
			option = scanner.nextLine().trim();
		}
		return Double.parseDouble(option);
	}
	
	public LocalDate readUpdatePayDate() {
		System.out.println(MESSAGE_FOR_UPDATE_PAY_DATE);
		try {
			return this.validateDate(scanner.nextLine());
		}
		catch(ExceptionDate exceptionDate) {
			System.out.println(exceptionDate.getMessage());
			return readPayDate();
		}
	}
	
	public byte readOptionMenuAddBLM() {
		System.out.println(MESSAGE_MENU_ADD);
		String option = scanner.nextLine().trim();
		while(!isNumeric(option) || Byte.parseByte(option) < 0 || Byte.parseByte(option) > 3 || Byte.parseByte(option) > Byte.MAX_VALUE) {
			System.out.println(ERROR_INVALID_OPTION);
			option = scanner.nextLine().trim();
		}
		return Byte.parseByte(option);
	}
	
	
	public String readNewBrand() {
		System.out.println(MESSAGE_FOR_READ_NAME_OF_NEW_BRAND);
		return scanner.nextLine().trim();
	}
	
	public double readValueNewBrand() {
		System.out.println(MESSAGE_FOR_READ_VALUE_OF_NEW_BRAND);
		String option = scanner.nextLine().trim();
		while(!isNumeric(option) || Double.parseDouble(option) > Double.MAX_VALUE) {
			System.out.println(ERROR_INVALID_VALUE);
			option = scanner.nextLine().trim();
		}
		return Double.parseDouble(option);
	}
	
	public void showBrandAdded() {
		System.out.println(MESSAGE_SHOW_NEW_BRAND_ADD);
	}
	
	public String readNewLine() {
		System.out.println(MESSAGE_FOR_READ_NAME_OF_NEW_LINE);
		return scanner.nextLine().trim();
		
	}
	
	public double readValueNewLine() {
		System.out.println(MESSAGE_FOR_READ_VALUE_OF_NEW_LINE);
		String option = scanner.nextLine().trim();
		while(!isNumeric(option) || Double.parseDouble(option) > Double.MAX_VALUE) {
			System.out.println(ERROR_INVALID_VALUE);
			option = scanner.nextLine().trim();
		}
		return Double.parseDouble(option);
	}
	
	public void showLineAdded() {
		System.out.println(MESSAGE_SHOW_NEW_LINE_ADD);
	}
	
	public String readNewModel() {
		System.out.println(MESSAGE_FOR_READ_NAME_OF_NEW_MODEL);
		return scanner.nextLine().trim();
		
	}
	
	public double readValueNewModel() {
		System.out.println(MESSAGE_FOR_READ_VALUE_OF_NEW_MODEL);
		String option = scanner.nextLine().trim();
		while(!isNumeric(option) || Double.parseDouble(option) > Double.MAX_VALUE) {
			System.out.println(ERROR_INVALID_VALUE);
			option = scanner.nextLine().trim();
		}
		return Double.parseDouble(option);
	}
	
	public void showModelAdded() {
		System.out.println(MESSAGE_SHOW_NEW_MODEL_ADD);
	}
	
	public <E> String readNewVehicleBrands(ArrayList<E> listOfBrands) {
		System.out.println(MESSAGE_FOR_READ_BRAND_VEHICLE);
		for(int i = 0; i < listOfBrands.size(); i++) {
			System.out.println((i + 1) + ") " + listOfBrands.get(i));
		}
		
		String option = scanner.nextLine().trim();
		while(!isNumeric(option) || Byte.parseByte(option) > listOfBrands.size() || Byte.parseByte(option) < 0 || Byte.parseByte(option) > Byte.MAX_VALUE) {
			System.out.println(ERROR_INVALID_OPTION);
			option = scanner.nextLine().trim();
		}
		return String.valueOf(listOfBrands.get(Integer.parseInt(option) - 1));
	}
	
	public <E> String readNewVehicleLine(ArrayList<E> listOfLines) {
		System.out.println(MESSAGE_FOR_READ_LINE_VEHICLE);
		for(int i = 0; i < listOfLines.size(); i++) {
			System.out.println((i + 1) + ") " + listOfLines.get(i));
		}
		
		String option = scanner.nextLine().trim();
		while(!isNumeric(option) || Byte.parseByte(option) > listOfLines.size() || Byte.parseByte(option) < 0 || Byte.parseByte(option) > Byte.MAX_VALUE) {
			System.out.println(ERROR_INVALID_OPTION);
			option = scanner.nextLine().trim();
		}
		return String.valueOf(listOfLines.get(Integer.parseInt(option) - 1));
	}
	
	
	public void showErrorNoElementsInList() {
		System.out.println(ERROR_NO_ELEMENTS_IN_LIST);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
