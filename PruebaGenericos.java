package programacionorientada;

import java.util.ArrayList;

public class PruebaGenericos {
	public static void main(String [] args){
		Genericos g = new Genericos();
		ArrayList<String> arrayStrings= new ArrayList();
		arrayStrings.add("Hola");
		arrayStrings.add("soy");
		arrayStrings.add("un");
		arrayStrings.add("Array de Strings");
		ArrayList<Integer> a2= new ArrayList();
		a2.add(2);
		a2.add(3);
		a2.add(4);
		a2.add(5);
		ArrayList<Double> a3 = new ArrayList();
		a3.add(1.0);
		a3.add(2.0);
		a3.add(3.0);
		a3.add(4.0);
		g.imprimirArreglo(arrayStrings);
		g.imprimirArreglo(a2);
	}
}
