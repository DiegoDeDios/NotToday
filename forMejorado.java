package programacionorientada;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class forMejorado {
	public static <E> void ejemploForEach(E[] datos){
		for(E tmp:datos){ //itera cada elemento de estructura de datos, recibe tipo de dato izquierda y derecho 
			System.out.println(tmp);
		}
	}
	public static void ejemploSwitch(String t){
		System.out.println("La nota es:");
		switch(t){
			case "E":
				System.out.println(10);
				break;
			case "MB":
				System.out.println(9);
				break;
			case "B":
				System.out.println(8);
				break;
			case "S":
				System.out.println(7);
				break;
			default:
				System.out.println(5);
				break;
		}
	}
	public static void escribirArchivo(String ruta){
		try(PrintWriter pw= new PrintWriter(new FileWriter(ruta+"/mejora.txt"));BufferedReader bf = new BufferedReader(new FileReader("Hola.txt"))){ //todo aquello que tenga implementado la interfaz closeable
			pw.println("Hola");
		}
		catch(IOException e){
			System.out.println("Error"+e);
		}
	}
	public static int suma(int...valores){
		int total=0;
		for(int valor:valores){
			total+=valor;
		}
		return total;
		
	}
	public static void impresionFormato(int a, double b){
		System.out.printf("Vamo a imprimir el enterfo %d y ahora el double %#.2f, ya quedo",a,b);
	}
	public static void main(String[] args) {
		Integer[] valores={0,20,30,54,67,56};
		ejemploForEach(valores);
		ejemploSwitch("E");
		escribirArchivo("/Users/DiegoAlonso/Documents");
		System.out.println(suma(10,220,30));
		System.out.println(suma(23,67,34));
		impresionFormato(20,3.5685867);
	}

}
