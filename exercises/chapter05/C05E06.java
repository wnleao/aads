package exercises.chapter05;

import exercises.Exercise;

/**
  * 5.6 Conversion
  **/
public class C05E06 extends Exercise {

  public C05E06(String[] args) {
    super(args);
  } 
  
  public int conversion(int a, int b) {
    dumpBits("a  ", a);
    dumpBits("b  ", b);
    int xor = a ^ b;
    dumpBits("xor", xor);
    int count = 0;
    while (xor != 0) {
      count += xor & 1;
      xor >>>= 1;
    }
    System.out.println("n   = " + count);
    return count;
  }

  private void dumpBits(String label, int n) {
    System.out.println(label + " = " + n + ", bits = " + Integer.toBinaryString(n));
  }

  public void compute(String[] args) {
    conversion(29, 15);
    conversion(15, 29);
    conversion(29, -15);
    conversion(-29, 15);
    conversion(1, -2);
  }

}