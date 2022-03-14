package exercises.chapter05;

import exercises.Exercise;

/**
  * Get Least Significant Bit
  **/
public class LeastSignificantBit extends Exercise {

  public LeastSignificantBit(String[] args) {
    super(args);
  } 

  private void dumpBits(String label, int n) {
    String bits = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
    System.out.println(label + " = " + n);
    System.out.println("bits = " + bits);
  }

  public void dumpLSB(int n) {
    dumpBits(" n", n);
    dumpBits("-n", -n);
    int b = n & -n;
    dumpBits(" b", b);
  }
  
  public void compute(String[] args) {
    dumpLSB(17);
    dumpLSB(87);
    dumpLSB(199912);
  }

}