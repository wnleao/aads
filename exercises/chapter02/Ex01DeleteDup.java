package exercises.chapter02;

import datastructures.LinkedList;
import datastructures.LinkedNode;
import java.util.Set;
import java.util.HashSet;

public class Ex01DeleteDup {

  public static void deleteDupsA(LinkedNode head) {
    if (head.getNext() == null) {
      return;
    }
    
    Set<Integer> buffer = new HashSet<>();
    buffer.add(head.getValue());

    LinkedNode curr = head;
    LinkedNode next = null;
    while ((next = curr.getNext()) != null) {
      if (buffer.contains(next.getValue())) {
        curr.setNext(next.getNext());
      } else {
        curr = next;
        buffer.add(curr.getValue());
      }
    }
  }

  public static void deleteDupsB(LinkedNode head) {
    if (head.getNext() == null) {
      return;
    }
    LinkedNode curr = head;
    while (curr != null) {
      int value = curr.getValue();
      LinkedNode prev = curr;
      LinkedNode next = null;
      while ((next = prev.getNext()) != null) {
        if (next.getValue() == value) {
          prev.setNext(next.getNext());
        } else {
          prev = next;
        }  
      }
      curr = curr.getNext();
    }
  }

  public static void deleteDupsC(LinkedList list) {
    if (list.isEmpty()) {
      return;
    }
    int firstValue = list.peek();
    do {
      int value = list.delete();
      while (list.delete(value)) {      
      }
      list.add(value);
    } while(list.peek() != firstValue);    
  }

  public static LinkedList deleteDupsD(LinkedList list) {
    LinkedList result = new LinkedList() {
      @Override
      public void add(int value) {
        if (head == null) {
          head = new Node(value, null);
          return;
        }
        if (head.getValue() == value) {
          return;
        }
        Node node = head;
        while (node.getNext() != null) {
          if (node.getNext().getValue() == value) {
            return;
          }
          node = node.getNext();
        }
        node.setNext(new Node(value, null));
      }
    };
    while (!list.isEmpty()) {
      result.add(list.delete());
    }
    return result;
  }

  private static LinkedNode createLinkedNode() {
    return new LinkedNode(1, 1, 2, 2, 2, 1, 1);
  }

  private static LinkedList createLinkedList() {
    LinkedList head = new LinkedList();
    head.add(1, 1, 2, 2, 2, 1, 1);
    return head;
  }

  public static void main(String[] args) {
    LinkedNode head = createLinkedNode();
    System.out.println(head);
    deleteDupsA(head);
    System.out.println(head);

    head = createLinkedNode();
    System.out.println(head);
    deleteDupsB(head);
    System.out.println(head);

    LinkedList list = createLinkedList();
    System.out.println(list);
    deleteDupsC(list);
    System.out.println(list);
  }

}