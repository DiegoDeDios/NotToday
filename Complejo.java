//Autor: Diego Alonso Martínez de Dios A01228042
//Clase: Complejo
//Fecha: 26 de Enero del 2017
public class Complejo{
  private double real,
                imaginario;
  public Complejo(){

  }
  public Complejo(double real, double imaginario){
    establecer(real,imaginario);
  }
  public void establecer(double real, double imaginario){
    this.real=real; //inicializa la parte real del numero
    this.imaginario=imaginario; //inicializa la parte compleja del numero
  }
  public void imprimir(){
    if(this.imaginario>=0.0){
      System.out.println(this.real+"+"+this.imaginario+"i");
    }
    else{
      System.out.println(this.real+""+this.imaginario+"i");
    }
  }
  public void agregar(double real, double imaginario){
    this.real+=real;
    this.imaginario+=imaginario;
  }
  public void agregar(Complejo complejo){
    this.real+=complejo.real;
    this.imaginario+=complejo.imaginario;
  }
  public Complejo suma(Complejo complejo){
    double sumaReal=this.real+complejo.real;
    double sumaImaginaria=this.imaginario+complejo.imaginario;
    Complejo c = new Complejo(sumaReal, sumaImaginaria);
    return c;
  }
  public Complejo resta(Complejo complejo){
    double restaReal=this.real-complejo.real;
    double restaImaginaria=this.imaginario-complejo.imaginario;
    Complejo c = new Complejo(restaReal, restaImaginaria);
    return c;
  }
  public Complejo multiplicacion(Complejo complejo){ //Tomando en cuenta la estructura (a+b)(c+d)
    double AC=this.real*complejo.real; //a*c
    double AD=this.real*complejo.imaginario; //a*d
    double BC=this.imaginario*complejo.real; //b*c
    double BD=(-1)*(this.imaginario*complejo.imaginario); //b*d el producto de esto da i^2, que en notación compleja es equivalente a -1
    double productoReal=AC+BD;
    double productoImaginario=AD+BC;
    Complejo c = new Complejo(productoReal,productoImaginario);
    return c;
  }
  public Complejo multiplicacion(double Valor){
    double multiplicacionReal=this.real*Valor;
    double multiplicacionImaginario=this.imaginario*Valor;
    Complejo c = new Complejo(multiplicacionReal,multiplicacionImaginario);
    return c;
  }
  public Complejo conjugado(){
    double conjugadoReal=this.real;
    double conjugadoImaginario=(-1)*this.imaginario;
    Complejo c = new Complejo(conjugadoReal,conjugadoImaginario);
    return c;
  }
  public static void main(String[] args){
    Complejo a= new Complejo(-3.0,-5.0);
    Complejo b=new Complejo(4.0,-6.0);
    Complejo c= a.conjugado();
    c.imprimir();
    a.imprimir();
    b.imprimir();

  }
}
