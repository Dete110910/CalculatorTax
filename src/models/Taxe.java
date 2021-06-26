package models;

public class Taxe {

	private double initialValueOfRange;
	private double firstCutOfRange;
	private double secondCutOfRange;
	private double taxeForTheFirstRange; 
	private double taxeForTheSecondRange;
	private double taxeForTheThirdRange;
	
	public Taxe(double initialValueOfRange, double firstCutOfRange, double secondCutOfRange, double taxeForTheFirstRange, double taxeForTheSecondRange, double taxeForTheThirdRange) {
	this.initialValueOfRange = initialValueOfRange;
	this.firstCutOfRange = firstCutOfRange;
	this.secondCutOfRange = secondCutOfRange;
	this.taxeForTheFirstRange = taxeForTheFirstRange;
	this.taxeForTheSecondRange = taxeForTheSecondRange;
	this.taxeForTheThirdRange = taxeForTheThirdRange;
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
	
}

	
