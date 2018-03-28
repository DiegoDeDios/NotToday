//Daniela Gonzalez Guemez A01632704
//Diego Alonso Martinez de Dios A01228042
//Porcentajes de contribucion: Daniela - 50 %, Diego - 50 %

package ProyectoMT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class Deduccion {
	
	private ArrayList <Persona> arreglo = new ArrayList <Persona> ();
	private double ingresoAnual,
					aguinaldoExcento,
					daguinaldoGravado,
					dprimaExcenta=15.0*80.04,
					dprimaGravada,
					montoDeducirColegiatura,
					dmontoDeducirRetiro,
					totalDeducirSinRetiro,
					ddeduccionPermitida,
					montoCalculoISR,
					cuotaFija,
					porcentajeExcedente,
					pagoExcedente,
					totalPagar,
					totalIngresos,
					totalIngresosGravan;
	private Dibujo db;
	private JFileChooser fc;
	
	
	public Deduccion(ArrayList <Persona> arreglo, String ruta){
		this.arreglo=arreglo;
			try {
				PrintWriter bw=new PrintWriter(new FileWriter(ruta+".csv"));
				bw.println("Nombre,RFC,Sueldo Mensual,Ingreso Anual,Aguinaldo,Aguinaldo Excento,Aguinaldo Gravado,"
						+ "Prima Vacacional,Prima Vacacional Excenta,Prima Vacacional Gravada, Total Ingresos Gravan,"
						+ "Médicos y Hospitales,Gastos Funerarios,SGMM,Hipotecarios,Donativos,Subcuenta Retiro,"
						+ "Transporte Escolar,Nivel Educativo,Máximo a deducir colegiatura,Total Pagado Colegiatura,Monto a deducir retiro,"
						+ "Total Deducciones (sin retiro),Deducciones Permitidas,Monto sobre en cual se calcula el ISR,Cuota Fija,"
						+ "% Excedente limite inferior,Pago excedente límite inferior,Total a Pagar");
				for (int i=0;i<this.arreglo.size();i++){
					Persona persona=arreglo.get(i);
					this.ingresoAnual=persona.getSueldoMensual()*12;
					this.aguinaldoExcento=persona.getSueldoMensual()/2.0;
					this.daguinaldoGravado=this.aguinaldoGravado(persona.getAguinaldoRecibido(),this.aguinaldoExcento);
					this.dprimaGravada=this.primaVacacionalGravada(persona.getPrimaVacacional());
					this.totalIngresos=this.ingresoAnual+persona.getAguinaldoRecibido()+persona.getPrimaVacacional();
					this.totalIngresosGravan=this.ingresoAnual+this.daguinaldoGravado+this.dprimaGravada;
					this.montoDeducirColegiatura=this.maxDeducirColegiatura(persona.getNivelEducativo());
					this.dmontoDeducirRetiro=this.montoDeducirRetiro(this.totalIngresos, persona.getDSubcuentaRetiro());
					this.totalDeducirSinRetiro=this.totalDeducciones(persona.getDMedicosHosptiales(),persona.getDGastosFunerarios(),persona.getDSGMM(),persona.getDHipotecarios(),persona.getDDonaciones(),persona.getDTransporteEscolar(),persona.getTotalPagadoColegiatura(),persona.getNivelEducativo());
					this.ddeduccionPermitida=this.deduccionPermitida();
					this.montoCalculoISR=this.totalIngresosGravan-this.ddeduccionPermitida;
					this.porcentajeExcedente=this.getPorcentajeExcedenteLimiteInferior();
					this.cuotaFija=this.getCuotaFija();
					this.pagoExcedente=this.PagoExcedenteLímiteInferior();
					this.totalPagar=this.cuotaFija+this.pagoExcedente;
					bw.println(persona.getNombre()+","+persona.getRFC()+","+persona.getSueldoMensual()+","+this.ingresoAnual+","+persona.getAguinaldoRecibido()+","+this.aguinaldoExcento+","+this.daguinaldoGravado+","+
							persona.getPrimaVacacional()+","+this.dprimaExcenta+","+this.dprimaGravada+","+this.totalIngresosGravan+","+
							persona.getDMedicosHosptiales()+","+persona.getDGastosFunerarios()+","+persona.getDSGMM()+","+persona.getDHipotecarios()+","+
							persona.getDDonaciones()+","+persona.getDSubcuentaRetiro()+","+persona.getDTransporteEscolar()+","+persona.getNivelEducativo()+","+
							this.montoDeducirColegiatura+","+persona.getTotalPagadoColegiatura()+","+this.dmontoDeducirRetiro+","+
							this.totalDeducirSinRetiro+","+this.ddeduccionPermitida+","+this.montoCalculoISR+","+this.cuotaFija+","+
							this.porcentajeExcedente+","+this.pagoExcedente+","+this.totalPagar);
				}
				bw.close();
				JOptionPane.showMessageDialog(this.db,"Se ha creado el archivo en "+ruta);
			} 
			catch (IOException e1) {
				JOptionPane.showMessageDialog(this.db,"Ha ocurrido un error al guardar el archivo");
				e1.printStackTrace();
			}
	}
	
	public Deduccion(Persona persona){
			this.ingresoAnual=persona.getSueldoMensual()*12;
			this.aguinaldoExcento=persona.getSueldoMensual()/2.0;
			this.daguinaldoGravado=this.aguinaldoGravado(persona.getAguinaldoRecibido(),this.aguinaldoExcento);
			this.dprimaGravada=this.primaVacacionalGravada(persona.getPrimaVacacional());
			this.totalIngresos=this.ingresoAnual+persona.getAguinaldoRecibido()+persona.getPrimaVacacional();
			this.totalIngresosGravan=this.ingresoAnual+this.daguinaldoGravado+this.dprimaGravada;
			this.montoDeducirColegiatura=this.maxDeducirColegiatura(persona.getNivelEducativo());
			this.dmontoDeducirRetiro=this.montoDeducirRetiro(this.totalIngresos, persona.getDSubcuentaRetiro());
			this.totalDeducirSinRetiro=this.totalDeducciones(persona.getDMedicosHosptiales(),persona.getDGastosFunerarios(),persona.getDSGMM(),persona.getDHipotecarios(),persona.getDDonaciones(),persona.getDTransporteEscolar(),persona.getTotalPagadoColegiatura(),persona.getNivelEducativo());
			this.ddeduccionPermitida=this.deduccionPermitida();
			this.montoCalculoISR=this.totalIngresosGravan-this.ddeduccionPermitida;
			this.porcentajeExcedente=this.getPorcentajeExcedenteLimiteInferior();
			this.cuotaFija=this.getCuotaFija();
			this.pagoExcedente=this.PagoExcedenteLímiteInferior();
			this.totalPagar=this.cuotaFija+this.pagoExcedente;
	}
	
	public double aguinaldoGravado(double aguinaldo,double aguinaldoExcento){
		if (aguinaldoExcento>=aguinaldo){
			return 0.0;
		}
		else{
			return aguinaldo-aguinaldoExcento;
		}
	}
	
	public double primaVacacionalGravada(double primaVacacional){
		if (this.dprimaExcenta>=primaVacacional){
			return 0.0;
		}
		else{
			return primaVacacional-this.dprimaExcenta;
		}
	}
	
	public double maxDeducirColegiatura(String nivelEducativo){
		nivelEducativo.toLowerCase();
		if (nivelEducativo.equals("preescolar")){
			return 14200.0;
		}
		else if (nivelEducativo.equals("primaria")){
			return 12900.0;
		}
		else if (nivelEducativo.equals("secundaria")){
			return 19900.0;
		}
		else if (nivelEducativo.equals("preparatoria")){
			return 24500.0;
		}
		else{
			return 0.0;
		}
	}
	
	public double montoDeducirRetiro(double totalIngresos, double retiro){
		if(retiro>=this.totalIngresos*0.1){
			return this.totalIngresos*0.1;
		}
		else{
			return retiro;
		}
	}
	
	public double totalDeducciones(double medHosp, double funerarios, double sgmm, double hipoteca, double donativos, double transporte, double totalColegiatura, String nivelEducativo){
		double d=medHosp+funerarios+sgmm+hipoteca+donativos+transporte;
		if (totalColegiatura>=this.maxDeducirColegiatura(nivelEducativo)){
			return d+=this.maxDeducirColegiatura(nivelEducativo);
		}
		else{
			return d+=totalColegiatura;
		}
	}
	
	public double deduccionPermitida(){
		if(this.totalDeducirSinRetiro>=this.totalIngresos*0.1){
			return this.totalIngresos*0.1+this.dmontoDeducirRetiro;
		}
		else{
			return this.totalDeducirSinRetiro+this.dmontoDeducirRetiro;
		}
	}
	
	public double getCuotaFija(){
		if(this.montoCalculoISR<=5952.84){
			this.setPorcentajeExcedenteLimiteInferior(1.92);
			return 0.0;
		}
		else if(this.montoCalculoISR<=50524.92){
			this.setPorcentajeExcedenteLimiteInferior(6.4);
			return 114.29;
		}
		else if(this.montoCalculoISR<=88793.04){
			this.setPorcentajeExcedenteLimiteInferior(10.88);
			return 2966.91;
		}
		else if(this.montoCalculoISR<=103218){
			this.setPorcentajeExcedenteLimiteInferior(16);
			return 7130.48;
		}
		else if(this.montoCalculoISR<=123580.2){
			this.setPorcentajeExcedenteLimiteInferior(17.92);
			return 9438.47;
		}
		else if(this.montoCalculoISR<=249243.48){
			this.setPorcentajeExcedenteLimiteInferior(21.36);
			return 13087.37;
		}
		else if(this.montoCalculoISR<=392841.96){
			this.setPorcentajeExcedenteLimiteInferior(23.52);
			return 39929.05;
		}
		else if(this.montoCalculoISR<=750000.0){
			this.setPorcentajeExcedenteLimiteInferior(30);
			return 73703.0;
		}
		else if(this.montoCalculoISR<=1000000){
			this.setPorcentajeExcedenteLimiteInferior(32);
			return 180850.82;
		}
		else if(this.montoCalculoISR<=3000000){
			this.setPorcentajeExcedenteLimiteInferior(34);
			return 260850.81;
		}
		else{
			this.setPorcentajeExcedenteLimiteInferior(35);
			return 940850.81;
		}
	}
	public void setPorcentajeExcedenteLimiteInferior(double porcentajeExcedente){
		this.porcentajeExcedente=porcentajeExcedente;
	}
	public double getPorcentajeExcedenteLimiteInferior(){
		return this.porcentajeExcedente;
	}
	public double PagoExcedenteLímiteInferior(){
		if(this.montoCalculoISR<=5952.84){
			return (this.montoCalculoISR-0.01)*(this.getPorcentajeExcedenteLimiteInferior()/100);
		}
		else if(this.montoCalculoISR<=50524.92){
			return (this.montoCalculoISR-5952.85)*(this.getPorcentajeExcedenteLimiteInferior()/100);
		}
		else if(this.montoCalculoISR<=88793.04){
			return (this.montoCalculoISR-50524.93)*(this.getPorcentajeExcedenteLimiteInferior()/100);
		}
		else if(this.montoCalculoISR<=103218){
			return (this.montoCalculoISR-88793.05)*(this.getPorcentajeExcedenteLimiteInferior()/100);
		}
		else if(this.montoCalculoISR<=123580.2){
			return (this.montoCalculoISR-103218.01)*(this.getPorcentajeExcedenteLimiteInferior()/100);
		}
		else if(this.montoCalculoISR<=249243.48){
			return (this.montoCalculoISR-123580.21)*(this.getPorcentajeExcedenteLimiteInferior()/100);
		}
		else if(this.montoCalculoISR<=392841.96){
			return (this.montoCalculoISR-249243.49)*(this.getPorcentajeExcedenteLimiteInferior()/100);
		}
		else if(this.montoCalculoISR<=750000.0){
			return (this.montoCalculoISR-392841.97)*(this.getPorcentajeExcedenteLimiteInferior()/100);
		}
		else if(this.montoCalculoISR<=1000000){
			return (this.montoCalculoISR-750000.01)*(this.getPorcentajeExcedenteLimiteInferior()/100);
		}
		else if(this.montoCalculoISR<=3000000){
			return (this.montoCalculoISR-1000000.01)*(this.getPorcentajeExcedenteLimiteInferior()/100);
		}
		else{
			return (this.montoCalculoISR-3000000.01)*(this.getPorcentajeExcedenteLimiteInferior()/100);
		}
	}
	
	public double getIngresoAnual(){
		return this.ingresoAnual;
	}
	
	public double getAguinaldoExcento(){
		return this.aguinaldoExcento;
	}
	
	public double getAguinaldoGravado(){
		return this.daguinaldoGravado;
	}
	
	public double getPrimaExcenta(){
		return this.dprimaExcenta;
	}
	
	public double getPrimaGravada(){
		return this.dprimaGravada;
	}
	
	public double getMontoDeducirColegiatura(){
		return this.montoDeducirColegiatura;
	}
	
	public double getMontoDeducirRetiro(){
		return this.dmontoDeducirRetiro;
	}
	
	public double getTotalDeducirSinRetiro(){
		return this.totalDeducirSinRetiro;
	}
	
	public double getDeduccionPermitida(){
		return this.ddeduccionPermitida;
	}
	
	public double getMontoCalculoISR(){
		return this.montoCalculoISR;
	}
	
	public double getTotalPagar(){
		return this.totalPagar;
	}
	
	public double getTotalIngresos(){
		return this.totalIngresos;
	}
	
	public double getTotalIngresosGravan(){
		return this.totalIngresosGravan;
	}
	
	public double getPagoExcedente(){
		return this.pagoExcedente;
	}
	
}
