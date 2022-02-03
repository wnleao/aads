package exercises.chapter02;

import datastructures.LinkedNode;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class Ex06Palindrome {

  public static boolean isPalindromeA(LinkedNode list) {
    if (list == null || list.getNext() == null) {
      return true;
    }
    LinkedNode rev = reverse(list);
    LinkedNode h1 = list;
    LinkedNode h2 = rev;
    while(h1 != null) {
      if (h1.getValue() != h2.getValue()) {
        return false;
      }
      h1 = h1.getNext(); 
      h2 = h2.getNext();
    }
    return true;
  }

  private static LinkedNode reverse(LinkedNode list) {
    if (list == null) {
      return null;
    }
    LinkedNode head = new LinkedNode(list.getValue(), null);
    LinkedNode curr = list;
    while((curr = curr.getNext()) != null) {
      head = new LinkedNode(curr.getValue(), head);
    }
    return head;
  }

  public static boolean isPalindromeB(LinkedNode list) {
    if (list == null || list.getNext() == null) {
      return true;
    }
    Map<Integer, Integer> values = new HashMap<>();
    int pos = 0;
    for (LinkedNode r = list; r != null; r = r.getNext()) {
      values.put(pos++, r.getValue());      
    }
    for (int i = 0; i < pos/2; i++) {
      if (values.get(i) != values.get(pos-1-i)) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPalindromeC(LinkedNode list) {
    if (list == null || list.getNext() == null) {
      return true;
    }
    Stack<Integer> values = new Stack<>();
    for (LinkedNode r = list; r != null; r = r.getNext()) {
      values.push(r.getValue());      
    }
    int i = 0;
    for (LinkedNode r = list; i < values.size()/2; i++, r = r.getNext()) {
      if (r.getValue() != values.pop()) {
        return false;
      }
    }
    return true;
  }

  public static void printPalindrome(LinkedNode list) {
    System.out.println("list = " + list);
    System.out.println("is palindrome A = " + isPalindromeA(list));
    System.out.println("is palindrome B = " + isPalindromeB(list));
    System.out.println("is palindrome C = " + isPalindromeC(list));
  }

  public static void main(String[] args) {
    printPalindrome(new LinkedNode(1));
    printPalindrome(new LinkedNode(1,2,1));
    printPalindrome(new LinkedNode(1,1));
    printPalindrome(new LinkedNode(1,3,2,3,1));
    printPalindrome(new LinkedNode(1,3));
    printPalindrome(new LinkedNode(1,3,3));
    printPalindrome(new LinkedNode(1,3,3,1));
  }
  

}