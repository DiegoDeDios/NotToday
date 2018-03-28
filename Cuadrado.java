package programacionorientada;

public class Cuadrado extends Rectangulo{
	public Cuadrado(double lado){
		super(lado,lado);
	}
	public Cuadrado(){
		this(3.0);
	}
	public String toString(){
		return "Cuadrado con lado"+this.largo;
	}
}
