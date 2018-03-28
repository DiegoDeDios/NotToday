package proyectoFn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/*50% Diego Alonso Martínez de Dios 
 *50% Diego Issac Cardenas 
 */
public class Notas{
	
	private JFrame win;
	
	private JMenu  archivo;
	
	private JMenuBar menu;
	
	private JMenuItem nuevo,
				  abrir,
				  guardar,
				  salir;
	
	private JTextArea texto;
	
	private JScrollPane jScroll;
	
	public Notas(){
	
	    
		this.win = new JFrame("Raspbian Notes"); 
	    this.menu = new JMenuBar();
	    this.archivo = new JMenu("Archivo");
	    this.nuevo = new JMenuItem("Nuevo");
	  	this.abrir = new JMenuItem("Abrir");
	  	this.guardar = new JMenuItem("Guardar");
	  	this.salir = new JMenuItem("Salir");
	  	this.texto = new JTextArea();
	  	
	  	this.archivo.add(this.nuevo);
	  	this. archivo.add(this.abrir);
	  	this. archivo.add(this.guardar);
	  	this. archivo.add(this.salir);
	    this.menu.add(this.archivo);
	    this.win.setJMenuBar(menu);
	    
	 	this.win.add(new JScrollPane(this.texto));
	    this.nuevo.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            Notas nuevaNota=new Notas();
	        }
	    });
	    
	    this.abrir.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            abrirArchivo();
	        }
	    });
	    
	    this.guardar.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            guardarArchivo();
	        }
	    });
	    
	    this.salir.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        
	        		win.dispose();
	        	
	        }
	    });
	 	
	    win.setSize(480, 320);
	    win.setVisible(true);
	    win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	public void guardarArchivo() {
	
    JFileChooser fc = new JFileChooser();
    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
    
    if (JFileChooser.APPROVE_OPTION == fc.showSaveDialog(this.win)) {
             
        FileWriter escribir= null;
        
        try {
        			
        	escribir = new FileWriter(fc.getSelectedFile());
        	escribir.write(this.texto.getText());
            escribir.close();
            
        } 
        
        catch (FileNotFoundException ex) {
        	JOptionPane.showMessageDialog(null, "Error");
        } 
        catch (IOException ex) {
        	JOptionPane.showMessageDialog(null, "Error");
        } 
    }
}
	public void abrirArchivo() {
		
		JFileChooser fc = new JFileChooser();
	    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    
	    if (JFileChooser.APPROVE_OPTION == fc.showOpenDialog(this.win)) {
	        	    	
	        try {
	        	String linea;
	        	String sb="";
	            BufferedReader br = new BufferedReader(new FileReader(fc.getSelectedFile()));
	            
	            while ((linea= br.readLine()) != null) {
	            	sb+=(linea+"\n");
	            }
	           
	            this.texto.setText(sb.toString());
	            br.close();
	        } 
	        
	        catch (FileNotFoundException ex) {
	            JOptionPane.showMessageDialog(null, "Error");
	        } 
	        
	        catch (IOException ex) {
	        	JOptionPane.showMessageDialog(null, "Error");
	        } 
	    }
	   
	}

}