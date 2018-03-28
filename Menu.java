package programacionorientada;

public class Menu {

	public static void main(String[] args) { 
		//Polimorfismo: Propiedad de clases hijas de tomar el tipo de dato de la clase madre
		Comida [] menu= {new Cereal(), new Carne(), new Durazno()};	
		/*menu[0]=new Cereal();
		menu[1]= new Carne();
		menu[2]= new Durazno();*/
		for(int i=0;i<menu.length;i++){
			menu[i].comer();
		}

	}

}
