package programacionorientada;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.*;

public class Ventana extends JFrame {

	public Ventana (){
		super("Mi primera ventana en Java");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		PanelDibujo pd= new PanelDibujo();
		this.add(pd);
		this.add(new PanelControles(pd),BorderLayout.WEST);
		this.pack(); 
		this.setVisible(true);
	}
	public static void main(String[] args) {
		Ventana win = new Ventana();

	}

}
