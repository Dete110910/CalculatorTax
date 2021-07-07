package resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LoaderVehicles {

	private BufferedReader br;
	private LineNumberReader lr;
	private FileReader fr;
	private String[][] matrix;
	
	public LoaderVehicles() throws IOException  {
		fr = new FileReader("src/resources/Guia_CSV_298.csv");
		lr = new LineNumberReader(new FileReader("src/resources/Guia_CSV_298.csv"));
		br = new BufferedReader(fr);
		this.loadVehicles();
	}
	
	
	public int countNumberLines() throws IOException {
		lr.skip(Long.MAX_VALUE);
		int i = lr.getLineNumber();
		lr.close();
		return i + 1;
	}
	
	
//	public void loadVehicles2() throws IOException {
//		String[] arr;
//		String[][] matrix;
//		int i = 0;
//		arr = br.readLine().split(",");
//		while((br.readLine()) != null && (arr[2] == "AUTOMOVIL")) {
//			matrix[i] = br.readLine().split(",");
//		}
//	}
	
	public void loadVehicles() throws IOException {
		int a = this.countNumberLines();
		int b = 0;
		String[][] matrix2 = new String[a][80];
		String[] arr;
		for(int i = 0; i < a - 1; i++) {
			arr = br.readLine().replace("\"\"", "").split(",");
			if((arr[2].equals("AUTOMOVIL"))){
				matrix2[i] = arr;
				b++;
			}
		} 
		
//		System.out.println("holaaa" + b);
//		
//		for(int i = 0; i < 10; i++) {
//			for(int k = 0; k < 10; k++) {
//				System.out.print(matrix2[i][k] + " ");
//			}
//			System.out.println(" ");
//		}
		this.getMatrixWithoutNull(matrix2, b);
		
		
	}
	
	public void getMatrixWithoutNull(String[][] matrix2, int b){
		matrix = new String[b][80];
		int j = 0;
		for(int i = 0; i < matrix2.length; i++) {
			if(!(matrix2[i][0] == (null))) {
				matrix[j] = matrix2[i];
				j++;
			}
		}
		
		for(int i = 0; i < 10; i++) {
			for(int k = 0; k < 80; k++) {
				System.out.print(matrix[i][k] + " ");
			}
			System.out.println(" ");
		} 
		
	}
	
	
	public String[][] getMatrix(){
		return this.matrix;
	}

	
	
	
	
	public static void main(String[] args) {
		try {
			new LoaderVehicles();
		}
		catch(IOException e) {
			e.getMessage();
		}
	}
	
}
