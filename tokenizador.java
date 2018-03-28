package programacionorientada;

import java.util.StringTokenizer;

public class tokenizador {

	public static void main(String[] args) {
		StringTokenizer st;
		String frase="Diego Alonso 18 ISC ITESM";
		st=new StringTokenizer(frase);
		String nombre=st.nextToken()+st.nextToken();
		String edad=st.nextToken();
		String Carrera= st.nextToken();
		String escuela=st.nextToken();
		System.out.println(nombre+" "+edad+" "+Carrera+" "+escuela);
		

	}

}
