package exercises.chapter02;

import datastructures.LinkedNode;
import java.util.Set;
import java.util.HashSet;

public class Ex08LoopDetection {

  public static LinkedNode detectLoop(LinkedNode list) {
    Set<LinkedNode> nodes = new HashSet<>();
    for (LinkedNode r = list; r != null; r = r.getNext()) {
      if (nodes.contains(r)) {
        return r;
      }
      nodes.add(r);
    }
    return null;
  }

  public static void main(String[] args) {
    LinkedNode n3 = new LinkedNode(3);
    LinkedNode n1 = new LinkedNode(1, n3);
    LinkedNode n2 = new LinkedNode(2, n1);
    n3.setNext(n2);
    LinkedNode n4 = new LinkedNode(4, n3);
    
    System.out.println(n3.hashCode());
    System.out.println(detectLoop(n4).hashCode());
  }

}
