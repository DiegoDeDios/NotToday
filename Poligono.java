package programacionorientada;

import javax.swing.JOptionPane;
import java.lang.Math;
public class Poligono{
	private int lados;
	public Poligono(int lados){
		this.setLados(lados);
	}
	public void setLados(int lados){
		this.lados=lados;
	}
	public static void main (String [] args){
		
	int a=Integer.parseInt(JOptionPane.showInputDialog("Cuantos lados tiene el polinomio? "));
	Poligono poligono= new Poligono(a);
}
}
