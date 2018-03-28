package programacionorientada;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CalculaNomina {

	public static void main(String[] args) {
		try {
			StringTokenizer st;
			BufferedReader br= new BufferedReader(new FileReader("horasTrabajadas.txt"));
			String linea=br.readLine();
			String nombre,
					apellido;
			int hrs;
			double tabulador;
			
			PrintWriter pw= new PrintWriter(new FileWriter("nomina.csv"));
			while((linea=br.readLine())!=null){
				st=new StringTokenizer(linea);
				nombre=st.nextToken();
				apellido=st.nextToken();
				hrs=Integer.parseInt(st.nextToken());
				tabulador=Double.parseDouble(st.nextToken());
				
				pw.println(nombre+" "+apellido+","+(hrs*tabulador));
			}
			pw.close();
			br.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("Ocurrio un error"+e);
		}
		catch(IOException ex){
			System.out.println("Error"+ex);
		}

	}

}
