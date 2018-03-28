package programacionorientada;

import java.util.ArrayList;
import javafx.scene.media.Media;

public class Persona <T> { //Metodos y clases genericas
	ArrayList<T> arreglo;
	public Persona(){
		arreglo= new ArrayList<T>();
	}
	public void agregarGente(T cosa){
		this.arreglo.add(cosa);
	}
	public T getElemento(){
		return this.arreglo.get(0);
	}
	public static void main(String[] args) {
		Persona <String> gente= new Persona<String>();
		gente.agregarGente("Diego");
		gente.agregarGente("Paco");
		System.out.println(gente.getElemento());
	}

}
