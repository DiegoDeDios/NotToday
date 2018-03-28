package programacionorientada;
/*Diego Martinez A01228042
 * Marijo Davila
 * Diego Gracia A01229716
 */
public class Pila <T> {
	private T[] datos;
	private int cantDatos;
	
	public Pila (){
		this.datos= (T[]) new Object[10];
		this.cantDatos=0;
	}
	public void push(T dato){
		this.datos[cantDatos]=dato;
		this.cantDatos++;
	}
	public T pop(){
		T ultimo=datos[cantDatos-1];
		datos[cantDatos-1]=null;
		cantDatos--;
		return ultimo;
	}
	public T top(){
		return this.datos[cantDatos-1];
	}
	public int size(){
		return this.cantDatos;
	}
	public String toString(){
		String objetos="";
		for(int i=0;i<this.datos.length;i++){
			if(this.datos[i]!=null){
			objetos+=this.datos[i]+"\n";
			}
		}
		return objetos;
	}
	public static void main (String[] args){
		Pila <Integer> integros = new Pila<Integer>();
		integros.push(5);
		integros.push(3);
		integros.push(8);
		integros.push(6);
		integros.push(4);
		System.out.println(integros.size()); //imprime 5
		integros.pop(); //debería eliminar el "4"
		//integros.top();
		System.out.println(integros.toString());
	}
	
}
