package programacionorientada;

public class MyException extends Exception {
	public MyException(String msg){
		super(msg);
	}
	public MyException(){
		super("Ocurrio un error de MyException");
	}
}
