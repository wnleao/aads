package exercises.chapter01;

import java.lang.StringBuilder;
import java.util.Scanner;

public class Ex06StringCompression {

  private static String compress(String original) {
    if(original.length() <= 2) {
      return original;
    }
    StringBuilder sb = new StringBuilder();
    char c = original.charAt(0);
    int counter = 1;
    for (int i = 1; i < original.length(); i++) {
      if (original.charAt(i) == c) {
        counter++;
        continue;
      }
      sb.append(c);
      sb.append(counter);
      c = original.charAt(i);
      counter = 1;      
    }
    sb.append(c);
    sb.append(counter);
    return sb.length() < original.length() ? sb.toString() : original;    
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      while (true) {
        System.out.print("Input: ");
        String word = in.next();
        if(word.equals("q")) {
          break;
        }
        System.out.println("Output: " + compress(word));
      }
    }
  }
}