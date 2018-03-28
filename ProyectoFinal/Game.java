package proyectoFn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/*50% Diego Alonso Martínez de Dios 
 *50% Diego Issac Cardenas 
 */
public class Game extends JPanel implements ActionListener{
	
	private Font fuente=new Font("TimesRoman", Font.PLAIN,16);
	
	private Casilla[][] casilla;
	
	private int score;
	
	private JButton arriba,
					abajo,
					izquierda,
					derecha,
					reiniciar;
	private JFrame ventana;
	private Dimension tamaño;
	private Color fondo;
	//genero mis botones, creo mi panel y le doy valores iniciales a mi array que simula ser el panel del juego

	public Game(){
		setFocusable(true);
		this.ventana= new JFrame("2048");
		this.ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.tamaño= new Dimension(480,320);
		this.setPreferredSize(this.tamaño);
		this.ventana.setSize(this.tamaño);
		this.ventana.add(this);
		this.ventana.pack();
		this.ventana.setVisible(true);
		this.ventana.add(new reloj(),BorderLayout.NORTH);
		this.setLayout(null);
		this.arriba=new JButton("Up");
		this.abajo=new JButton("Down");
		this.izquierda=new JButton("Left");
		this.derecha=new JButton("Right");
		this.fondo= Color.decode("#428BCA");
		this.setBackground(this.fondo);
		this.arriba.setBounds(50,100,85,40);
		this.izquierda.setBounds(10,140, 85,40);
		this.derecha.setBounds(90,140, 85,40);
		this.abajo.setBounds(50,180,85,40);
		this.arriba.addActionListener(this);	
		this.abajo.addActionListener(this);
		this.izquierda.addActionListener(this);
		this.derecha.addActionListener(this);
		
		this.reiniciar=new JButton("Reiniciar");
		this.reiniciar.setBounds(50,250,100,30);
		this.reiniciar.addActionListener(this);
		
		this.add(this.arriba);
		this.add(this.abajo);
		this.add(this.izquierda);
		this.add(this.derecha);
		this.add(this.reiniciar);
		casilla=new Casilla[4][4];
		this.score=0;
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				casilla[i][j]=new Casilla();
			}
		}
		casilla[0][0].setValor(0);
		casilla[0][1].setValor(0);
		casilla[0][2].setValor(0);
		casilla[0][3].setValor(2);
		casilla[1][0].setValor(0);
		casilla[1][1].setValor(0);
		casilla[1][2].setValor(2);
		casilla[1][3].setValor(2);
		casilla[2][0].setValor(2);
		casilla[2][1].setValor(0);
		casilla[2][2].setValor(2);
		casilla[2][3].setValor(0);
		casilla[3][0].setValor(2);
		casilla[3][1].setValor(2);
		casilla[3][2].setValor(2);
		casilla[3][3].setValor(2);
	}
	
	
	//pinto cada cosa para que queden en las posiciones que quiero  y los números los dibujo a partir de un método que recibe el valor
	//de cada casilla
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		g.setFont(this.fuente);
		g.drawString((this.score+""), 10, 50);
		g.setColor(Color.lightGray);
		g.fillRect(180, 10, 240, 240);
		g.setColor(Color.BLACK);
		
		g.drawRect(180, 10,60 , 60);
		g.drawString(casilla[0][0].getValor(),200, 45);
		
		g.drawRect(240, 10, 60 , 60);
		g.drawString(casilla[0][1].getValor(),260, 45);
		
		g.drawRect(300, 10, 60 , 60);
		g.drawString(casilla[0][2].getValor(),320, 45);
		
		g.drawRect(360, 10, 60 , 60);
		g.drawString(casilla[0][3].getValor(),380, 45);
		//---------------------------------------------
		g.drawRect(180, 70, 60 , 60);
		g.drawString(casilla[1][0].getValor(),200, 105);
		
		g.drawRect(240, 70, 60, 60);
		g.drawString(casilla[1][1].getValor(),260, 105);
		
		g.drawRect(300, 70, 60 , 60);
		g.drawString(casilla[1][2].getValor(),320, 105);
		
		g.drawRect(360, 70, 60, 60);
		g.drawString(casilla[1][3].getValor(),380, 105);
		//-----------------------------------------------
		g.drawRect(180, 130, 60, 60);
		g.drawString(casilla[2][0].getValor(),200, 165);
		
		g.drawRect(240, 130, 60 , 60);
		g.drawString(casilla[2][1].getValor(),260, 165);
		
		g.drawRect(300, 130, 60, 60);
		g.drawString(casilla[2][2].getValor(),320, 165);
		
		g.drawRect(360, 130, 60, 60);
		g.drawString(casilla[2][3].getValor(),380, 165);
		//-----------------------------------------
		g.drawRect(180, 190, 60, 60);
		g.drawString(casilla[3][0].getValor(),200, 225);
		
		g.drawRect(240, 190, 60, 60);
		g.drawString(casilla[3][1].getValor(),260, 225);
		
		g.drawRect(300, 190, 60, 60);
		g.drawString(casilla[3][2].getValor(),320, 225);
		
		g.drawRect(360, 190, 60, 60);
		g.drawString(casilla[3][3].getValor(),380, 225);
		
	}
	
	
	//se encarga de generar el numero a poner en la nueva casilla
	
	public int vCasilla(){
		int resultado=0;
		
		if(this.generarRandom()>=3){
			resultado=8;
		}
		else if(this.generarRandom()>1){
			resultado=4;
		}
		else{
			resultado=2;
		}
		
		return resultado;
	}
//Añade un bloque a la izquierda random
	public void generarBloqueIzq(){
		
		boolean z=true;
		int a=0;
		int b=0;
		while(z && b<10){
		
			if(casilla[(a=this.generarRandom())][0].getValorNum()==0){
					this.casilla[a][0].setValor(this.vCasilla());
					z=false;
			}
			b+=1;
		}
	}
	
	//Añade un bloque a la derecha random
	
	public void generarBloqueDer(){
		
		boolean z=true;
		int a=0;
		int b=0;
		while(z && b<10){
		
			if(casilla[(a=this.generarRandom())][3].getValorNum()==0){
					this.casilla[a][3].setValor(this.vCasilla());
					z=false;
			}
			b+=1;
		}
	
	}
	
	//añade un bloque arriba
	public void generarBloqueArriba(){
		
		boolean z=true;
		int a=0;
		int b=0;
		while(z && b<10){
		
			if(casilla[0][(a=this.generarRandom())].getValorNum()==0){
					this.casilla[0][a].setValor(this.vCasilla());
					z=false;
			}
			b+=1;
		}
	}
	
	//añade un bloque abajo
	public void generarBloqueAbajo(){
		
		boolean z=true;
		int a=0;
		int b=0;
		while(z && b<10){
		
			if(casilla[0][(a=this.generarRandom())].getValorNum()==0){
					this.casilla[0][a].setValor(this.vCasilla());
					z=false;
			}
			b+=1;
		}
		
	}

	//añade puntos al marcador
	public void puntos(){
		this.score+=10;
	}
	
	//genera un numero random de 0 a 3
	public int generarRandom(){
		
		int numero= (int) (Math.random() * 3);
	
	 return numero;
	}
	
	public void reiniciar(){
		casilla[0][0].setValor(0);
		casilla[0][1].setValor(0);
		casilla[0][2].setValor(0);
		casilla[0][3].setValor(2);
		casilla[1][0].setValor(0);
		casilla[1][1].setValor(0);
		casilla[1][2].setValor(2);
		casilla[1][3].setValor(2);
		casilla[2][0].setValor(2);
		casilla[2][1].setValor(0);
		casilla[2][2].setValor(2);
		casilla[2][3].setValor(0);
		casilla[3][0].setValor(2);
		casilla[3][1].setValor(2);
		casilla[3][2].setValor(2);
		casilla[3][3].setValor(2);
		this.score=0;
		this.repaint();
	}
	
	//comprobar si el juevo se ha terminado
	
	public boolean juegoGanado(){
		
		boolean terminado=false;
		int contador=0;
		
		for(int k=0;k<4;k++){
			for(int i=0;i<4;i++){
				if(casilla[k][i].getValorNum()==2048){
					contador=1;
				}
			}
		}
		
		if(contador==1){
			terminado=true;
		}
		
		else{
			terminado=false;
		}
		
		return terminado;
	}
	@Override
	//La lógica del movimiento en dado caso de que le de click a la derecha
	public void actionPerformed(ActionEvent e) {
		if(!juegoGanado()){
		if(e.getSource()==this.derecha){
			for(int k=0;k<4;k++){
				for(int i=3;i>(-1);i--){
					
					// aqui me encargo de analizar todas las filas y ver las posibilidades para en dado caso de que se cumpla una condición
					//se genere cierto movimieneto dependiendo a la situación, así funcionan todos mis ifs
					
					if(this.casilla[k][i].lleno() && (i-1)>(-1) && this.casilla[k][i-1].lleno() && this.casilla[k][i].getValorNum()==this.casilla[k][i-1].getValorNum()){
						
						int val=(this.casilla[k][i].getValorNum()*2);
						this.casilla[k][i-1].setValor(0);
						this.casilla[k][i].setValor(val);
						this.puntos();
						
						for(int j=3;j>(-1);j--){
							
							if(this.casilla[k][j].lleno()==false && (j-1)>(-1) && this.casilla[k][j-1].lleno()){									
								
								this.casilla[k][j].setValor(this.casilla[k][j-1].getValorNum());
								this.casilla[k][j-1].setValor(0);
								this.puntos();
							}
						}						
					}
					
					else if(this.casilla[k][i].lleno() && (i-2)>(-1) && this.casilla[k][i-2].lleno() && this.casilla[k][i].getValorNum()==this.casilla[k][i-2].getValorNum()){
						int val=(this.casilla[k][i].getValorNum()*2);
						
						this.casilla[k][i].setValor(val);
						this.casilla[k][i-2].setValor(0);	
						this.puntos();
						
						for(int j=3;j>(-1);j--){
							
							if(this.casilla[k][j].lleno()==false && (j-1)>(-1) && this.casilla[k][j-1].lleno()){									
								
								this.casilla[k][j].setValor(this.casilla[k][j-1].getValorNum());
								this.casilla[k][j-1].setValor(0);
								this.puntos();
							}
						}			
						
					}
					
					else if(this.casilla[k][i].lleno() && (i-3)>(-1) && this.casilla[k][i-3].lleno() && this.casilla[k][i].getValorNum()==this.casilla[k][i-3].getValorNum()){
						int val=(this.casilla[k][i].getValorNum()*2);
						this.casilla[k][i-3].setValor(0);
						this.casilla[k][i].setValor(val);
						this.puntos();
						
						for(int j=3;j>(-1);j--){
							
							if(this.casilla[k][j].lleno()==false && (j-1)>(-1) && this.casilla[k][j-1].lleno()){									
								this.casilla[k][j].setValor(this.casilla[k][j-1].getValorNum());
								this.casilla[k][j-1].setValor(0);	
								this.puntos();
								
							}
						}
					}
					
					else if(this.casilla[k][i].lleno()==false && (i-1)>(-1) && this.casilla[k][i-1].lleno() ){
						
						int val=(this.casilla[k][i-1].getValorNum());
						
						this.casilla[k][i].setValor(val);
						this.casilla[k][i-1].setValor(0);	
						this.puntos();
		
						for(int j=3;j>(-1);j--){
							
							if(this.casilla[k][j].lleno()==false && (j-1)>(-1) && this.casilla[k][j-1].lleno()){									
								
								this.casilla[k][j].setValor(this.casilla[k][j-1].getValorNum());
								this.casilla[k][j-1].setValor(0);		
								this.puntos();
							}
						}			
						
					}
					
					else if(this.casilla[k][i].lleno()==false && (i-2)>(-1) && this.casilla[k][i-2].lleno() ){
						
						int val=(this.casilla[k][i-2].getValorNum());
						
						this.casilla[k][i].setValor(val);
						this.casilla[k][i-2].setValor(0);	
						this.puntos();
						
						for(int j=3;j>(-1);j--){
							
							if(this.casilla[k][j].lleno()==false && (j-1)>(-1) && this.casilla[k][j-1].lleno()){									
								
								this.casilla[k][j].setValor(this.casilla[k][j-1].getValorNum());
								this.casilla[k][j-1].setValor(0);
								this.puntos();
							}
					}
					}
					
					else if(this.casilla[k][i].lleno()==false && (i-3)>(-1) && this.casilla[k][i-3].lleno() ){
						
						int val=(this.casilla[k][i-3].getValorNum());
						
						this.casilla[k][i].setValor(val);
						this.casilla[k][i-3].setValor(0);	
						this.puntos();
						
						for(int j=3;j>(-1);j--){
							
							if(this.casilla[k][j].lleno()==false && (j-1)>(-1) && this.casilla[k][j-1].lleno()){									
								
								this.casilla[k][j].setValor(this.casilla[k][j-1].getValorNum());
								this.casilla[k][j-1].setValor(0);		
								this.puntos();
							}
						}	
					}
					
				}
			}
			
			this.generarBloqueIzq();
			this.repaint();
		
		}
		
		
		//La lógica del movimiento en dado caso de que le de click a la izquierda
		else if(e.getSource()==this.izquierda){
			for(int k=0;k<4;k++){
				for(int i=0;i<4;i++){
					 
					// aqui me encargo de analizar todas las filas y ver las posibilidades para en dado caso de que se cumpla una condición
					//se genere cierto movimieneto dependiendo a la situación, así funcionan todos mis ifs
					
					if(this.casilla[k][i].lleno() && (i+1)<4 && this.casilla[k][i+1].lleno() && this.casilla[k][i].getValorNum()==this.casilla[k][i+1].getValorNum()){
						
						int val=(this.casilla[k][i].getValorNum()*2);
						this.casilla[k][i+1].setValor(0);
						this.casilla[k][i].setValor(val);
						this.puntos();
						
						for(int j=0;j<4;j++){
							
							if(this.casilla[k][j].lleno()==false && (j+1)<(4) && this.casilla[k][j+1].lleno()){									
								
								this.casilla[k][j].setValor(this.casilla[k][j+1].getValorNum());
								this.casilla[k][j+1].setValor(0);
								this.puntos();
							}
						}						
					}
					
					else if(this.casilla[k][i].lleno() && (i+2)<(4) && this.casilla[k][i+2].lleno() && this.casilla[k][i].getValorNum()==this.casilla[k][i+2].getValorNum()){
						int val=(this.casilla[k][i].getValorNum()*2);
						
						this.casilla[k][i].setValor(val);
						this.casilla[k][i+2].setValor(0);	
						this.puntos();
						
						for(int j=0;j<(4);j++){
							
							if(this.casilla[k][j].lleno()==false && (j+1)<(4) && this.casilla[k][j+1].lleno()){									
								
								this.casilla[k][j].setValor(this.casilla[k][j+1].getValorNum());
								this.casilla[k][j+1].setValor(0);	
								this.puntos();
							}
						}			
						
					}
					
					else if(this.casilla[k][i].lleno() && (i+3)<4 && this.casilla[k][i+3].lleno() && this.casilla[k][i].getValorNum()==this.casilla[k][i+3].getValorNum()){
						int val=(this.casilla[k][i].getValorNum()*2);
						this.casilla[k][i+3].setValor(0);
						this.casilla[k][i].setValor(val);
						this.puntos();
						
						for(int j=0;j<1;j++){
							
							if(this.casilla[k][j].lleno()==false && (j+1)<4 && this.casilla[k][j+1].lleno()){									
								
								this.casilla[k][j].setValor(this.casilla[k][j+1].getValorNum());
								this.casilla[k][j+1].setValor(0);
								this.puntos();
							}
						}			
					}
					
					else if(this.casilla[k][i].lleno()==false && (i+1)<(4) && this.casilla[k][i+1].lleno() ){
						
						int val=(this.casilla[k][i+1].getValorNum());
						
						this.casilla[k][i].setValor(val);
						this.casilla[k][i+1].setValor(0);	
						this.puntos();
						
						for(int j=0;j<(4);j++){
							
							if(this.casilla[k][j].lleno()==false && (j+1)<(4) && this.casilla[k][j+1].lleno()){									
								
								this.casilla[k][j].setValor(this.casilla[k][j+1].getValorNum());
								this.casilla[k][j+1].setValor(0);
								this.puntos();
							}
						}	
					}
					
					else if(this.casilla[k][i].lleno()==false && (i+2)<(4) && this.casilla[k][i+2].lleno() ){
						
						int val=(this.casilla[k][i+2].getValorNum());
						
						this.casilla[k][i].setValor(val);
						this.casilla[k][i+2].setValor(0);	
						this.puntos();
						
						for(int j=0;j<(4);j++){
							
							if(this.casilla[k][j].lleno()==false && (j+1)<(4) && this.casilla[k][j+1].lleno()){									
								
								this.casilla[k][j].setValor(this.casilla[k][j+1].getValorNum());
								this.casilla[k][j+1].setValor(0);	
								this.puntos();
							}
						}	
					}
					
					else if(this.casilla[k][i].lleno()==false && (i+3)<(4) && this.casilla[k][i+3].lleno() ){
						
						int val=(this.casilla[k][i+3].getValorNum());
						
						this.casilla[k][i].setValor(val);
						this.casilla[k][i+3].setValor(0);
						this.puntos();
						
						
						for(int j=0;j<(4);j++){
							
							if(this.casilla[k][j].lleno()==false && (j+1)<(4) && this.casilla[k][j+1].lleno()){									
								
								this.casilla[k][j].setValor(this.casilla[k][j+1].getValorNum());
								this.casilla[k][j+1].setValor(0);	
								this.puntos();
							}
						}	
					}
		
					
					
				}
			}
			
			this.generarBloqueDer();
			
			this.repaint();

		}
		
		//La lógica del movimiento en dado caso de que le de click abajo
		else if(e.getSource()==this.abajo){
			for(int k=0;k<4;k++){
				for(int i=3;i>=0;i--){
					
					// aqui me encargo de analizar todas las columnas y ver las posibilidades para en dado caso de que se cumpla una condición
					//se genere cierto movimieneto dependiendo a la situación, así funcionan todos mis ifs
					
					if(this.casilla[i][k].lleno() && (i-1)>(-1) && this.casilla[i-1][k].lleno() && this.casilla[i][k].getValorNum()==this.casilla[i-1][k].getValorNum()){
						
						int val=(this.casilla[i][k].getValorNum()*2);
						this.casilla[i-1][k].setValor(0);
						this.casilla[i][k].setValor(val);
						this.puntos();
						
						for(int j=3;j>(-1);j--){
							
							if(this.casilla[j][k].lleno()==false && (j-1)>(-1) && this.casilla[j-1][k].lleno()){									
								
								this.casilla[j][k].setValor(this.casilla[j-1][k].getValorNum());
								this.casilla[j-1][k].setValor(0);	
								this.puntos();
							}
						}						
					}
					else if(this.casilla[i][k].lleno() && (i-2)>(-1) && this.casilla[i-2][k].lleno() && this.casilla[i][k].getValorNum()==this.casilla[i-2][k].getValorNum()){
						
						int val=(this.casilla[i][k].getValorNum()*2);
						this.casilla[i-2][k].setValor(0);
						this.casilla[i][k].setValor(val);
						this.puntos();
						
						for(int j=3;j>(-1);j--){
							
							if(this.casilla[j][k].lleno()==false && (j-1)>(-1) && this.casilla[j-1][k].lleno()){									
								
								this.casilla[j][k].setValor(this.casilla[j-1][k].getValorNum());
								this.casilla[j-1][k].setValor(0);
								this.puntos();
							}
						}						
					}
					
					else if(this.casilla[i][k].lleno() && (i-3)>(-1) && this.casilla[i-3][k].lleno() && this.casilla[i][k].getValorNum()==this.casilla[i-3][k].getValorNum()){
						
						int val=(this.casilla[i][k].getValorNum()*2);
						this.casilla[i-3][k].setValor(0);
						this.casilla[i][k].setValor(val);
						this.puntos();
						
						for(int j=3;j>(-1);j--){
							
							if(this.casilla[j][k].lleno()==false && (j-1)>(-1) && this.casilla[j-1][k].lleno()){									
								
								this.casilla[j][k].setValor(this.casilla[j-1][k].getValorNum());
								this.casilla[j-1][k].setValor(0);	
								this.puntos();
							}
						}						
					}
					
					else if(this.casilla[i][k].lleno()==false && (i-1)>(-1) && this.casilla[i-1][k].lleno() ){
						
						int val=(this.casilla[i-1][k].getValorNum());
						
						this.casilla[i][k].setValor(val);
						this.casilla[i-1][k].setValor(0);	
						this.puntos();
						
						for(int j=3;j>(-1);j--){
							
							if(this.casilla[j][k].lleno()==false && (j-1)>(-1) && this.casilla[j-1][k].lleno()){									
								
								this.casilla[j][k].setValor(this.casilla[j-1][k].getValorNum());
								this.casilla[j-1][k].setValor(0);
								this.puntos();
							}
						}				
					}
					
					else if(this.casilla[i][k].lleno()==false && (i-2)>(-1) && this.casilla[i-2][k].lleno() ){
						
						int val=(this.casilla[i-2][k].getValorNum());
						
						this.casilla[i][k].setValor(val);
						this.casilla[i-2][k].setValor(0);	
						this.puntos();
						for(int j=3;j>(-1);j--){
							
							if(this.casilla[j][k].lleno()==false && (j-1)>(-1) && this.casilla[j-1][k].lleno()){									
								
								this.casilla[j][k].setValor(this.casilla[j-1][k].getValorNum());
								this.casilla[j-1][k].setValor(0);
								this.puntos();
							}
						}				
					}
					
					else if(this.casilla[i][k].lleno()==false && (i-3)>(-1) && this.casilla[i-3][k].lleno() ){
						
						int val=(this.casilla[i-3][k].getValorNum());
						
						this.casilla[i][k].setValor(val);
						this.casilla[i-3][k].setValor(0);	
						this.puntos();
						
						for(int j=3;j>(-1);j--){
							
							if(this.casilla[j][k].lleno()==false && (j-1)>(-1) && this.casilla[j-1][k].lleno()){									
								
								this.casilla[j][k].setValor(this.casilla[j-1][k].getValorNum());
								this.casilla[j-1][k].setValor(0);
								this.puntos();
							}
						}				
					}
					
				}
			}
			
		
			this.generarBloqueArriba();
			this.repaint();

		}
		
		//La lógica del movimiento en dado caso de que le de click arriba
		else if(e.getSource()==this.arriba){

			for(int k=0;k<4;k++){
				for(int i=0;i<4;i++){
					
					// aqui me encargo de analizar todas las columnas y ver las posibilidades para en dado caso de que se cumpla una condición
					//se genere cierto movimieneto dependiendo a la situación, así funcionan todos mis ifs
					
					if(this.casilla[i][k].lleno() && (i+1)<4 && this.casilla[i+1][k].lleno() && this.casilla[i][k].getValorNum()==this.casilla[i+1][k].getValorNum()){
						
						int val=(this.casilla[i][k].getValorNum()*2);
						this.casilla[i+1][k].setValor(0);
						this.casilla[i][k].setValor(val);
						this.puntos();
						for(int j=0;j<4;j++){
							
							if(this.casilla[j][k].lleno()==false && (j+1)<4 && this.casilla[j+1][k].lleno()){									
								
								this.casilla[j][k].setValor(this.casilla[j+1][k].getValorNum());
								this.casilla[j+1][k].setValor(0);	
								this.puntos();
							}
						}						
					}
					
					else if(this.casilla[i][k].lleno() && (i+2)<4 && this.casilla[i+2][k].lleno() && this.casilla[i][k].getValorNum()==this.casilla[i+2][k].getValorNum()){
						
						int val=(this.casilla[i][k].getValorNum()*2);
						this.casilla[i+2][k].setValor(0);
						this.casilla[i][k].setValor(val);
						this.puntos();
						for(int j=0;j<4;j++){
							
							if(this.casilla[j][k].lleno()==false && (j+1)<4 && this.casilla[j+1][k].lleno()){									
								
								this.casilla[j][k].setValor(this.casilla[j+1][k].getValorNum());
								this.casilla[j+1][k].setValor(0);	
								this.puntos();
							}
						}						
					}
					
					else if(this.casilla[i][k].lleno() && (i+3)<4 && this.casilla[i+3][k].lleno() && this.casilla[i][k].getValorNum()==this.casilla[i+3][k].getValorNum()){
						
						int val=(this.casilla[i][k].getValorNum()*2);
						this.casilla[i+3][k].setValor(0);
						this.casilla[i][k].setValor(val);
						this.puntos();
						
						for(int j=0;j<4;j++){
							
							if(this.casilla[j][k].lleno()==false && (j+1)<4 && this.casilla[j+1][k].lleno()){									
								
								this.casilla[j][k].setValor(this.casilla[j+1][k].getValorNum());
								this.casilla[j+1][k].setValor(0);	
								this.puntos();
							}
						}						
					}

					else if(this.casilla[i][k].lleno()==false && (i+1)<4 && this.casilla[i+1][k].lleno() ){
						
						int val=(this.casilla[i+1][k].getValorNum());
						
						this.casilla[i][k].setValor(val);
						this.casilla[i+1][k].setValor(0);	
						this.puntos();
							for(int j=0;j<4;j++){
							
							if(this.casilla[j][k].lleno()==false && (j+1)<4 && this.casilla[j+1][k].lleno()){									
								
								this.casilla[j][k].setValor(this.casilla[j+1][k].getValorNum());
								this.casilla[j+1][k].setValor(0);	
								this.puntos();
							}
						}						
					}
					
					else if(this.casilla[i][k].lleno()==false && (i+2)<4 && this.casilla[i+2][k].lleno() ){
						
						int val=(this.casilla[i+2][k].getValorNum());
						
						this.casilla[i][k].setValor(val);
						this.casilla[i+2][k].setValor(0);	
						this.puntos();
							for(int j=0;j<4;j++){
							
							if(this.casilla[j][k].lleno()==false && (j+1)<4 && this.casilla[j+1][k].lleno()){									
								
								this.casilla[j][k].setValor(this.casilla[j+1][k].getValorNum());
								this.casilla[j+1][k].setValor(0);
								this.puntos();
							}
						}						
					}
					
					else if(this.casilla[i][k].lleno()==false && (i+3)<4 && this.casilla[i+3][k].lleno() ){
						
						int val=(this.casilla[i+3][k].getValorNum());
						
						this.casilla[i][k].setValor(val);
						this.casilla[i+3][k].setValor(0);	
						this.puntos();
						
							for(int j=0;j<4;j++){
							
							if(this.casilla[j][k].lleno()==false && (j+1)<4 && this.casilla[j+1][k].lleno()){									
								
								this.casilla[j][k].setValor(this.casilla[j+1][k].getValorNum());
								this.casilla[j+1][k].setValor(0);	
								this.puntos();
							}
						}						
					}
				}
			}

			this.generarBloqueAbajo();
			this.repaint();
		}
		
		else if(e.getSource()==this.reiniciar){
			this.reiniciar();
		}
	}
		else{
			JOptionPane.showMessageDialog(null, "Has ganado");
		}
		
	}
	
	
}
