public class UsaTermometro extends Termometro{
  public static void main(String [] args){
    Termometro miTermometro= new Termometro();
    System.out.println("La temperatura es "+miTermometro.getTemp());
    
    Termometro monterrey=new Termometro(26);
    miTermometro.setTemp(19);
    System.out.println("La temperatura es "+miTermometro.getTemp());
    System.out.println("La temperatura en monterrey es "+monterrey.getTemp());

  }
}
