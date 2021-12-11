package exercises.chapter02;

import datastructures.LinkedNode;

import java.util.Map;
import java.util.HashMap;

public class Ex02KthToLast {

  private static LinkedNode findKthToLastA(LinkedNode head, int k) {
    if (head == null || k < 0) {
      return null;
    }
    LinkedNode n1 = head;
    while (k > 0) {
      if (n1 == null) {
        return null;
      }
      n1 = n1.getNext();
      k--;
    }
    LinkedNode n2 = head;
    while (n1 != null) {
      n1 = n1.getNext();
      n2 = n2.getNext();
    }
    return n2;
  }

  private static class NodeTarget {
    public int index;
  }

  private static LinkedNode findKthRec(LinkedNode curr, int k, NodeTarget target) {
    if (curr == null) {
      return null;
    }
    LinkedNode n = findKthRec(curr.getNext(), k, target);
    target.index++;
    if (target.index == k) {
      return curr;
    }
    return n;
  }
  
  private static LinkedNode findKthToLastB(LinkedNode curr, int k) {
    NodeTarget target = new NodeTarget();
    return findKthRec(curr, k, target);
  }

  private static LinkedNode findKthToLastC(LinkedNode head, int k) {
    if (head == null || k < 0) {
      return null;
    }
    Map<Integer, LinkedNode> buffer = new HashMap<>();
    LinkedNode curr = head;
    int counter = 0;
    while (curr != null) {
      buffer.put(counter++, curr);
      curr = curr.getNext();
    }
    return buffer.get(buffer.size() - k);    
  }

  public static void main(String[] args) {
    LinkedNode head = new LinkedNode(1, 2, 3, 4, 5, 6, 7);

    System.out.println("A");
    LinkedNode kth = findKthToLastA(head, 1);
    System.out.println(kth.getValue());

    kth = findKthToLastA(head, 6);
    System.out.println(kth.getValue());

    kth = findKthToLastA(head, 8);
    System.out.println(kth);

    System.out.println("B");
    kth = findKthToLastB(head, 1);
    System.out.println(kth.getValue());

    kth = findKthToLastB(head, 6);
    System.out.println(kth.getValue());

    kth = findKthToLastB(head, 8);
    System.out.println(kth);

    System.out.println("C");
    kth = findKthToLastC(head, 1);
    System.out.println(kth.getValue());

    kth = findKthToLastC(head, 6);
    System.out.println(kth.getValue());

    kth = findKthToLastC(head, 8);
    System.out.println(kth);
  }
  
}