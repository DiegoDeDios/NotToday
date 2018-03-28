package proyectoFn;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/*50% Diego Alonso Martínez de Dios 
 *50% Diego Issac Cardenas 
 */
public class RaspGUI extends JPanel {
	private JButton bTemporizador,
					bNotas,
					bCalculadora,
					bPong,
					b2048,
					bExit;
	private Icon[] iconos;
	private Image fondoPantalla;
	public RaspGUI(){ //Constructor, inicializa toda la interfaz del menu principal
		super();
		this.iconos= new Icon[6];
		this.setLayout(null);
		this.setPreferredSize(new Dimension(480,320));
		this.iconos[0]=new ImageIcon("clock.png");
		this.iconos[1]= new ImageIcon("agenda.png");
		this.iconos[2]= new ImageIcon("calcu.png");
		this.iconos[3]= new ImageIcon("pong.png");
		this.iconos[5]= new ImageIcon("exit.png");
		this.fondoPantalla= new ImageIcon("Fondo.jpg").getImage();
		this.bTemporizador= new JButton("Temporizador");
		this.bTemporizador.setBounds(80, 100, 100, 50);
		this.bNotas= new JButton("Notas");
	    this.bNotas.setBounds(180, 100, 110, 50);
		this.bCalculadora= new JButton("Calc.");
		this.bCalculadora.setBounds(290, 100, 100, 50);
		this.bPong= new JButton("Pong");
		this.bPong.setBounds(80,150,100,50);
		this.b2048= new JButton("2048");
		this.b2048.setBounds(180, 150, 110, 50);
		this.bExit= new JButton("Salir");
		this.bExit.setBounds(290, 150, 100, 50);
		this.add(this.bTemporizador);
		this.add(this.bNotas);
		this.add(this.bCalculadora);
		this.add(this.bPong);
		this.add(this.b2048);
		this.add(this.bExit);
		this.bTemporizador.setIcon(this.iconos[0]);
		this.bNotas.setIcon(this.iconos[1]);
		this.bCalculadora.setIcon(this.iconos[2]);
		this.bPong.setIcon(this.iconos[3]);
		this.b2048.setIcon(this.iconos[4]);
		this.bExit.setIcon(this.iconos[5]);
		this.bExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
			
		});
		this.bPong.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//new rBentana(new Breakout());
				new Breakout();
			}
			
		});
		this.bCalculadora.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new Calculadora();
				
			}
			
		});
		this.b2048.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new Game();
			}
			
		});
		this.bTemporizador.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new Temporizador();
				} catch (InterruptedException e1) {
					System.out.println("Error");
				}
				
			}
			
		});
		this.bNotas.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new Notas();
			}
			
		});
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(this.fondoPantalla,0,0,this.getWidth(),this.getHeight(),this);
	}
}
