package exercises.chapter02;

import datastructures.LinkedList;
import datastructures.Node;
import datastructures.LinkedNode;
import java.util.Set;
import java.util.HashSet;

public class Ex01RemoveDup {

  public static void removeDupsA(LinkedNode head) {
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

  public static void removeDupsB(LinkedNode head) {
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

  public static LinkedNode removeDupsC(LinkedNode head) {
    if (head == null) {
      return null;
    }
    LinkedNode result = new LinkedNode(head.getValue());
    LinkedNode last = result;
    LinkedNode source = head;
    while ((source = source.getNext()) != null) {
      LinkedNode tmp = result;
      while (tmp.getValue() != source.getValue() && (tmp = tmp.getNext()) != null);
      if (tmp == null) {
        last = last.insert(source.getValue());        
      } 
    }
    return result;
  }

  public static void removeDupsD(LinkedList<Integer> list) {
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

  public static LinkedList<Integer> removeDupsE(LinkedList<Integer> list) {
    LinkedList<Integer> result = new LinkedList<>() {
      @Override
      public void add(Integer value) {
        if (head == null) {
          head = new Node<>(value, null);
          return;
        }
        if (head.getValue() == value) {
          return;
        }
        Node<Integer> node = head;
        while (node.getNext() != null) {
          if (node.getNext().getValue() == value) {
            return;
          }
          node = node.getNext();
        }
        node.setNext(new Node<>(value, null));
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

  private static LinkedList<Integer> createLinkedList() {
    LinkedList<Integer> head = new LinkedList<>();
    head.add(1, 1, 2, 2, 2, 1, 1);
    return head;
  }

  public static void main(String[] args) {
    LinkedNode head = new LinkedNode(1, 1, 2, 2, 2, 1, 1);
    System.out.println("original = " + head);
    System.out.println("result   = " + removeDupsC(head));

    head = new LinkedNode(1, 1, 1, 1, 1, 1, 1);
    System.out.println("original = " + head);
    System.out.println("result   = " + removeDupsC(head));

    head = new LinkedNode(1, 2, 1, 2, 1, 2, 1, 3);
    System.out.println("original = " + head);
    System.out.println("result   = " + removeDupsC(head));

    head = new LinkedNode(1, 2, 3, 4, 5, 6, 7);
    System.out.println("original = " + head);
    System.out.println("result   = " + removeDupsC(head));

    head = new LinkedNode(1);
    System.out.println("original = " + head);
    System.out.println("result   = " + removeDupsC(head));
  }

}