package programacionorientada;

public class Rectangulo implements Figura {
	protected double largo;
	protected double ancho;
	public Rectangulo(double largo, double ancho){
		this.largo=largo;
		this.ancho=ancho;
	}
	public Rectangulo(){
		this(1.0,2.0);
	}
	public double perimetro(){
		return (2.0*this.largo)+(2.0*this.ancho);
	}
	public double area(){
		return this.largo*this.ancho;
	}
	@Override
	public double volumen() {
		// TODO Auto-generated method stub
		return 0.0;
	}
	public String toString(){
		return "Rectangulo con largo; "+ this.largo+" y ancho"+this.ancho;
	}
	public static void main(String[] args) {
		Figura[] figuras={new Rectangulo(5.0, 3.0), new Cuadrado(5.0),new Caja()};
		for(int i=0;i<figuras.length;i++){
			System.out.println(figuras[i]);
			System.out.println("El perimetro es: "+figuras[i].perimetro());
			System.out.println("El area es "+figuras[i].area());
			if(figuras[i] instanceof Caja){
				((Caja)figuras[i]).saluda();
			}
			System.out.println("El volumen es "+figuras[i].volumen()+"\n");
		}
}
	
}
