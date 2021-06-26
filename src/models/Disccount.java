package models;

import java.time.LocalDate;

public class Disccount {

	private double disccountForEarlyPay;
	private LocalDate maxRangeForEarlyPayment;	
	private boolean isPublicTransport; 
	private double valueOfDisccountByTypeTransport;
	private boolean isOfBoyaca;
	private double valueOfDisccountByPlaceRegistration;
	
	public Disccount(double disccountForEarlyPay, LocalDate maxRangeForEarlyPayment,  boolean isPublicTransport, double valueOfDisccountByTypeTransport, boolean isOfBoyaca, double valueOfDisccountByPlaceRegistration) {
		this.disccountForEarlyPay = disccountForEarlyPay;
		this.maxRangeForEarlyPayment = maxRangeForEarlyPayment;
		this.isPublicTransport = isPublicTransport;
		this.valueOfDisccountByTypeTransport = valueOfDisccountByTypeTransport;
		this.isOfBoyaca = isOfBoyaca;
		this.valueOfDisccountByPlaceRegistration = valueOfDisccountByPlaceRegistration;
	}

	public double getDisccountForEarlyPay() {
		return disccountForEarlyPay;
	}

	public void setDisccountForEarlyPay(double disccountForEarlyPay) {
		this.disccountForEarlyPay = disccountForEarlyPay;
	}

	public LocalDate getMaxRangeForEarlyPayment() {
		return maxRangeForEarlyPayment;
	}

	public void setMaxRangeForEarlyPayment(LocalDate maxRangeForEarlyPayment) {
		this.maxRangeForEarlyPayment = maxRangeForEarlyPayment;
	}

	public boolean isPublicTransport() {
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

	public boolean isOfBoyaca() {
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


}
