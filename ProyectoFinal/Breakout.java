package proyectoFn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/*50% Diego Alonso Martínez de Dios 
 *50% Diego Issac Cardenas 
 */
public class Breakout extends JPanel implements KeyListener, ActionListener{
	private int xBola, yBola,vectorX,vectorY, xRect, xEnemy, velocidadBola, velocidadPaletas;
	private Color fondo;
	private Dimension tamaño;
	private JButton salir, bIzquierda, bDerecha;
	private JFrame frame;
	private int vidasPlayer;
	private Thread hilo;
	public Breakout(){ //Constructor
		super();
		this.frame= new JFrame("Pong");
		this.vidasPlayer=5;
		this.velocidadBola=7;
		this.velocidadPaletas=23;
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frame.add(this);
		this.frame.pack();
		this.frame.add(new reloj(), BorderLayout.NORTH);
		this.salir= new JButton("Salir");
		this.bIzquierda= new JButton("<-");
		this.bDerecha= new JButton("->");
		this.setLayout(null);
		this.salir.setBounds(380, 280, 90, 30);
		this.xRect=210;
		this.xEnemy=210;
		this.xBola=0;
		this.yBola=0;
		this.vectorX=1;
		this.vectorY=1;
		this.fondo=Color.decode("#00A3B2");
		this.setBackground(this.fondo);
		this.tamaño= new Dimension(480,360);
		this.setPreferredSize(this.tamaño);
		this.frame.setSize(this.tamaño);
		this.frame.setVisible(true);
		this.hilo=new Thread(new Runnable(){

			@Override
			/*
			 * Thread que corre el juego y sus metodos correspondientes,
			 *  se actualiza mediante una variable para ir aumentando 
			 *  la velocidad de la pelota y las paletas
			 */
			public void run() {
				while(true){
					try{
						Breakout.this.movimiento();
						Breakout.this.repaint();
						Thread.sleep(Breakout.this.velocidadBola);
					}
					catch(InterruptedException ex){
						System.out.println(ex);
					}
				}
			}
			
		});
		hilo.start();
		this.addKeyListener(this);
		this.setFocusable(true);
		this.bDerecha.setBounds(360, 50, 40, 40);
		this.bIzquierda.setBounds(80, 50, 40, 40);
		this.add(this.salir);
		this.bDerecha.addActionListener(this);
		this.bIzquierda.addActionListener(this);
		this.add(this.bDerecha);
		this.add(this.bIzquierda);
		this.salir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Breakout.this.frame.dispose();
				Breakout.this.hilo.stop();
			}
			
		});
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.fillRect(this.xRect, 240, 50, 10); //si la posicion de la bola es igual al intervalo de xRect y el ancho, rebota
		g.fillRect(this.xEnemy, 20, 50, 10);
		g.fillOval(this.xBola, this.yBola, 10, 10);
		g.drawString(String.valueOf(this.vidasPlayer), 240, 50);
		
	}
	public void movimiento(){ // Este metodo comunica a la bola que al tocar un borde de la pantalla se refleje su dirección en su respectivo eje
		if(this.xBola+this.vectorX < 0){
			this.vectorX=1;
		}
		else if(this.xBola+this.vectorX>this.tamaño.getWidth()-10){
			this.vectorX=-this.vectorX;
		}
		else if(new Rectangle(this.xBola,this.yBola,10,10).intersects(new Rectangle(this.xRect,240,50,10)) ){
			this.vectorY=-this.vectorY;
		}
		else if(new Rectangle(this.xBola,this.yBola,10,10).intersects(new Rectangle(this.xEnemy,20,50,10)) ){
			this.vectorY=1;
		}
		this.xBola=this.xBola+this.vectorX;
		this.yBola=this.yBola+this.vectorY;
		this.anotar();
		this.ganarJuego();
	}
	@SuppressWarnings("deprecation")
	public void anotar(){ // Si las coordenadas de la bola salen de la pantalla, se resta una vida y se reinicia la posicion de la bola al centro de la pantalla con una dirección especificada
		if(this.yBola<=0){
			this.vidasPlayer-=1;
			this.xBola=240;
			this.yBola=180;
			this.vectorX=1;
			this.vectorY=1;
			if(this.velocidadBola!=1){
				this.velocidadBola-=1;
				this.velocidadPaletas+=5;
				}
			repaint();
		}
		else if(this.yBola>=this.tamaño.getHeight()-10){
			this.vidasPlayer-=1;
			this.xBola=240;
			this.yBola=180;
			this.vectorX=-1;
			this.vectorY=-1;
			if(this.velocidadBola!=1){
			this.velocidadBola-=1;
			this.velocidadPaletas+=6;
			}
			repaint();
		}
		
	}
	public void ganarJuego(){ //Al llegar a 0 las vidas, el Thread se detiene y el juego informa que ha perdido
		if(this.vidasPlayer==0){
			JOptionPane.showMessageDialog(this, "Perdiste :c");
			this.vidasPlayer=5;
			this.velocidadBola=7;
			this.velocidadPaletas=23;
		}
	}
	public void keyTyped(KeyEvent e) {

	}
	public void keyPressed(KeyEvent e) {      
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){ 
			this.movimientoDerecha();
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			this.movimientoIzquierda();
		}
	}
	public void keyReleased(KeyEvent e) {
	
	}
	@Override
	public void actionPerformed(ActionEvent e) { //ActionListeners de los botones de direccion en pantalla
		if(e.getSource()==this.bDerecha){
			this.movimientoDerecha();
		}
		else if(e.getSource()==this.bIzquierda){
			this.movimientoIzquierda();
		}
		
	}
	public void movimientoDerecha(){ //Hace que al mover una paleta, la paleta opuesta se mueva en dirección contraria
		this.xRect+=this.velocidadPaletas;
		this.xEnemy-=this.velocidadPaletas;
	}
	public void movimientoIzquierda(){
		this.xRect-=this.velocidadPaletas;
		this.xEnemy+=this.velocidadPaletas;
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
