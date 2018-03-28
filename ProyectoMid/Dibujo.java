//Daniela Gonzalez Guemez A01632704
//Diego Alonso Martinez de Dios A01228042
//Porcentajes de contribucion: Daniela - 50 %, Diego - 50 %

package ProyectoMT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.*;

public class Dibujo extends JPanel implements ActionListener{
	
	private PrintWriter pw;
	
	private Deduccion deduccion;
	private Persona persona;
	private ArrayList <Persona> arreglo=new ArrayList<Persona>();
	
	private Image img;
	private JLabel lBienv,
					lEsc;
	private JRadioButton rbArchivo,
							rbManual;
	private ButtonGroup grupo;
	private JButton bAceptar;
	private JFileChooser fc;
	private Manual manual;
	private Interfaz interfaz;
	private Font fuente;
	public Dibujo(){
		super();
		this.setPreferredSize(new Dimension(600,400));
		this.img=new ImageIcon("shcp.jpg").getImage();
		fuente=new Font("Georgia", Font.PLAIN, 50);  
		this.lBienv=new JLabel();
		this.lEsc=new JLabel();
		this.lBienv.setText("Bienvenido!");
		this.lEsc.setText("Escoge de que manera quieres ingresar tus datos:");
		this.lBienv.setFont(fuente); 
		this.lEsc.setFont(fuente.deriveFont(24f));
		this.add(this.lBienv);
		this.add(this.lEsc);
		this.rbArchivo=new JRadioButton("Archivo",true);
		this.rbManual=new JRadioButton("Manual", false);
		this.rbArchivo.setFont(fuente.deriveFont(18f));
		this.rbManual.setFont(fuente.deriveFont(18f));
		this.rbArchivo.setBackground(Color.WHITE);
		this.rbManual.setBackground(Color.WHITE);
		this.grupo=new ButtonGroup();
		this.grupo.add(this.rbArchivo);
		this.grupo.add(rbManual);
		this.add(this.rbArchivo);
		this.add(this.rbManual);
		this.bAceptar=new JButton("Aceptar");
		this.bAceptar.setFont(fuente.deriveFont(18f));
		this.bAceptar.addActionListener(this);
		this.add(this.bAceptar);
		this.fc=new JFileChooser();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(img, 0,0,this.getWidth(), this.getHeight(), this);
		//repaint();
		
	}
	
	public PrintWriter getPrintWriter(){
		return this.pw;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.fc.setDialogTitle("Seleccione el archivo que desea abrir");
		if(this.rbArchivo.isSelected()){
			int res =this.fc.showOpenDialog(this);
			if (res==this.fc.APPROVE_OPTION){
				try{
					StringTokenizer st;
					BufferedReader br=new BufferedReader(new FileReader(this.fc.getSelectedFile().toString()));
					String linea;
					while((linea=br.readLine())!=null){
						st=new StringTokenizer(linea);
						 String nombre=st.nextToken(",");
						 String RFC=st.nextToken(",");
						 
						 double sueldoMensual=Double.parseDouble(st.nextToken(",")),
								 aguinaldoRecibido=Double.parseDouble(st.nextToken(",")),
								 primaVacacional=Double.parseDouble(st.nextToken(",")),
								 medicoHosp=Double.parseDouble(st.nextToken(",")),
								 gastFun=Double.parseDouble(st.nextToken(",")),
								 sgmm=Double.parseDouble(st.nextToken(",")),
								 hipoteca=Double.parseDouble(st.nextToken(",")),
								 donativos=Double.parseDouble(st.nextToken(",")),
								 retiro=Double.parseDouble(st.nextToken(",")),
								 transporte=Double.parseDouble(st.nextToken(","));
						 String nivelEducativo=st.nextToken(",");
						 double pagoCole=Double.parseDouble(st.nextToken(","));
						 
						arreglo.add(new Persona(nombre,RFC,nivelEducativo,sueldoMensual,aguinaldoRecibido,
								primaVacacional,medicoHosp,gastFun,sgmm,hipoteca,donativos,retiro,transporte,pagoCole));
					}
					br.close();
					this.fc.setDialogTitle("Guardar como"); 
					JOptionPane.showMessageDialog(this, "Seleccione la direccion y nombre a guardar", "Guardar nuevo archivo de ISR", JOptionPane.INFORMATION_MESSAGE);
					if (this.fc.showSaveDialog(this)==this.fc.APPROVE_OPTION){
						
						deduccion=new Deduccion(arreglo,this.fc.getSelectedFile().toString());
					}
					
					
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(this, "Ha ocurrido un error al abrir el archivo");
				}
				
			}
		}
		else{
			manual=new Manual();
			interfaz=new Interfaz(manual);
		}
	}
}
