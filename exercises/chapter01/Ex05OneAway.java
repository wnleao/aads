package exercises.chapter01;

import java.lang.Math;
import java.util.Map;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Ex05OneAway {

  private static boolean oneAwayA(String word1, String word2) {
    if (Math.abs(word1.length() - word2.length()) > 1) {
      return false;
    }
    String bigger = word1;
    String smaller = word2;
    if (word2.length() > word1.length()) {
      bigger = word2;
      smaller = word1;  
    }
    Map<Character, Integer> freqMap = new HashMap<>();
    for (char c : bigger.toCharArray()) {
      freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
    }
    for (char c : smaller.toCharArray()) {
      if (!freqMap.containsKey(c)) {
        continue;
      }
      Integer freq = freqMap.get(c) - 1;
      if (freq == 0) {
        freqMap.remove(c);
      } else {
        freqMap.put(c, freq);
      }      
    }
    Collection<Integer> freqValues = freqMap.values();
    return freqValues.size() == 1 && freqValues.iterator().next() == 1;
  } 

  private static boolean oneAwayB(String word1, String word2) {
    if (Math.abs(word1.length() - word2.length()) > 1) {
      return false;
    }
    Map<Character, Integer> freqMap = new HashMap<>();
    for (char c : word1.toCharArray()) {
      freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
    }
    for (char c : word2.toCharArray()) {
      Integer freq = freqMap.getOrDefault(c, 0) - 1;
      if (freq == 0) {
        freqMap.remove(c);
      } else {
        freqMap.put(c, freq);
      }      
    }
    Collection<Integer> freqValues = freqMap.values();
    if (freqValues.size() == 0 || freqValues.size() > 2) {
      return false;
    }
    for (Integer freq : freqValues) {
      if (Math.abs(freq) != 1) {
        return false;
      }
    }
    return true;
    
  }

  private static boolean oneRemove(String smaller, String bigger) {
    int i = 0;
    int diff = 0;
    while (i < smaller.length()) {
      if (smaller.charAt(i) == bigger.charAt(i+diff)) {
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

  private static boolean oneAwayC(String word1, String word2) {
    if (word1.length() == word2.length()) {
      return oneReplace(word1, word2);
    }
    if (word1.length() + 1 == word2.length()) {
      return oneRemove(word1, word2);
    }
    if (word1.length() - 1 == word2.length()) {
      return oneRemove(word2, word1);
    }
    return false;
  }

  private static boolean oneAwayD(String word1, String word2) {
    if (Math.abs(word1.length() - word2.length()) > 1) {
      return false;
    }
    if (word1.length() > word2.length()) {
      String tmp = word1;
      word1 = word2;
      word2 = tmp;
    }
    int i1 = 0;
    int i2 = 0;
    boolean foundDiff = false;
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
    return foundDiff;
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
        System.out.println("Output: " + oneAwayC(w1, w2));
        System.out.println("Output: " + oneAwayD(w1, w2));
      }
    }
  }
}