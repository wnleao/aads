package exercises.chapter05;

import exercises.Exercise;

/**
  * 5.1 Insertion
  **/
public class C05E01 extends Exercise {

  public C05E01(String[] args) {
    super(args);
  } 

  public int getBit(int bits, int i) {
    return (bits & (1 << i)) != 0 ? 1 : 0;
  }

  public int updateBit(int n, int i, int v) {
    return (n & ~(1 << i)) | (v << i);
  }
  
  public int insert(int n, int m, int i, int j) {
    for (int k = 0; k <= j - i; k++) {
      n = updateBit(n, i + k, getBit(m, k));
    }
    return n;
  } 

  public void dumpInsert(int n, int m, int i, int j) {
    System.out.println("Input");
    System.out.println("N = " + Integer.toBinaryString(n));
    System.out.println("M = " + Integer.toBinaryString(m));
    System.out.println("i = " + i + ", j = " + j);
    System.out.println("Output");
    n = insert(n, m, i, j);
    System.out.println("N = " + Integer.toBinaryString(n));
  }
  
  public void compute(String[] args) {
    dumpInsert(1024, 19, 2, 6);
  }

}