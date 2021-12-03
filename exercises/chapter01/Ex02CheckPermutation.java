package exercises.chapter01;

import java.util.Scanner;
import java.util.Arrays;

public class Ex02CheckPermutation {

  private static boolean checkPermutations(String w1, String w2) {
    if (w1.length() != w2.length()) {
       return false;
    }
    return sort(w1).equals(sort(w2));
  }

  private static String sort(String string) {
    char[] chars = string.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      while (true) {
        System.out.print("Enter first word (q to quit): ");
        String w1 = in.next().toLowerCase();
        if(w1.equals("q")) {
          break;
        }
        System.out.print("Enter second word: ");
        String w2 = in.next().toLowerCase();
        System.out.println(w1 + " and " + w2);
        System.out.println("Are they permutations of each other ? " + checkPermutations(w1, w2));
      }
    }
  }
}