package datastructures.graph;

import java.util.List;
import java.util.ArrayList;

public class Node<T> {

  public final T value;

  public List<Node<T>> in = new ArrayList<>();

  public List<Node<T>> out = new ArrayList<>();

  public Node(T value) {
    this.value = value;
  }

  public static <T> Node<T> of(T value) {
    return new Node<>(value);
  }

  public void add(Node<T> n) {
    out.add(n);
    n.in.add(this);
  }

  @Override
  public String toString() {
    return value != null ? value.toString() : null;
  }

}