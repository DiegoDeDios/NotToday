package programacionorientada;
//Estudiar Botones, radiobutons, textfills, checkbox, como se responde a eventos del mouse
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class PanelDibujo extends JPanel /*implements MouseListener,MouseMotionListener*/ {
	private int xN, 
				yN,
				xLetrero,
				yLetrero;
	private String nombre;
	private Image fond;
	private JButton boton;
	private JRadioButton botonCircular;
	private JCheckBox check;
	private boolean moverse;
	private Color color;
	public PanelDibujo(){
		super(); //siempre en GUI llamar al constructor padre
		this.setPreferredSize(new Dimension(800, 600));
		this.xN=this.yN=0;
		this.xLetrero=100;
		this.yLetrero=500;
		this.nombre="Vamos Pocoyo";
		this.moverse=false;
		this.fond= new ImageIcon("pocoyo.png").getImage();
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getX()+" "+e.getY());
				PanelDibujo.this.moverse=true;
				
			}
		});
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				System.out.println("Haciendo drag"+e.getX()+" "+e.getY());
				PanelDibujo.this.xLetrero=e.getX();
				PanelDibujo.this.yLetrero=e.getY();
				repaint();
				
			}
		});
		Thread hilo=new Thread(new Runnable() { //Clase Anonima
			public void run() {
				while(PanelDibujo.this.xN+250<=800){
					try{
						if(moverse){		
							PanelDibujo.this.xN+=4;
							PanelDibujo.this.yN++;
							PanelDibujo.this.repaint();
						
						}
						Thread.sleep(20);
					}
					catch(InterruptedException ex){
						System.out.println("Error");
					}
				}
			}
		});
		hilo.start();
	}
	
	public void paintComponent(Graphics g){ 
		super.paintComponent(g);
		g.drawImage(this.fond,0,0,this.getWidth(),this.getHeight(),this);
		g.setColor(Color.ORANGE);
		g.fillOval(50+this.xN,430-this.yN,200,100);
		g.setColor(Color.CYAN);
		g.fillArc(50+this.xN, 430-this.yN, 200, 100, 0, 100);
		g.drawLine(130+this.xN, 432-this.yN, 130+this.xN, 330-this.yN);
		g.setColor(Color.red);
		g.fillOval(80+this.xN, 230-this.yN, 100, 100);
		g.setColor(color);
		g.fillRect(0, 530, 800, 70);
		g.setColor(Color.BLACK);
		g.drawString(nombre+"!!!", this.xLetrero+this.xN, this.yLetrero-this.yN);
	}
	/*public void run() {
		while(this.xN+250<=800){
			try{
				if(moverse){		
					this.xN+=4;
					this.yN++;
					this.repaint();
				
				}
				Thread.sleep(20);
			}
			catch(InterruptedException ex){
				System.out.println("Error");
			}
		}
	}*/
	public void setAlturaNave(int altura){
		this.yN=altura;
		this.repaint();
	}
	public void setColor(Color color){
		this.color= color;
		this.repaint();
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
		this.repaint();
	}
	/*public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX()+" "+e.getY());
		this.moverse=true;
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("Haciendo drag"+e.getX()+" "+e.getY());
		this.xLetrero=e.getX();
		this.yLetrero=e.getY();
		repaint();
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}*/
}
