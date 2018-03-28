package proyectoFn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/*50% Diego Alonso Martínez de Dios 
 *50% Diego Issac Cardenas 
 */
public class Temporizador extends JPanel implements ActionListener{
	
	private int hr,
				min,
				sec;
	
	private String hora;
	
	
	private JButton iniciar,
					parar,
					reiniciar,
					salir,
					hMas,
					hMenos,
					mMas,
					mMenos,
					sMas,
					sMenos;
	
	private Dimension tamaño;
	
	private boolean funcionando, cosaVerdad;
	
	private JFrame ventana;
	
	private Font fuente;
	
	private Thread temporizador;
	
	private Color fondo;
	
	public Temporizador() throws InterruptedException{
		super();
		this.setLayout(null);
		this.ventana= new JFrame("Temporizador");
		this.ventana.add(new reloj(), BorderLayout.NORTH);
		this.funcionando=false;
		this.fondo= Color.decode("#B7EFFF");
		this.hora="00:00:00";
		this.setBackground(this.fondo);
		this.iniciar=new JButton("Iniciar");
		this.parar=new JButton("Parar");
		this.reiniciar=new JButton("Reiniciar");
		this.salir= new JButton("Salir");
		
		this.hMas=new JButton("H:+");
		this.hMenos=new JButton("H:-");
		
		this.mMas=new JButton("M:+");
		this.mMenos=new JButton("M:-");
		
		this.sMas=new JButton("S:+");
		this.sMenos=new JButton("S:-");
		
		
		this.tamaño= new Dimension(480,360);
		
		this.hMas.setBounds(50, 50, 30, 30);
		this.hMenos.setBounds(100, 50, 30, 30);
		
		this.mMas.setBounds(50, 100, 30, 30);
		this.mMenos.setBounds(100, 100, 30, 30);
		
		this.sMas.setBounds(50, 150, 30, 30);
		this.sMenos.setBounds(100, 150, 30, 30);
		
		this.salir.setBounds(380, 280, 90, 30);
		
		this.iniciar.setBounds(110, 200, 90, 30);
		this.parar.setBounds(210, 200, 90, 30);
		this.salir.setBounds(310, 200, 90, 30);
		
		
		this.iniciar.addActionListener(this);
		this.parar.addActionListener(this);
		this.reiniciar.addActionListener(this);
		this.salir.addActionListener(this);
		
		this.hMas.addActionListener(this);
		this.hMenos.addActionListener(this);
		
		this.mMas.addActionListener(this);
		this.mMenos.addActionListener(this);
		
		this.sMas.addActionListener(this);
		this.sMenos.addActionListener(this);
		
		this.add(this.iniciar);
		this.add(this.parar);
		this.add(this.reiniciar);
		this.add(this.salir);
		
		this.add(this.hMas);
		this.add(this.hMenos);
		this.add(this.mMas);
		this.add(this.mMenos);
		this.add(this.sMas);
		this.add(this.sMenos);
		
		this.fuente=new Font("TimesRoman", Font.BOLD, 40);
		
		this.ventana.add(this);
		this.ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.ventana.pack();
		this.ventana.setSize(this.tamaño);
		this.ventana.setVisible(true);
	}
	
	public void tempo(boolean cosaVerdad) throws InterruptedException{
		
		boolean works=cosaVerdad;
		this.temporizador= new Thread(new Runnable(){

			public void run() {
				while(works){
					
					try {
						if(Temporizador.this.sec!=0){
							Temporizador.this.sec-=1;
							Temporizador.this.setHora();
						}
						
						else if(Temporizador.this.sec==0){
							
							if(Temporizador.this.min==0 && Temporizador.this.hr==0){
								JOptionPane.showMessageDialog(Temporizador.this, "El tiempo ha terminado");
								break;
							}
							
							else if(Temporizador.this.min==0 && Temporizador.this.hr!=0){
								Temporizador.this.min=59;
								Temporizador.this.hr-=1;
								Temporizador.this.sec=59;
								Temporizador.this.setHora();
							}
							
							else if(Temporizador.this.min!=0 && Temporizador.this.hr==0){
								Temporizador.this.min-=1;
								Temporizador.this.sec=59;
								Temporizador.this.setHora();
							}
							
							else if(Temporizador.this.min!=0 && Temporizador.this.hr!=0){
								Temporizador.this.min-=1;
								Temporizador.this.sec=59;
								Temporizador.this.setHora();
							}
						}
					
					
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					
				
			}
			
		}
			});
		
	this.temporizador.start();	
	}
	
	public void setHora(){
		String sHr=this.hr>9?this.hr+"":"0"+this.hr;
		String sMin=this.min>9?this.min+"":"0"+this.min;
		String sSec=this.sec>9?this.sec+"":"0"+this.sec;

		this.hora=(sHr+":"+sMin+":"+sSec);
		//System.out.println(this.hora);
		
		this.repaint();
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setFont(this.fuente);
		g.setColor(Color.black);
		g.drawString(this.hora, 180, 170);
		
	}
	
	public boolean funcionando(){
		return this.funcionando;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==this.hMas){
			this.hr+=1;
			
			this.setHora();
		}
		
		if(e.getSource()==this.iniciar){
			try {
				
				this.funcionando=true;	
				this.tempo(this.funcionando);
				
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
		}
		
		if(e.getSource()==this.parar){
		/*	this.funcionando=false;
			try {
				this.tempo(this.funcionando);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
			this.temporizador.stop();
			
		}
		
		if(e.getSource()==this.reiniciar){
			this.funcionando=false;
			this.hr=0;
			this.min=0;
			this.sec=0;
			
			this.setHora();
		}
		
		if(e.getSource()==this.salir){
			this.ventana.dispose();
			if(this.funcionando==true){
			this.temporizador.stop();
			}
		}
		if(e.getSource()==this.hMenos){
			if(this.hr!=0){
				this.hr-=1;
				this.setHora();
			}
			else{
				this.hr=0;
				this.setHora();
			}
		}
		
		if(e.getSource()==this.mMas){
			this.min+=1;
			this.setHora();
		}
		
		if(e.getSource()==this.mMenos){
			if(this.min!=0){
				this.min-=1;
				this.setHora();
			}
			else{
				this.min=0;
				this.setHora();
			}
		}
		
		if(e.getSource()==this.sMas){
			this.sec+=1;
			this.setHora();
		}
		
		else if(e.getSource()==this.sMenos){
			if(this.sec!=0){
				this.sec-=1;
				this.setHora();
			}
			else{
				this.sec=0;
				this.setHora();
			}
		}
		
	}
	
}
