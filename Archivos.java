package RepasoExamen2.MasGUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Archivos {
	private FileWriter fw;
	private PrintWriter bw;
	private FileReader fr;
	private BufferedReader br;
	public Archivos(){
		
	}
	public void escribirArchivo(String rutaArchivo,String[] datos){
		try {
			fw=new FileWriter(rutaArchivo+".txt");
			bw=new PrintWriter(fw);
			for(int i=0;i<datos.length;i++){
				bw.println(datos[i]);
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Error en la escritura de archivos");
			e.printStackTrace();
		}
	}
	public void abrirArchivo(String rutaArchivo){
		try{
			fr= new FileReader(rutaArchivo);
			br= new BufferedReader(fr);
			String linea;
			while((linea=br.readLine())!=null){
				System.out.println(linea);
			}
		}
		catch(IOException ex){
			System.out.println("No se pudo abrir el archivo");
		}
	}
}
