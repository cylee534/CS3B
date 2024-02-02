package lab6;

//Trying out the constructor bro
public class lab6 {
  public static void main(String[] args) {
    Dummy d = new Dummy(10);
    System.out.println("main: creating Dummy(address):" + d);
    test6(d);
    System.out.println("main:  d, " + d);
  }

  //Create a test6 object and let it fall out of scope
  public static void test6(Dummy dummy)
  {
    Test6 t = new Test6(dummy);
    
    System.out.println("test6(d):  T.dummy " + t.getDummy());
  }
}
