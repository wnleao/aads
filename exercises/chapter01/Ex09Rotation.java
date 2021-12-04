package exercises.chapter01;

import java.util.Scanner;

public class Ex09Rotation {

  private static boolean isSubstring(String s1, String s2) {
    return s1.contains(s2);
  }

  private static boolean isRotationA(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    if (s1.equals(s2)) {
      return true;
    }
    return isSubstring(s1+s1, s2);
  }
  private static boolean isRotationB(char[] s1, char[] s2) {
    if (s1.length != s2.length) {
      return false;
    }
    if (s1.length == 0) {
      return true;
    }
    int i = 0;
    int j = 0;
    while (j+i < s2.length) {
      if (s1[i] == s2[j+i]) {
        i++;
        continue;
      }
      i = 0;
      j++;
    }
    if (s1.length - i != j) {
      return false;
    }
    for (int k = 0; k < j; k++) {
      if (s1[i+k] != s2[k]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      while (true) {
        System.out.print("s1: ");
        String s1 = in.nextLine(); // "bottletater"
        System.out.print("s2: ");
        String s2 = in.nextLine(); // "etaterbottl"
        System.out.println("s1, s2 = '" + s1 + "', '" + s2 + "'");
        System.out.println("OutputA: " + isRotationA(s1, s2));
        System.out.println("OutputB: " + isRotationB(s1.toCharArray(), s2.toCharArray()));
      } 
    } 
  }

}