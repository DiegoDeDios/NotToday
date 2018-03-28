//Daniela Gonzalez Guemez A01632704
//Diego Alonso Martinez de Dios A01228042
//Porcentajes de contribucion: Daniela - 50 %, Diego - 50 %

package ProyectoMT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Caret;

public class Manual extends JPanel implements ActionListener{
	
	private boolean check=false;
	private Desplegado desplegado;
	private JPanel panel;
	private boolean valido;
	private Deduccion deduccion;
	private Persona persona;
	private JComboBox cbNivel;
	private String[] nivEdu={"Preescolar", "Primaria","Secundaria","Preparatoria","Ninguno"};
	private JButton bAceptar,
					bLimpiar;
	private JTextField tfNombre,
						tfRfc,
						tfSueldoMensual,
						tfAguinaldo,
						tfPrimaVac,
						tfMedHosp,
						tfFunerarios,
						tfSgmm,
						tfHipoteca,
						tfDonativos,
						tfRetiro,
						tfTransporteEsc,
						tfColegiatura;
	private JLabel lNombre,
					lRfc,
					lSueldoMensual,
					lAguinaldo,
					lPrimaVac,
					lMedHosp,
					lFunerarios,
					lSgmm,
					lHipoteca,
					lDonativos,
					lRetiro,
					lTransporteEsc,
					lNivelEducativo,
					lColegiatura,
					lTitulo,
					lDatos,
					lDed,
					lEspacio,
					lEspacioo,
					lEspaciooo,
					lEspacioooo;
	private Font fuente;
	public Manual(){
		super();
		this.setBackground(Color.WHITE);
		fuente=new Font("Georgia", Font.PLAIN, 18);
		this.setPreferredSize(new Dimension(850,850));
		this.setLayout(null);
		this.lTitulo=new JLabel("Ingrese sus datos en el campo correspondiente");
		this.lTitulo.setFont(fuente.deriveFont(34f));
		this.lTitulo.setBounds(80, 0, 800, 80);
		this.add(this.lTitulo);
		this.lDatos=new JLabel("Datos Personales ");
		this.lDatos.setFont(fuente.deriveFont(24f));
		this.lEspacio=new JLabel("                                                                                                                                                                                                          ");
		this.lDatos.setBounds(10, 50, 400, 50);
		this.add(this.lDatos);
		this.add(this.lEspacio);
		this.lNombre=new JLabel("Nombre: ");
		this.lNombre.setFont(fuente);
		this.tfNombre=new JTextField(24);
		this.tfNombre.setFont(fuente);
		this.lNombre.setBounds(20, 80, 400, 50);
		this.add(lNombre);
		this.tfNombre.setBounds(190, 95, 200, 25);
		this.add(tfNombre);
		this.lRfc=new JLabel("RFC: ");
		this.lRfc.setFont(fuente);
		this.tfRfc=new JTextField(16);
		this.tfRfc.setFont(fuente);
		this.lRfc.setBounds(430, 80, 400, 50);
		this.add(this.lRfc);
		this.tfRfc.setBounds(590, 95, 200, 25);
		this.add(this.tfRfc);
		this.lSueldoMensual=new JLabel("Sueldo mensual: ");
		this.lSueldoMensual.setFont(fuente);
		this.tfSueldoMensual=new JTextField(16);
		this.tfSueldoMensual.setFont(fuente);
		this.lSueldoMensual.setBounds(20, 110, 400, 50);
		this.add(this.lSueldoMensual);
		this.tfSueldoMensual.setBounds(190, 125, 200, 25);
		this.add(this.tfSueldoMensual);
		this.lAguinaldo=new JLabel(" Aguinaldo: ");
		this.lAguinaldo.setFont(fuente);
		this.tfAguinaldo=new JTextField(17);
		this.tfAguinaldo.setFont(fuente);
		this.lAguinaldo.setBounds(430, 110, 400, 50);
		this.add(this.lAguinaldo);
		this.tfAguinaldo.setBounds(590, 125, 200, 25);
		this.add(this.tfAguinaldo);
		this.lPrimaVac=new JLabel("Prima Vacacional: ");
		this.lPrimaVac.setFont(fuente);
		this.tfPrimaVac=new JTextField(18);
		this.tfPrimaVac.setFont(fuente);
		this.lPrimaVac.setBounds(20, 140, 400, 50);
		this.add(this.lPrimaVac);
		this.tfPrimaVac.setBounds(190, 155, 200, 25);
		this.add(this.tfPrimaVac);
		this.lEspaciooo=new JLabel("                                                                                                                ");
		this.add(this.lEspaciooo);
		this.lDed=new JLabel("Deducciones ");
		this.lDed.setFont(fuente.deriveFont(24f));
		this.lEspacioo=new JLabel("                                                                                                                                                                                                                            ");
		this.lDed.setBounds(10, 180, 400, 50);
		this.add(this.lDed);
		this.add(this.lEspacioo);
		this.lMedHosp=new JLabel("Médicos/Hospitales:");
		this.lMedHosp.setFont(fuente);
		this.tfMedHosp=new JTextField(15);
		this.tfMedHosp.setFont(fuente);
		this.lMedHosp.setBounds(20, 210, 400, 50);
		this.add(this.lMedHosp);
		this.tfMedHosp.setBounds(190, 225, 200, 25);
		this.add(this.tfMedHosp);
		this.lFunerarios=new JLabel("Gastos funerarios:");
		this.lFunerarios.setFont(fuente);
		this.tfFunerarios=new JTextField(12);
		this.tfFunerarios.setFont(fuente);
		this.lFunerarios.setBounds(430, 210, 400, 50);
		this.add(this.lFunerarios);
		this.tfFunerarios.setBounds(590, 225, 200, 25);
		this.add(this.tfFunerarios);
		this.lSgmm=new JLabel("SGMM: ");
		this.lSgmm.setFont(fuente);
		this.tfSgmm=new JTextField(11);
		this.tfSgmm.setFont(fuente);
		this.lSgmm.setBounds(20, 240, 400, 50);
		this.add(this.lSgmm);
		this.tfSgmm.setBounds(190, 255, 200, 25);
		this.add(this.tfSgmm);
		this.lHipoteca=new JLabel("Hipotecarios: ");
		this.lHipoteca.setFont(fuente);
		this.tfHipoteca=new JTextField(11);
		this.tfHipoteca.setFont(fuente);
		this.lHipoteca.setBounds(430, 240, 400, 50);
		this.add(this.lHipoteca);
		this.tfHipoteca.setBounds(590, 255, 200, 25);
		this.add(this.tfHipoteca);
		this.lDonativos=new JLabel("Donativos: ");
		this.lDonativos.setFont(fuente);
		this.tfDonativos=new JTextField(17);
		this.tfDonativos.setFont(fuente);
		this.lDonativos.setBounds(20, 270, 400, 50);
		this.add(this.lDonativos);
		this.tfDonativos.setBounds(190, 285, 200, 25);
		this.add(this.tfDonativos);
		this.lRetiro=new JLabel("Fondo Retiro: ");
		this.lRetiro.setFont(fuente);
		this.tfRetiro=new JTextField(17);
		this.tfRetiro.setFont(fuente);
		this.lRetiro.setBounds(430, 270, 400, 50);
		this.add(this.lRetiro);
		this.tfRetiro.setBounds(590, 285, 200, 25);
		this.add(this.tfRetiro);
		this.lNivelEducativo=new JLabel("Nivel Educativo:");
		this.lNivelEducativo.setFont(fuente);
		this.cbNivel=new JComboBox(nivEdu);
		this.cbNivel.setFont(fuente);
		this.cbNivel.setSelectedIndex(4);
		this.lNivelEducativo.setBounds(20, 300, 400, 50);
		this.add(this.lNivelEducativo );
		this.cbNivel.setBounds(190, 315, 200, 25);
		this.add(this.cbNivel);
		this.lTransporteEsc=new JLabel("Transporte Escolar:");
		this.lTransporteEsc.setFont(fuente);
		this.tfTransporteEsc=new JTextField(17);
		this.tfTransporteEsc.setFont(fuente);
		this.lTransporteEsc.setBounds(430, 300, 400, 50);
		this.add(this.lTransporteEsc);
		this.tfTransporteEsc.setBounds(590, 315, 200, 25);
		this.add(this.tfTransporteEsc);
		this.lColegiatura=new JLabel("Colegiatura: ");
		this.lColegiatura.setFont(fuente);
		this.tfColegiatura=new JTextField(16);
		this.tfColegiatura.setFont(fuente);
		this.lColegiatura.setBounds(20, 330, 400, 50);
		this.add(this.lColegiatura);
		this.tfColegiatura.setBounds(190, 345, 200, 25);
		this.add(this.tfColegiatura);
		this.lEspacioooo=new JLabel("                                                                                                                                                                                                                                                                ");
		this.add(this.lEspacioooo);
		this.bAceptar=new JButton("Aceptar");
		this.bAceptar.setFont(fuente);
		this.bAceptar.addActionListener(this);
		this.bAceptar.setBounds(590, 400, 100, 30);
		this.add(bAceptar);
		this.bLimpiar=new JButton("Limpiar");
		this.bLimpiar.setFont(fuente);
		this.bLimpiar.setBounds(690, 400, 100, 30);
		this.add(this.bLimpiar);
		this.bLimpiar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Manual.this.limpiarPanel();
			}
		});
		this.persona=new Persona("nombre","rfc","nivel",0,0,0,0,0,0,0,0,0,0,0);
		this.add(new JLabel("                                                                                                                                                            "));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		valido=true;
		String nombre=this.tfNombre.getText(),
				rfc=this.tfRfc.getText(),
				nivel=(String) this.cbNivel.getSelectedItem();
		Double dsueldo=validacion(this.tfSueldoMensual),
				daguinaldo=validacion(this.tfAguinaldo),
				dprima=validacion(this.tfPrimaVac),
				dmedHosp=validacion(this.tfMedHosp),
				dfunerarios=validacion(this.tfFunerarios),
				dsgmm=validacion(this.tfSgmm),
				dhipoteca=validacion(this.tfHipoteca),
				dretiro=validacion(this.tfRetiro),
				dtransporte=validacion(this.tfTransporteEsc),
				dcolegiatura=validacion(this.tfColegiatura),
				ddonativo=validacion(this.tfDonativos);
		
		if (valido==false){
			JOptionPane.showMessageDialog(this, "Los datos no han sido ingresados correctamente, intentelo de nuevo");
		}
		else{
			this.persona=new Persona(nombre,rfc,nivel.toLowerCase(),dsueldo,daguinaldo,dprima,dmedHosp,dfunerarios,dsgmm,dhipoteca,ddonativo,dretiro,dtransporte,dcolegiatura);
			deduccion=new Deduccion(persona);
			if(this.check){
				this.remove(desplegado);
				this.repaint();
				this.check=false;
			}
			desplegado=new Desplegado(deduccion);
			desplegado.setBounds(10,450,800,500);
			this.add(desplegado,BorderLayout.SOUTH);
			this.repaint();
			this.check=true;
			this.revalidate();
		}
	}
	
	private double validacion(JTextField tf){
		double d=0.0;
		try{
			d=Double.parseDouble(tf.getText());
			tf.setBackground(Color.WHITE);
			if(d<0.0){
				throw new Exception();
			}
		}
		catch(Exception e){
			valido=false;
			tf.setBackground(Color.RED);
		}
		return d;
	}
	
	public Persona getPersona(){
		return this.persona;
	}
	
	public void limpiarPanel(){
		try {
			if(this.check){
				this.remove(desplegado);
				this.repaint();
			}
			this.tfNombre.setText("");
			this.tfNombre.setBackground(Color.WHITE);
			this.tfRfc.setText("");
			this.tfRfc.setBackground(Color.WHITE);
			this.tfSueldoMensual.setText("");
			this.tfSueldoMensual.setBackground(Color.WHITE);
			this.tfAguinaldo.setText("");
			this.tfAguinaldo.setBackground(Color.WHITE);
			this.tfPrimaVac.setText("");
			this.tfPrimaVac.setBackground(Color.WHITE);
			this.tfMedHosp.setText("");
			this.tfMedHosp.setBackground(Color.WHITE);
			this.tfFunerarios.setText("");
			this.tfFunerarios.setBackground(Color.WHITE);
			this.tfSgmm.setText("");
			this.tfSgmm.setBackground(Color.WHITE);
			this.tfHipoteca.setText("");
			this.tfHipoteca.setBackground(Color.WHITE);
			this.tfDonativos.setText("");
			this.tfDonativos.setBackground(Color.WHITE);
			this.tfRetiro.setText("");
			this.tfRetiro.setBackground(Color.WHITE);
			this.tfTransporteEsc.setText("");
			this.tfTransporteEsc.setBackground(Color.WHITE);
			this.tfColegiatura.setText("");
			this.tfColegiatura.setBackground(Color.WHITE);
			this.cbNivel.setSelectedIndex(4);
			this.repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
