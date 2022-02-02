package exercises.chapter02;

import datastructures.LinkedNode;

public class Ex04Partition {

  private static void partitionA(LinkedNode head, int value) {
    if (head == null || head.getNext() == null) {
      return;
    }
    LinkedNode p1 = head;
    while (p1 != null) {
      // look for node that is greater or equal than given value
      if (p1.getValue() >= value) {   
        // now let's look for node less than given value and swap
        LinkedNode p2 = p1.getNext();
        for (; p2 != null && p2.getValue() >= value; p2 = p2.getNext());
        if (p2 != null) {
          int tmp = p1.getValue();
          p1.setValue(p2.getValue());
          p2.setValue(tmp);
        }  
      }
      p1 = p1.getNext();
    }
  }

  private static LinkedNode partitionB(LinkedNode linkedNode, int value) {
    if (linkedNode == null || linkedNode.getNext() == null) {
      return linkedNode;
    }
    LinkedNode head = linkedNode;
    LinkedNode tail = head;
    LinkedNode curr = head;
    while (curr != null) {
      LinkedNode next = curr.getNext();
      if (curr.getValue() < value) {
        curr.setNext(head);
        head = curr;
      } else {
        tail.setNext(curr);
        tail = curr;
      }      
      curr = next;
    }
    tail.setNext(null);
    return head;
  }

  private static LinkedNode partitionC(LinkedNode head, int value) {
    if (head == null || head.getNext() == null) {
      return head;
    }
    LinkedNode prev = head;
    LinkedNode curr = null;
    while ((curr = prev.getNext()) != null) {
      if (curr.getValue() >= value) {
        prev = curr;        
      } else {
        prev.setNext(curr.getNext());
        curr.setNext(head);  
        head = curr;
      }
    }
    return head;
  }

  public static void partition(LinkedNode head, int x) {
    System.out.println("before = " + head + ", x = " + x);
    System.out.println("after  = " + partitionC(head, x));
  }

  public static void main(String[] args) {
    partition(new LinkedNode(3, 5, 8, 5, 10, 2, 1), 5);
    partition(new LinkedNode(3, 5, 8, 5, 10, 2, 1), 7);
    partition(new LinkedNode(5, 2, 8, 5, 10, 2, 1), 5);    
    partition(new LinkedNode(1, 1, 1), 2);
    partition(new LinkedNode(1, 1, 1), 0);
    partition(new LinkedNode(1, 2, 1, 2, 1, 2), 1);
    partition(new LinkedNode(2, 1, 0), 1);
    partition(new LinkedNode(2, 1, 0), 2);
    partition(new LinkedNode(2, 1, 0), 3);
  }
}