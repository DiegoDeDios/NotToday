package programacionorientada;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class VirusSimple {
	private FileReader lector;
	private BufferedReader bfLector;
	private String linea;
	private File archivo;
	public VirusSimple(){
		try {
			this.archivo = new File("/Users/DiegoAlonso/Documents/workspace/ProgramacionOrientadaObjetos/src/programacionorientada/Victima.java");
			this.lector= new FileReader(this.archivo);
			this.bfLector= new BufferedReader(this.lector);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void Inyectar(){
		
		try {
			PrintWriter inyector= new PrintWriter(this.archivo);
			while((linea=this.bfLector.readLine())!=null){
				if(linea.equals("	public static void main(String[] args){")){
					System.out.println(true);
				}
			}
			inyector.close();
			this.bfLector.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		VirusSimple virus = new VirusSimple();
		virus.Inyectar();

	}

}
