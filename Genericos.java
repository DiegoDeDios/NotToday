package programacionorientada;

import java.util.ArrayList;

public class Genericos  {
	public Genericos (){
		
	}
	public void imprimirArreglo(ArrayList <?> arraylist){
		for(int i=0;i<arraylist.size();i++){
		System.out.println(arraylist.get(i));
		}
		
		}
}
