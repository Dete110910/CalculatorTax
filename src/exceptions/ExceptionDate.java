package exceptions;


public class ExceptionDate extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public static final String MESSAGE = "La fecha no ha sido ingresada correctamente. Por favor, intentetelo nuevamente.";
	
	public ExceptionDate() {
		super(MESSAGE);
	}
}
