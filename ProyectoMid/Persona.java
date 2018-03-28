//Daniela Gonzalez Guemez A01632704
//Diego Alonso Martinez de Dios A01228042
//Porcentajes de contribución: Daniela - 50 %, Diego - 50 %

package ProyectoMT;

public class Persona {
	
	private String nombre,
	RFC,
	NivelEducativo;
	private double sueldoMensual,
	aguinaldoRecibido,
	primaVacacional,
	dMedicosHospitales,
	dGastosFunerarios,
	dSGMM,
	dHipotecarios,
	dDonativos,
	dSubcuentaRetiro,
	dTransporteEscolar,
	dTotalPagadoColegiatura;
	public Persona(String nombre, String RFC, String NivelEducativo, double sueldoMensual, double aguinaldoRecibido, double primaVacacional, double dMedicosHospitales, double dGastosFunerarios, double dSGMM, double dHipotecarios, double dDonativos, double dSubcuentaRetiro, double dTransporteEscolar, double dTotalPagadoColegiatura){
	this.nombre=nombre;
	this.RFC=RFC;
	this.NivelEducativo=NivelEducativo;
	this.sueldoMensual=sueldoMensual;
	this.aguinaldoRecibido=aguinaldoRecibido;
	this.primaVacacional=primaVacacional;
	this.dMedicosHospitales=dMedicosHospitales;
	this.dGastosFunerarios=dGastosFunerarios;
	this.dSGMM=dSGMM;
	this.dHipotecarios=dHipotecarios;
	this.dDonativos=dDonativos;
	this.dSubcuentaRetiro=dSubcuentaRetiro;
	this.dTransporteEscolar=dTransporteEscolar;
	this.dTotalPagadoColegiatura=dTotalPagadoColegiatura;
	}
	public String getNombre(){
	return this.nombre;
	}
	public String getRFC(){
	return this.RFC;
	}
	public String getNivelEducativo(){
		return this.NivelEducativo;
	}
	public double getSueldoMensual(){
	return this.sueldoMensual;
	}
	public double getAguinaldoRecibido(){
	return this.aguinaldoRecibido;
	}
	public double getPrimaVacacional(){
	return this.primaVacacional;
	}
	public double getDMedicosHosptiales(){
	return this.dMedicosHospitales;
	}
	public double getDGastosFunerarios(){
	return this.dGastosFunerarios;
	}
	public double getDSGMM(){
	return this.dSGMM;
	}
	public double getDHipotecarios(){
	return this.dHipotecarios;
	}
	public double getDDonaciones(){
	return this.dDonativos;
	}
	public double getDSubcuentaRetiro(){
	return this.dSubcuentaRetiro;
	}
	public double getDTransporteEscolar(){
	return this.dTransporteEscolar;
	}
	public double getTotalPagadoColegiatura(){
	return this.dTotalPagadoColegiatura;
	}
	
	public String toString(){
		String s="";
		s+=this.nombre+this.RFC+this.NivelEducativo+this.sueldoMensual+this.aguinaldoRecibido+this.primaVacacional+this.dMedicosHospitales+this.dGastosFunerarios+this.dSGMM+this.dHipotecarios+this.dDonativos+this.dSubcuentaRetiro+this.dTransporteEscolar+this.dTotalPagadoColegiatura;
		return s;
	}
}
