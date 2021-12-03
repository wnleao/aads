package exercises.chapter01;

import java.util.Scanner;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

public class Ex04PalindromePermutation {

  private static boolean checkPalindromeA(String string) {
    String stringClean = string.replaceAll(" ", "");
    Map<Character, Integer> freqMap = new HashMap<>();
    for(char c : stringClean.toCharArray()) {
      freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
    }
    // Only one letter should occur an odd number of times
    int oddLetterCounter = 0;
    for (Integer freq : freqMap.values()) {
      if (freq % 2 != 0) {
        oddLetterCounter++;
      }
      if (oddLetterCounter > 1) {
        return false;
      }
    }
    return true;
  }

  private static boolean checkPalindromeB(String string) {
    char[] chars = string.replaceAll(" ", "").toCharArray();
    Arrays.sort(chars);
    char oldChar = '\0';
    int oddCounter = 0;
    boolean even = true;
    for (char c : chars) {
      if (oldChar == c) {
        even = !even;    
      } else {
        if (!even) {
          oddCounter++;
        }
        if (oddCounter > 1) {
          return false;
        }
        oldChar = c;
        even = false;
      }
    }
    return true;
  }

  private static boolean checkPalindromeC(String string) {
    Map<Character, Integer> freqMap = new HashMap<>();
    int oddCounter = 0;
    for(char c : string.toCharArray()) {
      if (c == ' ') {
        continue;
      }
      Integer newFreq = freqMap.getOrDefault(c, 0) + 1;
      if (newFreq % 2 == 0) {
        oddCounter--;
      } else {
        oddCounter++;
      }
      freqMap.put(c, newFreq);
    }
    return oddCounter <= 1;
  }

  private static boolean checkPalindromeD(String string) {
    int bitVector = 0;
    for(char c : string.toCharArray()) {
      if (c > 'z' || c < 'a') {
        continue;
      }
      int index = c - 'a'; 
      int mask = 1 << index;
      if ((bitVector & mask) == 0) {
        bitVector |= mask;
      } else {
        bitVector &= ~mask;
      }
    }
    return (bitVector & (bitVector-1)) == 0;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      while (true) {
        System.out.print("Input: ");
        String string = in.nextLine();
        if (string.equals("q")) {
          break;
        }
        System.out.println("OutputA: " + checkPalindromeA(string));
        System.out.println("OutputB: " + checkPalindromeB(string));
        System.out.println("OutputC: " + checkPalindromeC(string));
        System.out.println("OutputD: " + checkPalindromeD(string));
      }      
    }
  }
}