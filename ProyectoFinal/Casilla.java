package proyectoFn;
/*50% Diego Alonso Martínez de Dios 
 *50% Diego Issac Cardenas 
 */
//Mi clase casilla se encarga de manejar el valor que tendré en cada Casilla de mi 2024, y tiene métodos para setear o  para volver valores, si se encuentra lleno o no
//y para devolver un String

public class Casilla {
	
	private int valor;
	
	private boolean lleno;
	
	public Casilla(){
		this.valor=0;
		this.lleno=false;
	}
	
	public boolean lleno(){
		if(this.valor!=0){
			this.lleno=true;
		}
		else if(this.valor==0){
			this.lleno=false;
		}
		return this.lleno;
	}
	
	
	public String getValor(){
		String v="";
		if(this.valor==0){
			v="";
		}
		else{
			v=this.valor+"";
		}
		
		return v;
	}
	
	public int getValorNum(){
		return this.valor;
	}
	public void setValor(int value){
	
			this.valor=value;

	}
}

