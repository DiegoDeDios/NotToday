package programacionorientada;
import java.io.IOException;
import java.lang.Math;

public class Cuadratica {

	private double a,
					b,
					c;
	public Cuadratica(double a, double b, double c){
		setA(a);
		setB(b);
		setC(c);
	}
	public double setA(double a){
		this.a=a;
		return a;
	}
	public double setB(double b){
		this.b=b;
		return b;
	}
	public double setC(double c){
		this.c=c;
		return c;
	}
	public double getDiscriminante(){
		return Math.sqrt((Math.pow(this.b, 2))-(4*this.a*this.c));
	}
	public double solucion1(){
		if(Double.isNaN(getDiscriminante())){
		return (-this.b+this.getDiscriminante())/(2*this.a);
		}
		else{
			return 0.0;
		}
	}
	public double solucion2(){
		if(Double.isNaN(getDiscriminante())){
		return (-this.b-this.getDiscriminante())/(2*this.a);
		}
		else{
			return 0.0;
		}
	}

}
