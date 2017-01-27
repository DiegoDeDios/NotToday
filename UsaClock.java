public class UsaClock{
  public static void main(String[] args){
    Clock gda =new Clock();
    Clock tij=new Clock(7,5,10);
    Clock lon=new Clock(-10,989890,997897);
    gda.printTime();
    tij.printTime();
    lon.printTime();
    gda.setTime(9,42,30);
    gda.printTime();
    tij.printTime();
    lon.printTime();
  }
}
