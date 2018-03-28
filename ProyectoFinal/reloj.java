package proyectoFn;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*50% Diego Alonso Martínez de Dios 
 *50% Diego Issac Cardenas 
 */
public class reloj extends JPanel {
	Calendar calendario;
	int hora,minuto,segundo,year,mes,dia;
	JLabel datos;
	JLabel fecha;
	Thread runnableClock;
	Color fondo;
	public reloj(){
		super();
		this.setPreferredSize(new Dimension(480,20));
		this.datos= new JLabel();
		this.fecha= new JLabel();
		this.fondo= Color.decode("#9a9898");
		this.setBackground(this.fondo);
		this.add(this.datos);
		this.add(this.fecha);
		this.runnableClock= new Thread(new Runnable(){ //Este metodo hace que cada 1000 milisegundos (1 segundo) se actualice el JLabel de la hora
			public void run() {
					while(true){
						try{
							Calendar cal= Calendar.getInstance(); //Objeto de tipo Calendario
							reloj.this.clock(cal);
							Thread.sleep(1000);
						}
						catch(InterruptedException ex){
							System.out.println("error");
						}
						reloj.this.repaint();
					}
				}
			}
			);
		this.runnableClock.start();
	}
	public void clock(Calendar calendario){ //Este metodo recibe un objeto de tipo calendario e iguala cada variable a sus respectivas unidades de tiempo
		this.hora= calendario.get(Calendar.HOUR);
		this.minuto=calendario.get(Calendar.MINUTE);
		this.segundo=calendario.get(Calendar.SECOND);
		this.year=calendario.get(Calendar.YEAR);
		this.mes=calendario.get(Calendar.MONTH);
		this.dia=calendario.get(Calendar.DAY_OF_MONTH);
		this.datos.setText(this.hora+":"+this.minuto+":"+this.segundo);
		this.fecha.setText(this.dia+"/"+this.mes+"/"+this.year);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
	
	
}
