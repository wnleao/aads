package exercises.chapter01;

import java.util.Scanner;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

public class Ex02CheckPermutation {

  private static boolean checkPermutations(String w1, String w2) {
    if (w1.length() != w2.length()) {
       return false;
    }
    if (w1.equals(w2)) {
       return true;
    }
    return sort(w1).equals(sort(w2));
  }

  private static boolean checkPermutations2(String w1, String w2) {
    if (w1.length() != w2.length()) {
      return false;
    }
    if (w1.equals(w2)) {
      return true;
    }
    Map<Character, Integer> map = new HashMap<>();
    for (Character c : w1.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    for (Character c : w2.toCharArray()) {
      Integer counter = map.get(c);
      if (counter == null) {
        return false;
      }
      if (counter == 1) {
        map.remove(c);
      } else {
        map.put(c, counter-1);      
      }      
    }
    return map.isEmpty();
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
        System.out.println("Are they permutations of each other ? " + (checkPermutations(w1, w2) && checkPermutations2(w1,w2)));
      }
    }
  }
}