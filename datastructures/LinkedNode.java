package datastructures;

public class LinkedNode { 

  private int value;

  private LinkedNode next;

  public LinkedNode(int value) {
    this.value = value;
  }

  public LinkedNode(int... values) {
    if (values.length == 0) {
      throw new IllegalArgumentException();
    }
    this.value = values[0];
    for (int i = 1; i < values.length; i++) {
      add(values[i]);
    }
  }

  public void setValue(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public void setNext(LinkedNode next) {
    this.next = next;
  }

  public LinkedNode getNext() {
    return next;
  }

  public void insert(LinkedNode node) {
    node.setNext(next);
    next = node;
  }

  public void insert(int value) {
    insert(new LinkedNode(value));
  }

  public void add(int value) {
    LinkedNode newNode = new LinkedNode(value);
    LinkedNode curr = this;
    for (; curr.next != null; curr = curr.next);
    curr.next = newNode;
  }

  public void add(int... values) {
    for (int value : values) {
      add(value);
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    LinkedNode node = this;
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

}