package lab6;

import lab6.Dummy;

public class Test6 {
  Dummy d;

  public Test6() {
    d = new Dummy();
  }

  Test6(Dummy d)
  {
    this.d = d;
  }

  Test6(int i)
  {
    d = new Dummy(i);
  }
  
  public Dummy getDummy() {
    return d;
  }
}
