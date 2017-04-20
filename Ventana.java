package RepasoExamen2.MasGUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Ventana extends JFrame {
	public Ventana(){
		super("Bienvenido");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Menu menu= new Menu();
		this.add(new Datos(menu));
		this.add(menu,BorderLayout.EAST);
		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		Ventana window= new Ventana();

	}

}
