package datastructures;

import java.util.NoSuchElementException;

public class Queue<T> {

  private Node<T> head;
  private Node<T> tail;

  private int size;
  
  public void add(T value) {
    Node<T> node = new Node<>(value);
    if (tail != null) {
      tail.setNext(node);
    } else {
      head = node;      
    }
    tail = node;
    size++;
  }

  public T peek() {
   throwExceptionIfEmpty();
   return head.getValue();
  }

  public T remove() {
    throwExceptionIfEmpty();
    T value = head.getValue();
    head = head.getNext();
    if (head == null) {
      tail = null;
    }
    size--;    
    return value;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public int size() {
    return size;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (Node n = head; n != null; n = n.getNext()) {
      if (n != head) {
        sb.append(", ");
      }
      sb.append(n.getValue());
    }
    sb.append("]");
    return sb.toString();
  }

  private void throwExceptionIfEmpty() {
    if (head == null) {
      throw new NoSuchElementException("empty stack");
    }
  }

}