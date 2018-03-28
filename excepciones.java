package programacionorientada;

import javax.swing.JOptionPane;

public class excepciones {

	public static void main(String[] args) throws ArithmeticException {
		int	numero1=Integer.parseInt(JOptionPane.showInputDialog("Dame un numero"));
		int	numero2=Integer.parseInt(JOptionPane.showInputDialog("Dame un numero"));
		System.out.println(numero1/numero2);
		

	}

}
