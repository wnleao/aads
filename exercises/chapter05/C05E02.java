package exercises.chapter05;

import exercises.Exercise;

/**
  * 5.2 Binary to String
  **/
public class C05E02 extends Exercise {

  public C05E02(String[] args) {
    super(args);
  } 

  public String toBinaryString(double n) {
    if (Double.compare(n, 0) == 0) {
      return "0";
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; n > 0 && i < 32; i++) {
      n = n * 2;
      if (n < 1) {
        sb.append('0');        
      } else {
        sb.append('1');        
        n -= 1;        
      }
    }
    System.out.println("32bits = " + sb.toString());
    return n > 0 ? "ERROR" : sb.toString();    
  }

  public void dumpToBinaryString(double n) {
    System.out.println("n = " + n);
    System.out.println("toBinaryString = " + toBinaryString(n));
  }
  
  public void compute(String[] args) {
    dumpToBinaryString(0.625);
    dumpToBinaryString(0.72);
    dumpToBinaryString(0.725);
  }

}