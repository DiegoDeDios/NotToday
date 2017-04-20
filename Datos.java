package RepasoExamen2.MasGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Datos extends JPanel implements ActionListener,ChangeListener{
	private JTextField tfNombre,tfEdad,tfCarrera,tfEscuela;
	private JButton btGenerar, btAbrir, btDibujar;
	private JFileChooser fc;
	private JSlider js;
	private int i;
	private String[] datos;
	private double[] puntos;
	private String campoNombre, campoEdad, campoEscuela, campoCarrera;
	private Archivos escritor;
	private Menu menu;
	private FileReader fr;
	private BufferedReader br;
	private boolean dibujar;
	public Datos(Menu menu){
		super();
		this.dibujar=false;
		this.setPreferredSize(new Dimension(250,600));
		this.setNombre("Nombre");
		this.setEdad("Edad");
		this.setCarrera("Carrera");
		this.setEscuela("Escuela");
		this.puntos= new double[5];
		this.menu=menu;
		this.tfNombre=new JTextField(this.getNombre(),15);
		this.tfEdad= new JTextField(this.getEdad(),15);
		this.tfEscuela= new JTextField(this.getEscuela(),15);
		this.tfCarrera= new JTextField(this.getCarrera(),15);
		this.btGenerar= new JButton("Generar documento de identidad");
		this.btAbrir=new JButton("Abrir documento de identidad");
		this.btDibujar=new JButton("Dibujar");
		this.datos= new String[4];
		this.fc= new JFileChooser();
		this.escritor= new Archivos();
		this.i=0;
		this.add(this.tfNombre);
		this.add(this.tfEdad);
		this.add(this.tfCarrera);
		this.add(this.tfEscuela);
		this.add(btGenerar);
		this.add(btAbrir);
		this.add(btDibujar);
		this.btGenerar.addActionListener(this);
		this.btAbrir.addActionListener(this);
		this.btDibujar.addActionListener(this);
		this.js=new JSlider(SwingConstants.VERTICAL,0,360,0);
		this.js.setPaintTicks(true);
		this.js.setPaintLabels(true);
		this.js.setMajorTickSpacing(30);
		this.js.setMinorTickSpacing(10);
		this.js.addChangeListener(this);
		this.add(this.js);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btGenerar){
			
			int guardar= this.fc.showSaveDialog(this.menu);
			if(guardar==JFileChooser.APPROVE_OPTION){
				this.datos[0]=this.tfNombre.getText();
				this.datos[1]=this.tfEdad.getText();
				this.datos[2]=this.tfEscuela.getText();
				this.datos[3]=this.tfCarrera.getText();
				
				String directorio=String.valueOf(this.fc.getSelectedFile());
				this.escritor.escribirArchivo(directorio,datos);
				JOptionPane.showMessageDialog(this.menu, "Archivo Guardado Exitosamente!");
			}
		}
		else if(e.getSource()==this.btAbrir){
			int abrir=this.fc.showOpenDialog(this.menu);
			if(abrir==JFileChooser.APPROVE_OPTION){
				try {
					fr=new FileReader(this.fc.getSelectedFile());
					br=new BufferedReader(fr);
					String linea;
					while((linea=br.readLine())!=null){
						System.out.println(linea);
					}
					br.close();
					fr.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		else if(e.getSource()==this.btDibujar){
			
		}
		else{
			System.out.println("Hola");
		}
		
	}
	public void setNombre(String campoNombre){
		this.campoNombre=campoNombre;
	}
	public void setEdad(String campoEdad){
		this.campoEdad=campoEdad;
	}
	public void setCarrera(String campoCarrera){
		this.campoCarrera=campoCarrera;
	}
	public void setEscuela(String campoEscuela){
		this.campoEscuela=campoEscuela;
	}
	public String getNombre(){
		return this.campoNombre;
	}
	public String getEdad(){
		return this.campoEdad;
	}
	public String getCarrera(){
		return this.campoCarrera;
	}
	public String getEscuela(){
		return this.campoEscuela;
	}
	public void setDibujar(boolean dibujar){
		this.dibujar=dibujar;
	}
	
	

	@Override
	public void stateChanged(ChangeEvent e) {
		this.menu.setTetaFinal(this.js.getValue());
		
	}
}
