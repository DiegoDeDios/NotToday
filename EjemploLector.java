package programacionorientada;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
//Nombre: Diego Alonso Mart�nez de Dios A01228042
//Clase: EjemploLector
//Fecha: 27 de febrero del 2017
public class EjemploLector {

	public static void main(String[] args) {
		BufferedReader bf;
		String linea;
		try {
			bf = new BufferedReader(new FileReader("/Users/DiegoAlonso/Documents/horasTrabajadas.txt"));
			while((linea=bf.readLine())!=null){
				System.out.println(linea);
			}
			bf.close();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Error, archivo no encontrado ");
			System.out.println(ex);
		}
		catch(IOException ex){
			JOptionPane.showMessageDialog(null,"Eror al leer archivo");
			System.out.println(ex);
		}
		
	}

}
