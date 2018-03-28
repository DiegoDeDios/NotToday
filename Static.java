package programacionorientada;

public class Static {
	private int a;
	private static int b;
	public String toString(){
		return "a= "+this.a+" b= "+this.b;
	}
	
	public static void main(String[] args) {
		Static es= new Static();
		Static es2= new Static();
		Static es3= new Static();
		Static es4= new Static();
		es.a=10;
		es.b=10;
		
		es2.a=20;
		es2.b=20;
		
		es3.a=30;
		es3.b=30;
		
		es4.a=40;
		es4.b=40;
		
		System.out.println(es);
		System.out.println(es2);
		System.out.println(es3);
		System.out.println(es4);

	}

}
