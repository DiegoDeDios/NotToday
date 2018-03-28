package programacionorientada;

public class EjemploException {
	public void metodoA() throws MyException{
		this.metodob();
	}
	public void metodob() throws MyException{
		this.metodoC();
	}
	public void metodoC() throws MyException{
		this.metodod();
	}
	public void metodod() throws MyException{
		
		throw new MyException("Hubo un pedo y ya no jaló esta madre");
	}
	public static void main(String [] args){
		try{
		EjemploException ejEx= new EjemploException();
		ejEx.metodoA();
		}
		catch(MyException ex){
			System.out.println("Ocurrio un pedo pero no estuvo feo");
		}
		
	}

}
