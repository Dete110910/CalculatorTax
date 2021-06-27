package run;
import java.io.FileNotFoundException;
import java.io.IOException;

import presenters.PresenterApp;

public class RunApp {
	
	public static void main(String[] args) {
		try {
			new PresenterApp();					
		}
		catch (FileNotFoundException fileNotFoundException) {
			System.out.println("El programa no cuenta con todos los archivos para funcionar. Por favor verificar");
		}
		catch (IOException iOException) {
			System.out.println("Error por interrupción");
		}
	}
}
