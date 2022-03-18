import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Score {
	static int resultado;
	static String linea;
	static Scanner obj;
	static PrintWriter lapiz;
	
	public static void main(String[] args) throws FileNotFoundException {
		DeterminarMayorVentaja(); 
      }
	
	public static Scanner Leer() throws FileNotFoundException {
		File entrada = new File("C:\\Users\\kalak\\Desktop\\texto.txt");
		obj = new Scanner(entrada);
		 return obj;
	}
	
	public static void DeterminarMayorVentaja() throws FileNotFoundException {
		String ronda;
		Leer();
		Escribir();
		 while (obj.hasNextLine()) {
		       	ronda = obj.nextLine();
		        String[] scores = ronda.split("\\s+");
		   		int score1 = Integer.parseInt(scores[0]);
				int score2 = Integer.parseInt(scores[1]);
				
				
				if(score1 > score2) {
					resultado = score1 - score2;
					linea = "1 "+resultado;
				}else if(score1 < score2){
					resultado = score2 - score1;
					linea = "2 "+resultado;
				}
		          
		           lapiz.println(linea);
		           
		       }
		 		   lapiz.close();
	}
	
	public static PrintWriter Escribir() {
		try {
            lapiz = new PrintWriter("C:\\Users\\kalak\\Desktop\\textoSalida.txt", "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
		return lapiz;
    
	}
		
	

}
