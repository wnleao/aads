package exercises.chapter04;

import exercises.Exercise;
import datastructures.tree.Node;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/**
  * 4.8 First Common Ancestor
  **/
public class C04E08 extends Exercise {

  public C04E08(String[] args) {
    super(args);
  } 

  public <T> Node<T> commonAncestorWPL(Node<T> a, Node<T> b) {
    if (a.parent == null || b.parent == null) return null;
    if (a == b) return a.parent;
    Set<Node<T>> parents = new HashSet<>();    
    for (Node<T> p = a.parent; p != null; p = p.parent) {
      parents.add(p);
    }
    Node<T> ca = b.parent;
    for (; ca != null && !parents.contains(ca); ca = ca.parent);
    return ca;
  }

  public <T> Node<T> commonAncestorNPL(Node<T> r, Node<T> a, Node<T> b) {
    if (a.parent == null || b.parent == null) return null;
    if (a == b) return a.parent;

    // search depth first to find nodes a AND b parents
    List<Node<T>> parentsA = new ArrayList<>();
    findNodeParents(parentsA, r, a);
    List<Node<T>> parentsB = new ArrayList<>();
    findNodeParents(parentsB, r, b);
    
    // compare FIFO lists each node at a time to find common ancestor
    Node<T> ca = null;
    for(int i = 0; checkParents(parentsA, parentsB, i); ca = parentsA.get(i++));

    return ca;
  }

  private <T> boolean checkParents(List<Node<T>> pas, List<Node<T>> pbs, int i) {
    return i < pas.size() && i < pbs.size() && pas.get(i) == pbs.get(i);
  } 

  private <T> boolean findNodeParents(List<Node<T>> ps, Node<T> c, Node<T> n) {
    if (c == n) return true;
    if (c == null || c.left == null && c.right == null) return false;
    ps.add(c);
    if (findNodeParents(ps, c.left, n) || findNodeParents(ps, c.right, n)) return true;
    ps.remove(ps.size() - 1);
    return false;
  }

  private void dumpCommonAncestor(Node<String> r, Node<String> a, Node<String> b, String expected) {
    System.out.println(String.format("NPL: the common ancestor of %s and %s is %s and should be %s", a, b, commonAncestorNPL(r, a, b), expected));
     System.out.println(String.format("WPL: The common ancestor of %s and %s is %s and should be %s", a, b, commonAncestorWPL(a, b), expected));
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
    
    dumpCommonAncestor(n1, n1.left.left.left, n1.right.left.right, "A");
    dumpCommonAncestor(n1, n1.left, n1.right, "A");
    dumpCommonAncestor(n1, n1.left, n1.left, "A");
    dumpCommonAncestor(n1, n1, n1.right.left.right, "null");
    dumpCommonAncestor(n1, n1.left.left.left, n1.left.left.right, "D");
    dumpCommonAncestor(n1, n1.right.left.left, n1.right.left.right, "F");
    dumpCommonAncestor(n1, n1.left.left.left, n1.left.left, "B");
  }

}