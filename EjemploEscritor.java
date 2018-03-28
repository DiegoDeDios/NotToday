package programacionorientada;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EjemploEscritor {

	public static void main(String[] args) {
		try {
			FileWriter fr = new FileWriter("nuevo.txt");
			PrintWriter pw = new PrintWriter(fr);
			pw.println("Este es un nuevo archivo de texto");
			pw.println("Otra linea");
			pw.flush();
			pw.println("Sale bai");
			pw.close();
			System.out.println("Ya bye");
		} catch (IOException ex) {
			System.out.println("Ya valio");
		}

	}

}
