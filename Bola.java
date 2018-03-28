package programacionorientada;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bola extends JPanel{
	private int xBola=0, yBola=0,vectorX=1,vectorY=1, xRect;
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.fillOval(this.xBola, this.yBola, 10, 10);
	}
	public void movimiento(){
		if(this.xBola+this.vectorX < 0){
			this.vectorX=1;
		}
		else if(this.xBola+this.vectorX>getWidth()-10){
			this.vectorX=-1;
		}
		else if(this.yBola+this.vectorY < 0){
			this.vectorY=1;
		}
		else if(this.yBola+this.vectorY > getHeight()-10){
			this.vectorY=-1;
		}
		this.xBola=this.xBola+this.vectorX;
		this.yBola=this.yBola+this.vectorY;
		repaint();
	}
	public static void main(String[] args) throws InterruptedException {
		JFrame ventana= new JFrame();
		Bola bola = new Bola();
		ventana.add(bola);
		ventana.setVisible(true);
		ventana.setSize(480,320);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while(true){
			bola.movimiento();
			Thread.sleep(10);
		}
	}

}
