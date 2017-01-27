//Autor: Diego Alonso Martinez de Dios
//Nombre de la Clase: Libro
//Fecha: 18 de Enero del 2017
public class Libro{
  private String titulo;
  private String autor;
  private String editorial;
  private String isbn;

  public Libro(){ //Constructor Default
    titulo="Programación Orientada a Objetos for Dummies";
    autor="Diego Martínez";
    editorial="Tecditoriales";
    isbn="9783-161-48-4100";
  }
  public Libro(String title,String author,String edit,String isbnID){
    titulo=title;
    autor=author;
    editorial=edit;
    isbn=isbnID;
  }
  public void setTitle(String title){
    titulo=title;
  }
  public String getTitle(){
    return titulo;
  }
  public void setAuthor(String author){
    autor=author;
  }
  public String getAuthor(){
    return autor;
  }
  public void setEditorial(String edit){
    editorial=edit;
  }
  public String getEditorial(){
    return editorial;
  }
  public void setIsbn(String isbnID){
    isbn=isbnID;
  }
  public String getIsbn(){
    return isbn;
  }
  public static void main(String [] args){
    Libro miLibro=new Libro(); //Instancia de libro del Constructor Default
    System.out.println("Titulo: "+miLibro.getTitle());
    System.out.println("Editorial: "+miLibro.getEditorial());
    System.out.println("Autor: "+miLibro.getAuthor());
    System.out.println("ISBN: "+miLibro.getIsbn());
    System.out.println(); //Linea en blanco
    Libro tuLibro = new Libro("Un mundo Feliz","Aldous Huxley","deBolsillo","9087-564-3456-21"); //Instancia de libro con todos los atributos
    System.out.println("Titulo: "+tuLibro.getTitle());
    System.out.println("Editorial: "+tuLibro.getEditorial());
    System.out.println("Autor: "+tuLibro.getAuthor());
    System.out.println("ISBN: "+tuLibro.getIsbn());
    tuLibro.setTitle("Ensayo sobre la Ceguera"); //Uso de los sets de cada atributo de la clase
    tuLibro.setAuthor("Jose Saramago");
    tuLibro.setEditorial("Ocean");
    tuLibro.setIsbn("0098-982393-983-34");
    System.out.println();//Linea en blanco
    System.out.println("Mi nuevo titulo es : "+tuLibro.getTitle()); //Nuevos Atributos
    System.out.println("Mi nueva editorial es : "+tuLibro.getEditorial());
    System.out.println("Mi nuevo Autor es: "+tuLibro.getAuthor());
    System.out.println("Mi nueva ISBN es : "+tuLibro.getIsbn());


  }

}
