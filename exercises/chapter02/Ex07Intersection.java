package exercises.chapter02;

import datastructures.LinkedNode;
import java.util.Set;
import java.util.HashSet;

public class Ex07Intersection {

  public static boolean intersect(LinkedNode a, LinkedNode b) {
    if (a == null || b == null) {
      return false;
    }
    Set<LinkedNode> nodes = new HashSet<>();
    for (LinkedNode r = a; r != null; r = r.getNext()) {
      nodes.add(r);
    }
    for (LinkedNode r = b; r != null; r = r.getNext()) {
      if (nodes.contains(r)) {
        return true;
      }
    }
    return false;
  }

  public static void printIntersect(LinkedNode a, LinkedNode b) {
    System.out.println(a);
    System.out.println(b);
    System.out.println("intersect? " + intersect(a, b));
  }

  public static void main(String[] args) {
    LinkedNode a = new LinkedNode(1,2,3,4,5);
    LinkedNode b = new LinkedNode(9,8);
    b.getNext().setNext(a.getNext().getNext());
    printIntersect(a, b);

    printIntersect(new LinkedNode(1,2), new LinkedNode(1,2));
  }

}
