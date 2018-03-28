package programacionorientada;
import javax.swing.*;


public class numeros2 {

	public static void main(String[] args) {
		int numero=Integer.parseInt(JOptionPane.showInputDialog("Dame un numero del 1 al 20 shabot"));
		getNumero(numero);
		

	}
	public static void getNumero(int num){
		switch(num){
		case 1:
			JOptionPane.showMessageDialog(null, "Es impar");
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "Es par");
			break;
		case 3:
			JOptionPane.showMessageDialog(null, "Es impar");
			break;
		case 4:
			JOptionPane.showMessageDialog(null, "Es par");
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Es impar");
			break;
		case 6:
			JOptionPane.showMessageDialog(null, "Es par");
			break;
		case 7:
			JOptionPane.showMessageDialog(null, "Es impar");
			break;
		case 8:
			JOptionPane.showMessageDialog(null, "Es par");
			break;
		case 9:
			JOptionPane.showMessageDialog(null, "Es impar");
			break;
		case 10:
			JOptionPane.showMessageDialog(null, "Es par");
			break;
		case 11:
			JOptionPane.showMessageDialog(null, "Es impar");
			break;
		case 12:
			JOptionPane.showMessageDialog(null, "Es par");
			break;
		case 13:
			JOptionPane.showMessageDialog(null, "Es impar");
			break;
		case 14:
			JOptionPane.showMessageDialog(null, "Es par");
			break;
		case 15:
			JOptionPane.showMessageDialog(null, "Es impar");
			break;
		case 16:
			JOptionPane.showMessageDialog(null, "Es par");
			break;
		case 17:
			JOptionPane.showMessageDialog(null, "Es impar");
			break;
		case 18:
			JOptionPane.showMessageDialog(null, "Es par");
			break;
		case 19:
			JOptionPane.showMessageDialog(null, "Es impar");
			break;
		case 20:
			JOptionPane.showMessageDialog(null, "Es par");
			break;
	 default:
		 JOptionPane.showMessageDialog(null, "No es un numero entre 1 y 20");
		 break;
		}
	}
}
