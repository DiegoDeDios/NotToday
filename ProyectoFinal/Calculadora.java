package proyectoFn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*50% Diego Alonso Martínez de Dios 
 *50% Diego Issac Cardenas 
 */
public class Calculadora extends JPanel implements ActionListener{
	private JLabel resultado;
	private JButton[] btNumeros, btOperadores;
	private JButton salir;
	private String operando;
	private JFrame frame;
	private Dimension tamaño;
	private double x1,x2;
	private Color colorBtn;
	private boolean verdadSuma, verdadResta, verdadMult, verdadDiv;
	public Calculadora(){
		super();
		this.operando="";
		this.x1=0.0;
		this.x2=0.0;
		this.verdadSuma=false;
		this.verdadResta=false;
		this.verdadMult=false;
		this.verdadDiv=false;
		this.colorBtn=Color.decode("#F04242");
		this.setLayout(null);
		this.tamaño=new Dimension(480,350);
		this.salir= new JButton("Salir");
		this.salir.setBounds(380, 30, 90, 30);
		this.frame= new JFrame("Calculadora");
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.add(this);
		this.frame.setSize(this.tamaño);
		this.setPreferredSize(this.tamaño);
		this.frame.pack();
		this.frame.add(new reloj(), BorderLayout.NORTH);
		this.frame.setVisible(true);
		this.resultado= new JLabel();
		this.btNumeros= new JButton[10];
		this.btOperadores= new JButton[6];
		this.add(this.resultado=new JLabel());
		this.resultado.setBounds(220, 30, 160, 20);
		for(int i=0;i<this.btNumeros.length;i++){
			this.btNumeros[i]= new JButton();
			this.btNumeros[i].setText(String.valueOf(i));
		}
		this.btOperadores[0]= new JButton("+");
		this.btOperadores[1]= new JButton("-");
		this.btOperadores[2]= new JButton("*");
		this.btOperadores[3]= new JButton("/");
		this.btOperadores[4]=new JButton("=");
		this.btOperadores[5]= new JButton("AC");
		for(int i=0;i<this.btOperadores.length;i++){
			this.add(this.btOperadores[i]);
		}
		this.add(this.salir);
		this.salir.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Calculadora.this.frame.dispose();
			}
			
		});
		this.btOperadores[0].setBounds(70, 55, 50, 40);
		this.btOperadores[1].setBounds(70, 90, 50, 40);
		this.btOperadores[2].setBounds(70, 125, 50, 40);
		this.btOperadores[3].setBounds(70, 160, 50, 40);
		this.btOperadores[4].setBounds(70,195,50,40);
		this.btOperadores[5].setBounds(290, 30, 55, 55);
		this.btNumeros[0].setBounds(200, 240, 60, 50);
		this.btNumeros[1].setBounds(130, 90, 60, 50);
		this.btNumeros[2].setBounds(200, 90, 60, 50);
		this.btNumeros[3].setBounds(270, 90, 60, 50);
		this.btNumeros[4].setBounds(130, 140, 60, 50);
		this.btNumeros[5].setBounds(200, 140, 60, 50);
		this.btNumeros[6].setBounds(270, 140, 60, 50);
		this.btNumeros[7].setBounds(130, 190, 60, 50);
		this.btNumeros[8].setBounds(200, 190, 60, 50);
		this.btNumeros[9].setBounds(270, 190, 60, 50);
		for(int i=0; i<this.btNumeros.length;i++){
			this.add(this.btNumeros[i]);
		}
		for(int i=0;i<this.btNumeros.length;i++){
			this.btNumeros[i].addActionListener(this);
		}
		for(int i=0;i<this.btOperadores.length;i++){
			this.btOperadores[i].addActionListener(this);
		}
	}
	public void setSumaTrue(boolean verdad){
		this.verdadSuma=verdad;
	}
	public void setRestaTrue(boolean verdad){
		this.verdadResta=verdad;
	}
	public void setMultTrue(boolean verdad){
		this.verdadMult=verdad;
	}
	public void setDivTrue(boolean verdad){
		this.verdadDiv=verdad;
	}
	public boolean getSumaTrue(){
		return this.verdadSuma;
	}
	public boolean getRestaTrue(){
		return this.verdadResta;
	}
	public boolean getMultTrue(){
		return this.verdadMult;
	}
	public boolean getDivTrue(){
		return this.verdadDiv;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btNumeros[0]){
			this.operando+="0";
			this.resultado.setText(this.operando);
		}
		else if(e.getSource()==this.btNumeros[1]){
			this.operando+="1";
			this.resultado.setText(this.operando);
		}
		else if(e.getSource()==this.btNumeros[2]){
			this.operando+="2";
			this.resultado.setText(this.operando);
		}
		else if(e.getSource()==this.btNumeros[3]){
			this.operando+="3";
			this.resultado.setText(this.operando);
		}
		else if(e.getSource()==this.btNumeros[4]){
			this.operando+="4";
			this.resultado.setText(this.operando);
		}
		else if(e.getSource()==this.btNumeros[5]){
			this.operando+="5";
			this.resultado.setText(this.operando);
		}
		else if(e.getSource()==this.btNumeros[6]){
			this.operando+="6";
			this.resultado.setText(this.operando);
		}
		else if(e.getSource()==this.btNumeros[7]){
			this.operando+="7";
			this.resultado.setText(this.operando);
		}
		else if(e.getSource()==this.btNumeros[8]){
			this.operando+="8";
			this.resultado.setText(this.operando);
		}
		else if(e.getSource()==this.btNumeros[9]){
			this.operando+="9";
			this.resultado.setText(this.operando);
		}
		else if(e.getSource()==this.btOperadores[0]){
			this.x1=Double.parseDouble(this.resultado.getText());
			this.resultado.setText("");
			this.operando="";
			this.setSumaTrue(true);
			this.setRestaTrue(false);
			this.setMultTrue(false);
			this.setDivTrue(false);
		}
		else if(e.getSource()==this.btOperadores[1]){
			this.x1=Double.parseDouble(this.resultado.getText());
			this.resultado.setText("");
			this.operando="";
			this.setRestaTrue(true);
			this.setSumaTrue(false);
			this.setMultTrue(false);
			this.setDivTrue(false);
		}
		else if(e.getSource()==this.btOperadores[2]){
			this.x1=Double.parseDouble(this.resultado.getText());
			this.resultado.setText("");
			this.operando="";
			this.setMultTrue(true);
			this.setSumaTrue(false);
			this.setRestaTrue(false);
			this.setDivTrue(false);
		}
		else if(e.getSource()==this.btOperadores[3]){
			this.x1=Double.parseDouble(this.resultado.getText());
			this.resultado.setText("");
			this.operando="";
			this.setDivTrue(true);
			this.setSumaTrue(false);
			this.setRestaTrue(false);
			this.setMultTrue(false);
		}
		else if(e.getSource()==this.btOperadores[4]){
			if(this.getSumaTrue()==true){
				this.x2=Double.parseDouble(this.resultado.getText());
				this.resultado.setText(String.valueOf(this.x2+this.x1));
				this.operando="";
			}
			else if(this.getRestaTrue()){
				this.x2=Double.parseDouble(this.resultado.getText());
				this.resultado.setText(String.valueOf(this.x1-this.x2));
				this.operando="";
			}
			else if(this.getMultTrue()){
				this.x2=Double.parseDouble(this.resultado.getText());
				this.resultado.setText(String.valueOf(this.x1*this.x2));
				this.operando="";
			}
			else if(this.getDivTrue()){
				try{
					this.x2=Double.parseDouble(this.resultado.getText());
					this.resultado.setText(String.valueOf(this.x1/this.x2));
					this.operando="";
				}
				catch(ArithmeticException ex){
					this.resultado.setText("Error matematico");
				}
			}
		}
		else if(e.getSource()==this.btOperadores[5]){
			this.resultado.setText("0");
			this.operando="";
			this.x1=0;
			this.x2=0;
			this.setDivTrue(false);
			this.setSumaTrue(false);
			this.setRestaTrue(false);
			this.setMultTrue(false);
		}
		
	}
}
