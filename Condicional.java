package programacionorientada;
import javax.swing.*;

public class Condicional {
	public String getNaipe(String naipe){
		String[] caracteres=naipe.split("");
		String notacionNaipe=caracteres[0];
		String paloNaipe=caracteres[1];
		if(caracteres.length<3 && caracteres.length>1){
			switch(notacionNaipe){
			case "A":
				notacionNaipe="As";
				break;
			case "J":
				notacionNaipe="Joto";
				break;
			case "Q":
				notacionNaipe="Reina";
				break;
			case "K":
				notacionNaipe="Rey";
				break;
			case "2":
				notacionNaipe="Dos";
				break;
			case "3":
				notacionNaipe="Tres";
				break;
			case "4":
				notacionNaipe="Cuatro";
				break;
			case "5":
				notacionNaipe="Cinco";
				break;
			case "6":
				notacionNaipe="Seis";
				break;
			case "7":
				notacionNaipe="Siete";
				break;
			case "8":
				notacionNaipe="Ocho";
				break;
			case "9":
				notacionNaipe="Nueve";
				break;
				}
		}
		else{
			if(caracteres.length==3){
				notacionNaipe="Diez";
				paloNaipe=caracteres[2];
			}
		}
		switch(paloNaipe){
		case "D":
			paloNaipe="Diamantes";
			break;
		case "C":
			paloNaipe="Corazones";
			break;
		case "E":
			paloNaipe="Espadas";
			break;
		case "T":
			paloNaipe="Tréboles";
			break;
		}
		String valorCarta=notacionNaipe+" de "+paloNaipe;
		return valorCarta;
		
	}
	public static void main(String[] args){
		Condicional carta= new Condicional();
		String valor=JOptionPane.showInputDialog("Dame tu carta papu:");
		String naipe=carta.getNaipe(valor);
		System.out.println(naipe);
	}
		
	}


