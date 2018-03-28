package programacionorientada;

import javax.swing.*;
public class IntroJava{
	public static void calificacion(){
		String sNota=JOptionPane.showInputDialog("Dime una nota");
		int nota= Integer.parseInt(sNota);
		if(nota>=70){
			System.out.println("Aprobado");
		}
		else{
			System.out.println("Reprobado");
			}

	}
	public static void numeros(){
		for(int i=0;i<100;i++){
			System.out.println(i+1);
	}
}
	public static void series(int base){
		for(int i=0;i<50;i++){
			System.out.println(base*(i+1));
		}
	}
	public static int calorias(){
		int numComidas=Integer.parseInt(JOptionPane.showInputDialog("Cuantas comidas?"));
		int totalCal=0;
		for(int i=0;i<numComidas;i++){
			totalCal+=Integer.parseInt(JOptionPane.showInputDialog("Cuantas calorias en la comida"+(i)));
			
		}
		return totalCal;
	}
	

public static void main(String[] args){
	calificacion();
	numeros();
	series(2);
	int caloriastotales=calorias();
	}
}