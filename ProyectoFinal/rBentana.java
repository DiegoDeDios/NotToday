package proyectoFn;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*50% Diego Alonso Martínez de Dios 
 *50% Diego Issac Cardenas 
 */
public class rBentana extends JFrame {
	private static RaspGUI p;
	public rBentana(JPanel panel){
		super();
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.setSize(new Dimension(480,320));
		this.add(new reloj(),BorderLayout.NORTH);
		this.add(panel);
		this.pack();
		this.setVisible(true);
	}
	public static void main(String [] args){
		p= new RaspGUI();
		rBentana window= new rBentana(p);
	}
}
