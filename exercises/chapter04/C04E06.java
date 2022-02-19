package exercises.chapter04;

import exercises.Exercise;
import datastructures.tree.Node;

/**
  * 4.6 Successor: Write an algorithm to find the "next" node (i .e.,
  * in-order successor) of a given node in a binary search tree. 
  * You may assume that each node has a link to its parent.
  **/
public class C04E06 extends Exercise {

  public C04E06(String[] args) {
    super(args);
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

    n1.visitInOrder(n -> System.out.print(n.value + ", "));
    System.out.println("");

    n1.visitInOrder(n -> {
      System.out.println(n.value + ": " + n.successorInOrder());
    });

  }

}