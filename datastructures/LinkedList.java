package datastructures;

import java.util.NoSuchElementException;

public class LinkedList<T> {

  protected Node<T> head;

  public boolean isEmpty() {
    return head == null;
  }

  public void add(T value) {
    Node<T> newNode = new Node<>(value, null);
    if (head == null) {
      head = newNode;
      return;
    }
    Node<T> node = head;
    while (node.getNext() != null) {
      node = node.getNext();
    }
    node.setNext(newNode);
  }
  
  public void add(int... values) {
    for (int value: values) {
      add(value);
    }
  }

  public T peek() {
    if (head == null) {
      throw new NoSuchElementException("empty list");
    }
    return head.getValue();
  }

  public T delete() {
    if (head == null) {
      throw new NoSuchElementException("empty list");
    }
    T value = head.getValue();
    head = head.getNext();
    return value;
  }

  public boolean delete(T value) {
    if (head == null) {
      return false;
    }
    if (head.getValue() == value) {
      head = head.getNext();
      return true;    
    }
    Node<T> node = head;
    while (node.getNext() != null) {
      if (node.getNext().getValue() == value) {
        node.setNext(node.getNext().getNext()); 
        return true;
      }
      node = node.getNext();
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
      sb.append(node.getValue());
      node = node.getNext();
    }
    sb.append("]");
    return sb.toString();
  }

}