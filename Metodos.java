package programacionorientada;
import javax.swing.*;
import java.util.Scanner;

public class Metodos {

    public static void main(String[] args) {
        String mundo="Hola mundo";
        String [] caracteres=mundo.split("");
        for(int i=0;i<mundo.length();i++){
        	System.out.println(caracteres[i]);
        }
    }
}

