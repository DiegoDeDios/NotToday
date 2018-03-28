package programacionorientada;

//Nombre: Diego Alonso Martínez de Dios A01228042
//Clase: Divison Entera
//Fecha: 27 de Febrero del 2017
import javax.swing.JOptionPane;

public class DivisionEntera {
	public int divide(int a, int b){
		return a/b;
	}
	public void pedirDivision(){
		try{
		int a=Integer.parseInt(JOptionPane.showInputDialog("Dame un numero"));
		int b=Integer.parseInt(JOptionPane.showInputDialog("Dame otro numero"));
		JOptionPane.showMessageDialog(null,"El resultado es "+this.divide(a, b));
		}
		catch(Exception noValido){
			JOptionPane.showMessageDialog(null, "Input invalido, introduce un valor valido (Numeros integros o un denominador mayor a 0)");
			this.pedirDivision(); //No se si esto entra en la categoria de recursividad pero optimiza mejor el codigo.
		}
	}
	public static void main(String[] args) {
		DivisionEntera de= new DivisionEntera();
		de.pedirDivision();
	}
}


