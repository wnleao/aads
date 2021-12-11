package datastructures;

import java.util.NoSuchElementException;

public class LinkedList {

  protected Node head;

  public boolean isEmpty() {
    return head == null;
  }

  public void add(int value) {
    Node newNode = new Node(value, null);
    if (head == null) {
      head = newNode;
      return;
    }
    Node node = head;
    while (node.next != null) {
      node = node.next;
    }
    node.next = newNode;
  }
  
  public void add(int... values) {
    for (int value: values) {
      add(value);
    }
  }

  public int peek() {
    if (head == null) {
      throw new NoSuchElementException("lista vazia");
    }
    return head.value;
  }

  public int delete() {
    if (head == null) {
      throw new NoSuchElementException("lista vazia");
    }
    int value = head.value;
    head = head.next;
    return value;
  }

  public boolean delete(int value) {
    if (head == null) {
      return false;
    }
    if (head.value == value) {
      head = head.next;
      return true;    
    }
    Node node = head;
    while (node.next != null) {
      if (node.next.value == value) {
        node.next = node.next.next; 
        return true;
      }
      node = node.next;
    }
    return false;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    Node node = head;
    while (node != null) {
      if (sb.length() > 1) {
        sb.append(", ");  
      }
      sb.append(node.value);
      node = node.next;
    }
    sb.append("]");
    return sb.toString();
  }

  public static class Node {

    private int value;

    private Node next;

    public Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }

    public Node getNext() {
      return next;
    }

    public void setNext(Node next) {
      this.next = next;
    }

    public int getValue() {
      return value;
    }

  }

}