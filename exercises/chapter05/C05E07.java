package exercises.chapter05;

import exercises.Exercise;

/**
  * 5.7 Pairwise swap
  **/
public class C05E07 extends Exercise {

  public C05E07(String[] args) {
    super(args);
  } 

  public int pairwiseSwap(int n) {
    // 1431655765 = 01010101010101010101010101010101
    int r = (n ^ (n >>> 1)) & 1431655765;
    return n ^ (r | r << 1);
  }

  private void dumpPairwiseSwap(int n) {
    dumpBits("n", n);
    dumpBits("r", pairwiseSwap(n));
  }

  private void dumpBits(String label, int n) {
    System.out.println(label + " = " + n + ", bits = " + Integer.toBinaryString(n));
  }

  public void compute(String[] args) {
    dumpPairwiseSwap(44739242);
    dumpPairwiseSwap(1431655765);
    dumpPairwiseSwap(5);
  }

}