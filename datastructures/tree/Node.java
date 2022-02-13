package datastructures.tree;

import java.util.Objects;

public class Node<T> {

  public final T value;

  public Node left;

  public Node right;

  public Node(T value) {
    Objects.requireNonNull(value);
    this.value = value;
  }

  @Override
  public String toString() {
    return value.toString();
  }

  public void dump() {
    dump(this, 0);
  }

  private void dump(Node<T> node, int paddingLeft) {
    if (node == null) { return; }
    System.out.println(" ".repeat(paddingLeft) + "> " + node);
    dump(node.left, paddingLeft+2);
    dump(node.right, paddingLeft+2);
  }

}