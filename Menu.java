package RepasoExamen2.MasGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Menu extends JPanel implements MouseListener, MouseMotionListener{
	private boolean pinta;
	private String ruta;
	private Image imagen;
	private int XCirculo,YCirculo,anchoCirc,largoCirc,tetaInicial,tetaFinal;
	private boolean dibujar;
	public Menu(){
		super();
		this.tetaInicial=0;
		this.dibujar=false;
		this.tetaFinal=0;
		this.XCirculo=50;
		this.pinta=false;
		this.YCirculo=40;
		this.anchoCirc=20;
		this.largoCirc=20;
		this.setPreferredSize(new Dimension(800,600));
		this.imagen=new ImageIcon("Grafica.png").getImage();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Bienvenido", 360, 20);	
		g.drawImage(this.imagen,0,0,this.getWidth(),this.getHeight(),this);
		g.fillOval(this.XCirculo, this.YCirculo, this.anchoCirc, this.largoCirc);
		g.fillArc(350, 260, 100, 100, this.tetaInicial,this.tetaFinal );
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		/*this.XCirculo=e.getX();
		this.YCirculo=e.getY();
		repaint();*/
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		this.XCirculo=e.getX();
		this.YCirculo=e.getY();
		repaint();
		
	}
	public void setPinta(boolean pinta){
		this.pinta=pinta;
	}
	public void dibujarCirculito(Graphics g){
		super.paintComponent(g);
		g.drawOval(500, 250, 20, 20);
		repaint();
	}
	public void setTetaFinal(int tetaFinal){
		this.tetaFinal=tetaFinal;
		repaint();
	}
	
}
