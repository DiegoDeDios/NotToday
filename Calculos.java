package programacionorientada;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculos extends JPanel{
	private JLabel[] labels;
	
	public Calculos(Dimension dimension){
		super();
		this.setPreferredSize(dimension);
		labels= new JLabel[15];
		labels[0].setText("Ingreso Anual");
		labels[1].setText("Aguinaldo Exento");
		labels[2].setText("Aguinaldo Gravado");
		labels[3].setText("Prima Vacacional Exenta");
		labels[4].setText("Prima Vacacional Gravada");
		labels[5].setText("Total Ingresos Gravan");
		labels[6].setText("Maximo a Deducir Colegiatura");
		labels[7].setText("Monto a Deducir Retiro");
		labels[8].setText("Total Deducciones");
		labels[9].setText("Deducciones Permitidas");
		labels[10].setText("Monto sobre el cual calcula ISR");
		labels[11].setText("Cuota Fija");
		labels[12].setText("% Excedente");
		labels[13].setText("Pago excedente limite inferior");
		labels[14].setText("Total a Pagar");
		for(int i=0;i<this.labels.length;i++){
			this.add(labels[i]);
		}
	}

}
