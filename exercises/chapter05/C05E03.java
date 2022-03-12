package exercises.chapter05;

import java.util.ArrayList;

import exercises.Exercise;

/**
  * 5.3 Flip Bit to Win
  **/
public class C05E03 extends Exercise {

  public C05E03(String[] args) {
    super(args);
  } 

  public int getBit(int n, int i) {
    return (n & (1 << i)) == 0 ? 0 : 1;
  }
  
  public int flipToWin(int n) {
    int max = 1;
    int prev = 0;
    int curr = 0;
    for (int i = 0; i < 32; i++) {
      int bit = getBit(n, i);
      if (bit == 1) {
        curr++;
        prev++;        
      } else {
        if (curr > max) {
          max = curr;
        }
        curr = prev+1;
        prev = 0;        
      }
    }
    return curr > max ? curr : max;      
  }
  
  public int flipToWin2(int n) {
    ArrayList<Integer> sums = new ArrayList<>(); 
    int sum = 0;
    for (int i = 0; i < 32; i++) {
      int bit = getBit(n, i);
      if (bit == 1) {
        sum++;
      } else {
        sums.add(sum);
        sum = 0;
      }
    }
    sums.add(sum);
    
    int len = sums.get(0) + 1;
    for (int i = 1; i < sums.size(); i++) {
      int newLen = sums.get(i-1) + sums.get(i) + 1;
      if (newLen > len) {
        len = newLen;
      }
    }
    return Math.min(32, len);    
  }

  public void dumpFlipToWin(int n) {
    System.out.println("input  = " + n + ", bits = " + Integer.toBinaryString(n));
    System.out.println("output = " + flipToWin(n));
    System.out.println("output = " + flipToWin2(n));
  }
  
  public void compute(String[] args) {
    dumpFlipToWin(0);
    dumpFlipToWin(1666);
    dumpFlipToWin(16661);
    dumpFlipToWin(766);
    dumpFlipToWin(667);
    dumpFlipToWin(-1);
    dumpFlipToWin(-2147483647);
    dumpFlipToWin(51);
  }

}