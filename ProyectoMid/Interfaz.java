//Daniela Gonzalez Guemez A01632704
//Diego Alonso Martinez de Dios A01228042
//Porcentajes de contribucion: Daniela - 50 %, Diego - 50 %

package ProyectoMT;

import java.awt.BorderLayout;

import javax.swing.*;

public class Interfaz extends JFrame{

	public Interfaz(JPanel j){
		super("Impuesto Sobre la Renta");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(j);
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
