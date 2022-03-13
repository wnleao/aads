package exercises.chapter05;

import exercises.Exercise;

/**
  * 5.8 Draw line
  **/
public class C05E08 extends Exercise {

  public C05E08(String[] args) {
    super(args);
  } 

  public void drawLine(byte[] screen, int width, int x1, int x2, int y) {
    int base = y * (width / 8);
    int c1 = (x1 / 8) + base;
    int c2 = (x2 / 8) + base;
    int m1 = (1 << (8 - x1 % 8)) - 1;
    if (c1 == c2) {
      screen[c1] |= m1 & (-1 << (7 - x2 % 8));
    } else {
      screen[c1] |= m1;
      for (int i = c1 + 1; i < c2; screen[i++] |= -1);        
      screen[c2] |= -1 << (7 - x2 % 8);
    }
  }

  private void dump(byte[] screen, int width) {
    System.out.println("....");
    for (int i = 0; i < screen.length; i++) {
      if (i > 0 && (i * 8) % width == 0) {
        System.out.println("");
      }
      System.out.print(toBinaryString(screen[i]));  
    }
    System.out.println("");
  }

  private String toBinaryString(byte b) {
    return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
  }

  private void sleep(int ms) {
    try {
      Thread.sleep(ms);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
  public void compute(String[] args) {
    int width = 64;
    int height = 8;
    
    int i = 0;
    int j = 0;
    while (true) {
      byte[] screen = new byte[height*width/8];
      drawLine(screen, width, i, Math.min(i+16, width-1), j);
      dump(screen, width);
      i += 1;
      if (i == width) {
        i = 0;
        j+=1;
      }
      if (j == height) {
        j = 0;
      }
      sleep(500); 
    }    
  }

}