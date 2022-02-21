package exercises.chapter04;

import exercises.Exercise;
import datastructures.tree.Node;
import java.util.Set;
import java.util.HashSet;

/**
  * 4.8 First Common Ancestor
  **/
public class C04E08 extends Exercise {

  public C04E08(String[] args) {
    super(args);
  } 

  public <T> Node<T> commonAncestor(Node<T> a, Node<T> b) {
    if (a == b) return a.parent;
    Set<Node<T>> parents = new HashSet<>();    
    for (Node<T> p = a.parent; p != null; p = p.parent) {
      parents.add(p);
    }
    Node<T> ca = b.parent;
    for (; ca != null && !parents.contains(ca); ca = ca.parent);
    return ca;
  }

  private void dumpCommonAncestor(Node<String> a, Node<String> b, String expected) {
    System.out.println(String.format("The common ancestor of %s and %s is %s and should be %s", a, b, commonAncestor(a, b), expected));
  }

  public void compute(String[] args) {
    
    /*
               A
            B     C 
          D  E   F  G
        H I J K L M N O  
    */

    Node<String> n1 = new Node<>("A");
    n1.setLeft(Node.of("B"));
    n1.left.setLeft(Node.of("D"));
    n1.left.setRight(Node.of("E"));
    n1.setRight(Node.of("C"));
    n1.right.setLeft(Node.of("F"));
    n1.right.setRight(Node.of("G"));
    n1.left.left.setLeft(Node.of("H"));
    n1.left.left.setRight(Node.of("I"));
    n1.left.right.setLeft(Node.of("J"));
    n1.left.right.setRight(Node.of("K"));
    n1.right.left.setLeft(Node.of("L"));
    n1.right.left.setRight(Node.of("M"));
    n1.right.right.setLeft(Node.of("N"));
    n1.right.right.setRight(Node.of("O"));
    
    dumpCommonAncestor(n1.left.left.left, n1.right.left.right, "A");
    dumpCommonAncestor(n1.left.left.left, n1.left.left.right, "D");
    dumpCommonAncestor(n1.right.left.left, n1.right.left.right, "F");
    dumpCommonAncestor(n1.left.left.left, n1.left.left, "B");
  }

}