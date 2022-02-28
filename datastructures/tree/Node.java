package datastructures.tree;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.Optional;
import java.util.LinkedList;

public class Node<T> {

  public final T value;

  public Node<T> parent;

  public Node<T> left;

  public Node<T> right;

  public Node(T value) {
    Objects.requireNonNull(value);
    this.value = value;
  }

  public static <T> Node<T> of(T value) {
    return new Node<>(value);
  }

  public void setLeft(Node<T> node) {
    left = node;
    if (node != null) node.parent = this;
  }

  public void setRight(Node<T> node) {
    right = node;
    if (node != null) node.parent = this;
  }

  /**
   * Uses breadth first search to find the node that holds the 
   * provided value. Uses the current node as root to start the
   * search.
   * 
   * @param value the desired value to search
   * @return the first node that holds the given valeu or empty if none found. 
   **/
  public Optional<Node<T>> find(T value) {
    LinkedList<Node<T>> searchQueue = new LinkedList<>();
    searchQueue.add(this);
    while(!searchQueue.isEmpty()) {
      Node<T> current = searchQueue.removeFirst();
      if (current.value.equals(value)) {
        return Optional.of(current);
      }
      if (current.left != null) {
        searchQueue.add(current.left);
      }
      if (current.right != null) {
        searchQueue.add(current.right);
      }
    }
    return Optional.empty();
  }

  public boolean isTreeEquals(Node<T> other) {
    return areTreeEqual(this, other);
  }
  
  private boolean areTreeEqual(Node<T> t1, Node<T> t2) {
    if (t1 == t2) {
      return true;
    }
    if (t1 == null || t2 == null) {
      return false;
    }
    return t1.value.equals(t2.value) && areTreeEqual(t1.left, t2.left) && areTreeEqual(t1.right, t2.right);
  }

  @Override
  public String toString() {
    return value.toString();
  }

  public void dump() {
    dump(this, 0);
  }

  public Node<T> successorInOrder() {
    return right != null ? findRightInOrderSuccessor(right) : findRightParentSuccessor(parent, this);
  }

  private Node<T> findRightInOrderSuccessor(Node<T> n) {
    if (n.left == null) return n;
    return findRightInOrderSuccessor(n.left);
  }

  private Node<T> findRightParentSuccessor(Node<T> p, Node<T> n) {
    if (p == null) return null;
    if (p.left == n) return p;
    return findRightParentSuccessor(p.parent, p);
  }
  
  public void visitInOrder(Consumer<Node<T>> action) {
    visitInOrder(this, action);
  }

  private void visitInOrder(Node<T> node, Consumer<Node<T>> action) {
    if (node == null) return;
    visitInOrder(node.left, action);
    action.accept(node);
    visitInOrder(node.right, action);
  }

  private void dump(Node<T> node, int paddingLeft) {
    if (node == null) return;
    System.out.println(" ".repeat(paddingLeft) + "> " + node);
    dump(node.left, paddingLeft+2);
    dump(node.right, paddingLeft+2);
  }

}