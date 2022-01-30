package exercises.chapter01;

import java.lang.Math;
import java.util.Scanner;

public class Ex05OneAway {

  private static boolean oneAwayA(String word1, String word2) {
    if (Math.abs(word1.length() - word2.length()) > 1) {
      return false;
    }
    if (word1.equals(word2)) {
      return true;
    }
    if (word1.length() > word2.length()) {
      String tmp = word1;
      word1 = word2;
      word2 = tmp;
    }
    int i1 = 0;
    int i2 = 0;
    boolean foundDiff = false;
    System.out.println("word1 = " + word1);
    System.out.println("word2 = " + word2);
    while (i1 < word1.length() && i2 < word2.length()) {
      if (word1.charAt(i1) == word2.charAt(i2)) {
        i1++;
        i2++;
        continue;
      }
      if (foundDiff) {
        return false;
      }
      foundDiff = true;
      if (word1.length() == word2.length()) {
        i1++;
      }
      i2++;
    }
    return foundDiff || i2 == word2.length()-1;
  }

  private static boolean oneRemove(String word1, String word2) {
    if (word1.length() > word2.length()) {
      String tmp = word1;
      word1 = word2;
      word2 = tmp;      
    }
    int i = 0;
    int diff = 0;
    while (i < word1.length()) {
      if (word1.charAt(i) == word2.charAt(i+diff)) {
        i++;
        continue;
      }
      if (diff == 1) {
        return false;
      } 
      diff = 1;      
    }
    return true;
  }

  private static boolean oneReplace(String word1, String word2) {
    boolean hasDiffChar = false;
    for (int i = 0; i < word1.length(); i++) {
      if (word1.charAt(i) != word2.charAt(i)) {
        if (hasDiffChar) {
          return false;
        }
        hasDiffChar = true;
      }
    }
    return hasDiffChar;
  }

  private static boolean oneAwayB(String word1, String word2) {
    if (word1.length() == word2.length()) {
      return word1.equals(word2) || oneReplace(word1, word2);
    }
    if (Math.abs(word1.length() - word2.length()) == 1) {
      return oneRemove(word1, word2);      
    }
    return false;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      while(true) {
        System.out.print("Input: ");
        String input = in.nextLine();
        if (input.equals("q")) {
          break;
        }
        String[] words = input.split(",");
        String w1 = words[0].trim();
        String w2 = words.length == 1 ? "" : words[1].trim();
        System.out.println("Output: " + oneAwayA(w1, w2));
        System.out.println("Output: " + oneAwayB(w1, w2));        
      }
    }
  }
}