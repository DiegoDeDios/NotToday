package programacionorientada;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Copia {
private BufferedReader br;	
private FileWriter fw;
private PrintWriter pw;
	
	public void hacerCopia(){
		String linea;
		try {
			br = new BufferedReader(new FileReader(JOptionPane.showInputDialog("Porfavor introduzca la ruta del archivo a copiar:")));
			fw= new FileWriter(JOptionPane.showInputDialog("Porfavor introduzca una nueva ruta en donde guardar el archivo")+"//copia.txt");
			pw= new PrintWriter(fw);
			while((linea=br.readLine())!=null){
				pw.println(linea);
			}
			pw.close();
			br.close();
			JOptionPane.showMessageDialog(null, "Copia guardada exitosamente!");
		} 
		catch(FileNotFoundException ex){
			System.out.println("Error, archivo no encontrado");
		}
		catch(IOException ex){
			System.out.println("Error en la escritura/lectura del archivo");
		}
	}
	public static void main(String[] args) {
	Copia cp = new Copia();
	cp.hacerCopia();

	}

}
