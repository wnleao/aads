package exercises.chapter02;

import datastructures.LinkedNode;

public class Ex03DeleteNode {

  private static void deleteMiddleNode(LinkedNode node, LinkedNode list) {
    if (node == null || node == list || node.getNext() == null) {
      // We should NOT remove the first nor the last node
      return;
    }
    node.setValue(node.getNext().getValue());
    node.setNext(node.getNext().getNext());    
  }

  private static void deleteExactMiddleNode(LinkedNode head) {
    if (head == null || head.getNext() == null || head.getNext().getNext() == null) {
      // We should NOT remove the first nor the last node
      return;
    }
    LinkedNode p1 = head;
    LinkedNode p2 = head.getNext();
    boolean advanceP1 = false;
    while ((p2 = p2.getNext()) != null) {
      if (advanceP1) {
        p1 = p1.getNext();
      }
      advanceP1 = !advanceP1;
    }
    p1.setNext(p1.getNext().getNext());
  }

  private static void deleteAllMiddleNodes(LinkedNode head) {
    if (head == null || head.getNext() == null || head.getNext().getNext() == null) {
      // We should NOT remove the first nor the last node
      return;
    }
    LinkedNode p1 = head;
    LinkedNode p2 = head.getNext();
    while (p2.getNext() != null) {
      p2 = p2.getNext();
    }
    p1.setNext(p2);
  }

  public static void main(String[] args) {
    LinkedNode head = new LinkedNode(1, 2, 3, 4, 5, 6, 7);
    
    System.out.println("before = " + head);
    deleteMiddleNode(head, head);
    System.out.println("after  = " + head);

    System.out.println("before = " + head);
    deleteMiddleNode(head.getNext().getNext(), head);
    System.out.println("after  = " + head);

    head = new LinkedNode(1, 2, 3, 4, 5, 6, 7);

    System.out.println(head);
    deleteExactMiddleNode(head);
    System.out.println(head);

    head = new LinkedNode(1, 2);
    
    System.out.println(head);
    deleteExactMiddleNode(head);
    System.out.println(head);

    head = new LinkedNode(1, 2, 3, 4);
    
    System.out.println(head);
    deleteExactMiddleNode(head);
    System.out.println(head);

    head = new LinkedNode(1, 2, 3, 4, 5);

    System.out.println(head);
    deleteAllMiddleNodes(head);
    System.out.println(head);
  }

}