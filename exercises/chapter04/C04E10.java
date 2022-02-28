package exercises.chapter04;

import exercises.Exercise;

import datastructures.tree.Node;

/**
  * 4.10 Check Subtree
  **/
public class C04E10 extends Exercise {

  public C04E10(String[] args) {
    super(args);
  } 
  
  public <T> boolean checkSubTree(Node<T> t1, Node<T> t2) {
    if (t1 == null || t2 == null) {
      return false;
    }
    return t1.find(t2.value).map(t2::isTreeEquals).orElse(false);
  }

  public void compute(String[] args) {
    
      Node<Integer> t1 = new Node<>(7);
      t1.setLeft(Node.of(4));
      t1.left.setLeft(Node.of(1));
      t1.left.setRight(Node.of(6));
      t1.setRight(Node.of(13));
      t1.right.setLeft(Node.of(8));
      t1.right.setRight(Node.of(15));
      
      System.out.println("T1...");
      t1.dump();

      Node<Integer> t2 = new Node<>(13);
      t2.setLeft(Node.of(8));
      t2.setRight(Node.of(15));
      
      System.out.println("T2...");
      t2.dump();

      System.out.println("is T2 subtree of T1 ? " + checkSubTree(t1, t2));
  }

}