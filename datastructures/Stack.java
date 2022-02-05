package datastructures;

import java.util.NoSuchElementException;

public class Stack<T> {

  private Node<T> head;

  private int size;

  public void push(T value) {
    Node<T> node = new Node<>(value);
    node.setNext(head);
    head = node;    
    size++;
  }

  public T peek() {
    throwExceptionIfEmpty();
    return head.getValue();
  }

  public T pop() {
    throwExceptionIfEmpty();
    T value = head.getValue();
    head = head.getNext();
    size--;
    return value;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public int size() {
    return size;
  }

  private void throwExceptionIfEmpty() {
    if (head == null) {
      throw new NoSuchElementException("empty stack");
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (Node<T> n = head; n != null; n = n.getNext()) {
      if (n != head) {
        sb.append(", ");
      }
      sb.append(n.getValue());
    }
    sb.append("]");
    return sb.toString();
  }
  
}