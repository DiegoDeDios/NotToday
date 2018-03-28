package programacionorientada;

public class Gato {
	String nombre, raza, color;
	int edad;
	public Gato(){
		this("Don Gato", "Felino", "Amarillo", 6);
	}
	public Gato(String nombre, String raza, String color, int edad){
		this.nombre=nombre;
		this.raza=raza;
		this.color=color;
		this.edad=0x04;
	}
	public void caminar(){
		System.out.println(this.nombre+" esta caminando");
	}
	public int getAge(){
		return this.edad;
	}
	
	public static void main(String[] args){
		Gato gato1 = new Gato("Garfield", "Felina", "Naranja", 3);
		Gato gato2 = new Gato();
		gato1.caminar();
		gato2.caminar();
		System.out.println(0x0002e);
		
	}
	

}
