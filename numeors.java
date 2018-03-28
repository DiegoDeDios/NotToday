package programacionorientada;
import javax.swing.*;


public class numeors {

	public static void main(String[] args) {
		boolean nuevoNumero=true;
		while(nuevoNumero){
			int numero=Integer.parseInt(JOptionPane.showInputDialog("Cual es tu numero shabo? \n (Debe ser entre 1 y 20)"));
			getNumero(numero);
			String salir=JOptionPane.showInputDialog("Quieres verificar otro numero? S/N");
			if(salir.equals("N")){
				nuevoNumero=false;
			}
			else{
				nuevoNumero=true;
			}
		}
		
	}
	public static void getNumero(int number){
		if(number>=1 && number<=20){
			if(number%2!=0){
				JOptionPane.showMessageDialog(null, "Es Impar");
			}
			else{
				JOptionPane.showMessageDialog(null, "Es Par");
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Introduce un numero entre 1 y 20");
		}
		
	}

}
