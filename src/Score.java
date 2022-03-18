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
		//DeterminarMayorVentaja(); 
		NuevosScores();
      }
	
	public static void NuevosScores() throws FileNotFoundException {
		Scanner entrada = new Scanner(System.in);
		Escribir("TextoEntrada.txt");
		
		String a,b,res;
		do
        {
			System.out.println("Ingresa el puntaje del jugador 1: ");
			a = entrada.nextLine();
			System.out.println("Ingresa el puntaje del jugador 2: ");
			b = entrada.nextLine();
			
			lapiz.println(a+" "+b);
			System.out.println("Otro Puntaje S/N?");
			res = entrada.nextLine();
        }
        while (res.equalsIgnoreCase("s"));
        	
			lapiz.close();
			DeterminarMayorVentaja();
		
	}
	
	public static Scanner Leer() throws FileNotFoundException {
		File entrada = new File("TextoEntrada.txt");
		obj = new Scanner(entrada);
		 return obj;
	}
	
	public static void DeterminarMayorVentaja() throws FileNotFoundException {
		String ronda;
		Leer();
		Escribir("textoSalida.txt");
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
	
	public static PrintWriter Escribir(String nombreArchivo) {
		try {
            lapiz = new PrintWriter(nombreArchivo, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
		return lapiz;
    
	}
		
	

}
