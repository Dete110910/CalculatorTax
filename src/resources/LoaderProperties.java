package resources;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;

public class LoaderProperties {

	private double discountForEarlyPayment; 
	private LocalDate maxRangeForEarlyPayment;
	private boolean isPublicTransport;
	private double valueOfDisccountByTypeTransport;
	private boolean isOfBoyaca;
	private double valueOfDisccountByPlaceRegistration;
	private double initialValueOfRange;
	private double firstCutOfRange;
	private double secondCutOfRange;
	private double lastCutOfRange;
	private double taxeForTheFirstRange;
	private double taxeForTheSecondRange;
	private double taxeForTheThirdRange;
	
	private Properties properties;
	
	public LoaderProperties() throws FileNotFoundException, IOException {
		properties = new Properties();
		properties.load(new FileReader("src/resources/values.properties"));
		this.discountForEarlyPayment = Double.parseDouble(properties.getProperty("discountForEarlyPayment"));
		this.maxRangeForEarlyPayment = LocalDate.parse(properties.getProperty("maxRangeForEarlyPayment"));
		this.isPublicTransport = Boolean.parseBoolean(properties.getProperty("isPublicTransport"));
		this.valueOfDisccountByTypeTransport = Double.parseDouble(properties.getProperty("valueOfDisccountByTypeTransport"));
		this.isOfBoyaca = Boolean.parseBoolean(properties.getProperty("isOfBoyaca"));
		this.valueOfDisccountByPlaceRegistration = Double.parseDouble(properties.getProperty("valueOfDisccountByPlaceRegistration"));
		this.initialValueOfRange = Double.parseDouble(properties.getProperty("initialValueOfRange"));
		this.firstCutOfRange = Double.parseDouble(properties.getProperty("firstCutOfRange"));
		this.secondCutOfRange = Double.parseDouble(properties.getProperty("secondCutOfRange"));
		this.lastCutOfRange = Double.parseDouble(properties.getProperty("lastCutOfRange"));
		this.taxeForTheFirstRange = Double.parseDouble(properties.getProperty("taxeForTheFirstRange"));
		this.taxeForTheSecondRange = Double.parseDouble(properties.getProperty("taxeForTheSecondRange"));
		this.taxeForTheThirdRange = Double.parseDouble(properties.getProperty("taxeForTheThirdRange"));
	}

	public double getDiscountForEarlyPayment() {
		return discountForEarlyPayment;
	}

	public void setDiscountForEarlyPayment(double discountForEarlyPayment) {
		this.discountForEarlyPayment = discountForEarlyPayment;
	}

	public LocalDate getMaxRangeForEarlyPayment() {
		return maxRangeForEarlyPayment;
	}

	public void setMaxRangeForEarlyPayment(LocalDate maxRangeForEarlyPayment) {
		this.maxRangeForEarlyPayment = maxRangeForEarlyPayment;
	}

	public boolean getIsPublicTransport() {
		return isPublicTransport;
	}

	public void setPublicTransport(boolean isPublicTransport) {
		this.isPublicTransport = isPublicTransport;
	}

	public double getValueOfDisccountByTypeTransport() {
		return valueOfDisccountByTypeTransport;
	}

	public void setValueOfDisccountByTypeTransport(double valueOfDisccountByTypeTransport) {
		this.valueOfDisccountByTypeTransport = valueOfDisccountByTypeTransport;
	}

	public boolean getIsOfBoyaca() {
		return isOfBoyaca;
	}

	public void setOfBoyaca(boolean isOfBoyaca) {
		this.isOfBoyaca = isOfBoyaca;
	}

	public double getValueOfDisccountByPlaceRegistration() {
		return valueOfDisccountByPlaceRegistration;
	}

	public void setValueOfDisccountByPlaceRegistration(double valueOfDisccountByPlaceRegistration) {
		this.valueOfDisccountByPlaceRegistration = valueOfDisccountByPlaceRegistration;
	}

	public double getInitialValueOfRange() {
		return initialValueOfRange;
	}

	public void setInitialValueOfRange(double initialValueOfRange) {
		this.initialValueOfRange = initialValueOfRange;
	}

	public double getFirstCutOfRange() {
		return firstCutOfRange;
	}

	public void setFirstCutOfRange(double firstCutOfRange) {
		this.firstCutOfRange = firstCutOfRange;
	}

	public double getSecondCutOfRange() {
		return secondCutOfRange;
	}

	public void setSecondCutOfRange(double secondCutOfRange) {
		this.secondCutOfRange = secondCutOfRange;
	}

	public double getLastCutOfRange() {
		return lastCutOfRange;
	}

	public void setLastCutOfRange(double lastCutOfRange) {
		this.lastCutOfRange = lastCutOfRange;
	}

	public double getTaxeForTheFirstRange() {
		return taxeForTheFirstRange;
	}

	public void setTaxeForTheFirstRange(double taxeForTheFirstRange) {
		this.taxeForTheFirstRange = taxeForTheFirstRange;
	}

	public double getTaxeForTheSecondRange() {
		return taxeForTheSecondRange;
	}

	public void setTaxeForTheSecondRange(double taxeForTheSecondRange) {
		this.taxeForTheSecondRange = taxeForTheSecondRange;
	}

	public double getTaxeForTheThirdRange() {
		return taxeForTheThirdRange;
	}

	public void setTaxeForTheThirdRange(double taxeForTheThirdRange) {
		this.taxeForTheThirdRange = taxeForTheThirdRange;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
//
		
	
}
