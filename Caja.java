package programacionorientada;

public class Caja extends Rectangulo {
	private double alto;
	public Caja(double largo, double ancho, double alto){
		super(largo,ancho);
		this.alto=alto;
	}
	public Caja(){
		this(3.0, 2.0, 5.0);
	}
	public double perimetro(){
		double perimetro=(this.largo*4.0)+(this.ancho*2.0)+(this.alto*8.0);
		return perimetro;
	}
	public double area(){
		double area=2*((super.area())+(this.alto*this.ancho)+(this.alto*this.largo));
		return area;
	}
	public void saluda(){
		System.out.println("Holis");
	}
	public double volumen(){
		return super.area()*this.alto;
	}
	public String toString(){
		return"Caja de largo"+this.largo+", ancho: "+this.ancho+" y alto"+this.alto;
	}
}
