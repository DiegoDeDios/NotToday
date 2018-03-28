package programacionorientada;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.*;


public class PanelControles extends JPanel implements MouseListener, ChangeListener{
	private JButton btCambiar;
	private JButton btCambiarColor,
					btArchivo;
	private JTextField tfNombre,
						tfArchivo;
	private JRadioButton rbRojo, rbVerde, rbAzul;
	private MouseListener click;
	private PanelDibujo pd;
	private JPanel pc;
	private JFileChooser fc ;
	private JSlider slider;
	private FileReader fr;
	private BufferedReader br;
	public PanelControles(PanelDibujo pd){
		super();
		this.pd=pd;
		this.setPreferredSize(new Dimension(200,600));
		this.btCambiar= new JButton("Saluda");
		this.btCambiar.addActionListener(new ActionListener(){ //Clase Anonima
				public void actionPerformed(ActionEvent e){
					PanelControles.this.pd.setNombre("Hoola");
					pd.setNombre(tfNombre.getText());
				}	
		});
		this.add(this.btCambiar);
		this.tfNombre=new JTextField(15);
		this.add(this.tfNombre);
		
		this.rbRojo=new JRadioButton("Color Rojo",true);
		this.rbVerde=new JRadioButton("Color Verde");
		this.rbAzul=new JRadioButton("Color Azul");
		ButtonGroup bg= new ButtonGroup();
		bg.add(this.rbAzul);
		bg.add(this.rbRojo);
		bg.add(this.rbVerde);
		
		this.add(this.rbRojo);
		this.add(this.rbAzul);
		this.add(this.rbVerde);
		
		this.btCambiarColor = new JButton("Cambiar Color");
		this.btCambiarColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PanelControles.this.rbAzul.isSelected()){
					setBackground(Color.BLUE);
				}
				else if(PanelControles.this.rbRojo.isSelected()){
					setBackground(Color.RED);
				}
				else if(PanelControles.this.rbVerde.isSelected()){
					setBackground(Color.GREEN);
				} 
				
			}
		});
		this.add(this.btCambiarColor);
		this.pc= new JPanel();
		this.pc.setPreferredSize(new Dimension(70, 70));
		this.pc.setBackground(Color.PINK);
		this.add(this.pc);
		this.pc.addMouseListener(this);
		this.tfArchivo= new JTextField();
		this.add(this.tfArchivo);
		
		this.btArchivo= new JButton("Dame un archivo");
		this.btArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp= PanelControles.this.fc.showOpenDialog(PanelControles.this.pd);
				if(resp==JFileChooser.APPROVE_OPTION){
					String rutaArchivo=PanelControles.this.fc.getSelectedFile().toString();
					try {
						br= new BufferedReader(fr=new FileReader(rutaArchivo));
						PanelControles.this.pd.setNombre(PanelControles.this.br.readLine());
						br.close();
					}
					catch (FileNotFoundException e1) {
						System.out.println("Error en la lectura del archivo");
					} catch (IOException e1) {
						System.out.println("No se pudo cambiar el nombre :(");
						e1.printStackTrace();
					}
					System.out.println(rutaArchivo);
					}
				
			}
		});
		this.add(this.btArchivo);
		
		this.fc=new JFileChooser();
		
		this.slider=new JSlider(SwingConstants.VERTICAL,0,200,0);
		this.slider.setPaintTicks(true);
		this.slider.setPaintLabels(true);
		this.slider.setMajorTickSpacing(50);
		this.slider.setMinorTickSpacing(10);
		this.slider.addChangeListener(this);
		this.add(this.slider);
	}
	/*public void actionPerformed(ActionEvent e) {
		/*if(e.getSource()==this.btCambiar){
		this.pd.setNombre(this.tfNombre.getText());
		}*/
		/*else if(e.getSource()==this.btCambiarColor){
			if(this.rbAzul.isSelected()){
				this.setBackground(Color.BLUE);
			}
			else if(this.rbRojo.isSelected()){
				this.setBackground(Color.RED);
			}
			else if(this.rbVerde.isSelected()){
				this.setBackground(Color.GREEN);
			} 
		
		}
		else {*/
			/*int resp= this.fc.showOpenDialog(this.pd);
			if(resp==JFileChooser.APPROVE_OPTION){
				String rutaArchivo=this.fc.getSelectedFile().toString();
				try {
					br= new BufferedReader(fr=new FileReader(rutaArchivo));
					this.pd.setNombre(this.br.readLine());
					br.close();
				}
				catch (FileNotFoundException e1) {
					System.out.println("Error en la lectura del archivo");
				} catch (IOException e1) {
					System.out.println("No se pudo cambiar el nombre :(");
					e1.printStackTrace();
				}
				System.out.println(rutaArchivo);
				}
			}*/
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Color seleccionado = JColorChooser.showDialog(this.pd, "Selector de color", this.pc.getBackground());
		this.pd.setColor(seleccionado);
		this.pc.setBackground(seleccionado);
		
		
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
	public void stateChanged(ChangeEvent e) {
		
		this.pd.setAlturaNave(this.slider.getValue());
	}
}
