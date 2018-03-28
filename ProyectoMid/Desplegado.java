//Daniela Gonzalez Guemez A01632704
//Diego Alonso Martinez de Dios A01228042
//Porcentajes de contribucion: Daniela - 50 %, Diego - 50 %

package ProyectoMT;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Desplegado extends JPanel{
	
	private JLabel lIngresoAnual,
	lAguinaldoExcento,
	lAguinladoGravado,
	lPVExcenta,
	lPVGravada,
	lTotalIngresosGravan,
	lmontoReducirColegiatura,
	lMontoDeducirRetiro,
	lTotalDeduccionesSR,
	lDeduccionesPermitidas,
	lMontoCalculoISR,
	lCuotaFija,
	lPorcentajeExcedente,
	lPagoExcedenteLimiteInf,
	lTotal,
	lIngresos,
	lDeducciones,
	lNumIngresoAnual,
	lNumAguinaldoExcento,
	lNumAguinladoGravado,
	lNumPVExcenta,
	lNumPVGravada,
	lNumTotalIngresosGravan,
	lNummontoReducirColegiatura,
	lNumMontoDeducirRetiro,
	lNumTotalDeduccionesSR,
	lNumDeduccionesPermitidas,
	lNumMontoCalculoISR,
	lNumCuotaFija,
	lNumPorcentajeExcedente,
	lNumPagoExcedenteLimiteInf,
	lNumTotal;
	private Font fuente;
	private DecimalFormat formato;
	
	public Desplegado(Deduccion deduccion){
		super();
		this.setPreferredSize(new Dimension(820,500));
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		fuente=new Font("Georgia", Font.PLAIN, 18);
		this.formato= new DecimalFormat("#.00");
		this.lIngresos=new JLabel("Ingresos");
		this.lIngresos.setFont(fuente.deriveFont(Font.BOLD, 20));
		this.lIngresos.setBounds(10, 5, 400, 30);
		this.add(this.lIngresos);
		lIngresoAnual=new JLabel("Ingreso Anual:");
		this.lIngresoAnual.setFont(fuente);
		this.lIngresoAnual.setBounds(10, 30, 420, 50);
		this.add(lIngresoAnual);
		this.lNumIngresoAnual=new JLabel("$"+this.formato.format(deduccion.getIngresoAnual()));
		this.lNumIngresoAnual.setFont(fuente);
		this.lNumIngresoAnual.setBounds(230, 30, 400, 50);
		this.add(this.lNumIngresoAnual);
		lAguinaldoExcento=new JLabel("Aguinaldo Excento:");
		this.lAguinaldoExcento.setFont(fuente);
		this.lAguinaldoExcento.setBounds(10, 55, 420, 50);
		this.add(lAguinaldoExcento);
		this.lNumAguinaldoExcento=new JLabel("$"+this.formato.format(deduccion.getAguinaldoExcento()));
		this.lNumAguinaldoExcento.setFont(fuente);
		this.lNumAguinaldoExcento.setBounds(230, 55, 400, 50);
		this.add(this.lNumAguinaldoExcento);
		lAguinladoGravado=new JLabel("Aguinaldo Gravado:");
		this.lAguinladoGravado.setFont(fuente);
		this.lAguinladoGravado.setBounds(10, 80, 420, 50);
		this.add(lAguinladoGravado);
		this.lNumAguinladoGravado=new JLabel("$"+this.formato.format(deduccion.getAguinaldoGravado()));
		this.lNumAguinladoGravado.setFont(fuente);
		this.lNumAguinladoGravado.setBounds(230, 80, 400, 50);
		this.add(this.lNumAguinladoGravado);
		lPVExcenta=new JLabel("Prima Vacacional Excenta:");
		this.lPVExcenta.setFont(fuente);
		this.lPVExcenta.setBounds(10, 105, 420, 50);
		this.add(lPVExcenta);
		this.lNumPVExcenta=new JLabel("$"+this.formato.format(deduccion.getPrimaExcenta()));
		this.lNumPVExcenta.setFont(fuente);
		this.lNumPVExcenta.setBounds(230, 105, 400, 50);
		this.add(this.lNumPVExcenta);
		lPVGravada=new JLabel("Prima Vacacional Gravada:");
	    this.lPVGravada.setFont(fuente);
	    this.lPVGravada.setBounds(10, 130, 420, 50);
		this.add(lPVGravada);
		this.lNumPVGravada=new JLabel("$"+this.formato.format(deduccion.getPrimaGravada()));
		this.lNumPVGravada.setFont(fuente);
		this.lNumPVGravada.setBounds(230, 130, 400, 50);
		this.add(this.lNumPVGravada);
		lTotalIngresosGravan=new JLabel("Total de Ingresos Gravan:");
	    this.lTotalIngresosGravan.setFont(fuente);
	    this.lTotalIngresosGravan.setBounds(10, 155, 420, 50);
		this.add(lTotalIngresosGravan);
		this.lNumTotalIngresosGravan=new JLabel("$"+this.formato.format(deduccion.getTotalIngresosGravan()));
		this.lNumTotalIngresosGravan.setFont(fuente);
		this.lNumTotalIngresosGravan.setBounds(230, 155, 400, 50);
		this.add(this.lNumTotalIngresosGravan);
		this.lDeducciones=new JLabel("Deducciones");
		this.lDeducciones.setFont(fuente.deriveFont(Font.BOLD, 20));
		this.lDeducciones.setBounds(10, 200, 400, 30);
		this.add(this.lDeducciones);
		lmontoReducirColegiatura=new JLabel("Deducir Colegiatura:");
	    this.lmontoReducirColegiatura.setFont(fuente);
	    this.lmontoReducirColegiatura.setBounds(10, 225, 420, 50);
		this.add(lmontoReducirColegiatura);
		this.lNummontoReducirColegiatura=new JLabel("$"+this.formato.format(deduccion.getMontoDeducirColegiatura()));
		this.lNummontoReducirColegiatura.setFont(fuente);
		this.lNummontoReducirColegiatura.setBounds(230, 225, 400, 50);
		this.add(this.lNummontoReducirColegiatura);
		lMontoDeducirRetiro=new JLabel("Deducir Retiro:");
		this.lMontoDeducirRetiro.setFont(fuente);
		this.lMontoDeducirRetiro.setBounds(10, 250, 420, 50);
		this.add(lMontoDeducirRetiro);
		this.lNumMontoDeducirRetiro=new JLabel("$"+this.formato.format(deduccion.getMontoDeducirRetiro()));
		this.lNumMontoDeducirRetiro.setFont(fuente);
		this.lNumMontoDeducirRetiro.setBounds(230, 250, 400, 50);
		this.add(this.lNumMontoDeducirRetiro);
		lTotalDeduccionesSR=new JLabel("Total deducciones:");
		this.lTotalDeduccionesSR.setFont(fuente);
		this.lTotalDeduccionesSR.setBounds(10, 275, 420, 50);
		this.add(lTotalDeduccionesSR);
		this.lNumTotalDeduccionesSR=new JLabel("$"+this.formato.format(deduccion.getTotalDeducirSinRetiro()));
		this.lNumTotalDeduccionesSR.setFont(fuente);
		this.lNumTotalDeduccionesSR.setBounds(230, 275, 400, 50);
		this.add(this.lNumTotalDeduccionesSR);
		lDeduccionesPermitidas=new JLabel("Deducciones Permitidas:");
		this.lDeduccionesPermitidas.setFont(fuente);
		this.lDeduccionesPermitidas.setBounds(10, 300, 420, 50);
		this.add(lDeduccionesPermitidas);
		this.lNumDeduccionesPermitidas=new JLabel("$"+this.formato.format(deduccion.getDeduccionPermitida()));
		this.lNumDeduccionesPermitidas.setFont(fuente);
		this.lNumDeduccionesPermitidas.setBounds(230, 300, 400, 50);
		this.add(this.lNumDeduccionesPermitidas);
		
		lMontoCalculoISR=new JLabel("Monto sobre el cual se calcula el ISR:");
		this.lMontoCalculoISR.setFont(fuente);
		this.lMontoCalculoISR.setBounds(400, 25, 420, 50);
		this.add(lMontoCalculoISR);
		this.lNumMontoCalculoISR=new JLabel("$"+this.formato.format(deduccion.getMontoCalculoISR()));
		this.lNumMontoCalculoISR.setFont(fuente);
		this.lNumMontoCalculoISR.setBounds(700, 25, 400, 50);
		this.add(this.lNumMontoCalculoISR);
		lCuotaFija=new JLabel("Cuota Fija:");
		this.lCuotaFija.setFont(fuente);
		this.lCuotaFija.setBounds(400, 50, 420, 50);
		this.add(lCuotaFija);
		this.lNumCuotaFija=new JLabel("$"+this.formato.format(deduccion.getCuotaFija()));
		this.lNumCuotaFija.setFont(fuente);
		this.lNumCuotaFija.setBounds(700, 50, 400, 50);
		this.add(this.lNumCuotaFija);
		lPorcentajeExcedente=new JLabel("Porcentaje excedente:");
		this.lPorcentajeExcedente.setFont(fuente);
		this.lPorcentajeExcedente.setBounds(400, 75, 420, 50);
		this.add(lPorcentajeExcedente);
		this.lNumPorcentajeExcedente=new JLabel(this.formato.format(deduccion.getPorcentajeExcedenteLimiteInferior())+"%");
		this.lNumPorcentajeExcedente.setFont(fuente);
		this.lNumPorcentajeExcedente.setBounds(700, 75, 400, 50);
		this.add(this.lNumPorcentajeExcedente);
		lPagoExcedenteLimiteInf=new JLabel("Pago excedente:");
		this.lPagoExcedenteLimiteInf.setFont(fuente);
		this.lPagoExcedenteLimiteInf.setBounds(400, 100, 420, 50);
		this.add(lPagoExcedenteLimiteInf);
		this.lNumPagoExcedenteLimiteInf=new JLabel("$"+this.formato.format(deduccion.getPagoExcedente()));
		this.lNumPagoExcedenteLimiteInf.setFont(fuente);
		this.lNumPagoExcedenteLimiteInf.setBounds(700, 100, 400, 50);
		this.add(this.lNumPagoExcedenteLimiteInf);
		lTotal=new JLabel("Total a pagar:");
		this.lTotal.setFont(fuente.deriveFont(Font.BOLD, 18));
		this.lTotal.setBounds(400, 150, 420, 50);
		this.add(lTotal);
		this.lNumTotal=new JLabel("$"+this.formato.format(deduccion.getTotalPagar()));
		this.lNumTotal.setFont(fuente);
		this.lNumTotal.setBounds(700, 150, 400, 50);
		this.add(this.lNumTotal);
		}
		
	}


