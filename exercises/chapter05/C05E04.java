package exercises.chapter05;

import exercises.Exercise;

/**
  * 5.4 Next Number
  **/
public class C05E04 extends Exercise {

  public C05E04(String[] args) {
    super(args);
  } 

  public int getBit(int n, int i) {
    return (n & (1 << i)) == 0 ? 0 : 1;
  }

  public int getNextSmallest(int n) {
    int res = n;
    int ones = 0;
    int i = 1;
    for (; i < 32; i++) {
      int prev = getBit(n, i-1);
      if (getBit(n, i) == 0 && prev == 1) {
        break;
      }
      ones += prev;
    }
    
    res |= 1 << i;
    res &= ~(1 << i-1);                
        
    res &= -1 << i;
    res |= ~(-1 << ones);
    
    return res < 0 ? n : res;
  }

  public int getNextLargest(int n) {
    int res = n;
    int ones = 0;
    int i = 1;
    for (; i < 32; i++) {
      int prev = getBit(n, i-1);
      if (getBit(n, i) == 1 && prev == 0) {
        break;
      }
      ones += prev;
    }

    res |= 1 << (i-1);
    res &= ~(1 << i);                

    int mask = -1 << i-1;
    res &= mask; 
    res |= (-1 << (i-1-ones)) & ~mask;
    
    return res < 0 ? n : res;
  }

  public void nextNumber(int n) {
    System.out.println("input = " + n + ", bits = " + Integer.toBinaryString(n));
    if (n <= 0) {
      throw new IllegalArgumentException("given number must be > 0!");
    }
    int nextSmallest = getNextSmallest(n);    
    System.out.println("next smallest = " + nextSmallest + 
 ", bits = " + Integer.toBinaryString(nextSmallest));
    int nextLargest = getNextLargest(n);
    System.out.println("next largest  = " + nextLargest + 
 ", bits = " + Integer.toBinaryString(nextLargest));
  }
  
  public void compute(String[] args) {
    nextNumber(1);
    nextNumber(3);
    nextNumber(5);
    nextNumber(42);
    nextNumber(51);
    nextNumber(177761);
    nextNumber(-1 & ~(1 << 31));
    nextNumber((-1 << 1) & ~(1 << 31));
  }

}