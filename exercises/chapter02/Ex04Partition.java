package exercises.chapter02;

import datastructures.LinkedNode;

public class Ex04Partition {

  private static void partitionA(LinkedNode head, int value) {
    if (head == null || head.getNext() == null) {
      return;
    }
    LinkedNode p1 = head;
    LinkedNode p2 = null;
    while (p1 != null) {
      // look for node that is greater or equal than given value
      if (p1.getValue() < value) {
        p1 = p1.getNext();
        continue;
      }    
      // now let's look for node less than given value and swap
      p2 = p1.getNext();
      while (p2 != null) {
        if (p2.getValue() >= value) {
          p2 = p2.getNext();
          continue;
        }
        // swap values if current one is less than given value
        int tmp = p1.getValue();
        p1.setValue(p2.getValue());
        p2.setValue(tmp);
        break;
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
    // 1 3 2 6 1
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

  public static void main(String[] args) {
    LinkedNode head = new LinkedNode(3, 5, 8, 5, 10, 2, 1);
    System.out.println("before: " + head);
    partitionA(head, 5);
    System.out.println("after:  " + head);

    head = new LinkedNode(1, 1, 1, 1);
    System.out.println("before: " + head);
    partitionA(head, 2);
    System.out.println("after:  " + head);

    System.out.println("before: " + head);
    partitionA(head, 0);
    System.out.println("after:  " + head);

    head = new LinkedNode(1, 2, 1, 2, 1, 2);
    System.out.println("before: " + head);
    partitionA(head, 1);
    System.out.println("after:  " + head);

    head = new LinkedNode(2, 1);
    System.out.println("before: " + head);
    partitionA(head, 1);
    System.out.println("after:  " + head);

    System.out.println("before: " + head);
    partitionA(head, 2);
    System.out.println("after:  " + head);

    head = new LinkedNode(3, 5, 8, 5, 10, 2, 1);
    System.out.println("before: " + head);
    head = partitionB(head, 5);
    System.out.println("after:  " + head);

    head = new LinkedNode(1, 1, 1, 1);
    System.out.println("before: " + head);
    head = partitionB(head, 2);
    System.out.println("after:  " + head);

    System.out.println("before: " + head);
    head = partitionB(head, 0);
    System.out.println("after:  " + head);

    head = new LinkedNode(1, 2, 1, 2, 1, 2);
    System.out.println("before: " + head);
    head = partitionB(head, 1);
    System.out.println("after:  " + head);

    head = new LinkedNode(2, 1);
    System.out.println("before: " + head);
    head = partitionB(head, 1);
    System.out.println("after:  " + head);

    System.out.println("before: " + head);
    head = partitionB(head, 2);
    System.out.println("after:  " + head);
  }

}