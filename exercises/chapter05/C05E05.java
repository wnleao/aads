package exercises.chapter05;

import exercises.Exercise;

/**
  * 5.5 Debugger
  **/
public class C05E05 extends Exercise {

  public C05E05(String[] args) {
    super(args);
  } 

  public boolean isZeroOrPowerOf2(int n) {
    return (n & (n-1)) == 0;
  }

  public void dumpCheckZeroOrPowerOf2(int n) {
    System.out.println("n = " + n + ", isPowerOf2 ? " + isZeroOrPowerOf2(n));
  }
  
  public void compute(String[] args) {
    for (int i = 0; i <= 16; i++) {
      dumpCheckZeroOrPowerOf2(i);
    }
  }

}