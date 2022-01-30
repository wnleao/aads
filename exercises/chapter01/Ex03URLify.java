package exercises.chapter01;

import java.util.Scanner;

public class Ex03URLify {

  private static String replaceSpaces(String original, int length) {
    char[] chars = original.toCharArray();
    for(int i = 0; length > 0; i++, length--) {
      if (chars[i] != ' ') {
        continue;
      }
      System.arraycopy(chars, i+1, chars, i+3, length-1);
      chars[i] = '%';
      chars[i+1] = '2';
      chars[i+2] = '0';
      i += 2;      
    }
    return new String(chars);
  }

  private static String replaceSpaces2(String original, int realLength) {
    char[] chars = original.toCharArray();
    for(int i = realLength-1, j = chars.length-1; i >= 0; i--) {
      if (chars[i] == ' ') {
        chars[j--] = '0';
        chars[j--] = '2';
        chars[j--] = '%';
      } else {
        chars[j--] = chars[i];
      }
    }
    return new String(chars);
  }

  private static String replaceSpaces3(String original, int realLength) {
    char[] chars = original.toCharArray();
    for(int i = realLength-1, j = chars.length-1; i >= 0; i--, j--) {
      chars[j] = chars[i];
      if (chars[j] == ' ') {
        chars[j--] = '0';
        chars[j--] = '2';
        chars[j] = '%';
      }
    }
    return new String(chars);
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      while (true) {
         System.out.print("Input: ");
         String input = in.nextLine();
         System.out.println(input);
         if (input.equals("q")) {
           break;
         }
         String[] inputSplit = input.split(",");
         String phrase = inputSplit[0];
         int length = Integer.parseInt(inputSplit[1].trim());
         System.out.println("Output1: " + replaceSpaces(phrase, length));
         System.out.println("Output2: " + replaceSpaces2(phrase, length));
         System.out.println("Output3: " + replaceSpaces3(phrase, length));
      }
      
    }
  }

}