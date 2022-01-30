package exercises.chapter01;
import java.util.Scanner;

public class Ex01UniqueCharacters {

  private static boolean allUniqueChars(String word) {
    int bitmask = 0;
    for (char c : word.toCharArray()) {
      int bit = 1 << (c - 'a');
      if ((bitmask & bit) != 0) {
        System.out.println(c + " - we already have this one!");
        return false;
      }
      bitmask |= bit;
      System.out.println(c + " - " + Integer.toBinaryString(bitmask));
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println("Chapter01 Ex01");
    try (Scanner input = new Scanner(System.in)) {
      while(true) {
        System.out.print("Enter a word (q to quit): ");
        String word = input.next().toLowerCase();
        if (word.equals("q")) {
          break;
        }
        System.out.println("Are all characters unique? " + allUniqueChars(word));
      }
    }
  }
}