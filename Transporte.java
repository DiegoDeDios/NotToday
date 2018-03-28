package programacionorientada;
import javax.swing.*;

public class Transporte {

	public static void main(String[] args) {
		int Kilometro=Integer.parseInt(JOptionPane.showInputDialog("Cuantos kilometros viajo?"));
		String turno=JOptionPane.showInputDialog("En que turno se realizo el viaje? Diurno/Nocturno ");
		getViaje(Kilometro,turno);
	}
	public static void getViaje(int kilometraje,String turno){
		double tarifaMinima=0.0;
		if(kilometraje<=15){
			tarifaMinima=5;
		}
		else{
		if(kilometraje>15){
			tarifaMinima=4;
			}
		}
		if(turno.equals("Nocturno")){
			double costoNocturno=tarifaMinima*15/100;
			tarifaMinima+=costoNocturno;
		}
		double tarifaTotal=tarifaMinima*kilometraje;
		JOptionPane.showMessageDialog(null,"Su viaja ha sido de "+kilometraje+" kilometros en el turno "+turno+"\npor "+tarifaTotal+"$");
		
	}

}
