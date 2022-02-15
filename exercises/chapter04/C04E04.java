package exercises.chapter04;

import exercises.Exercise;
import datastructures.tree.Node;


/**
  * 4.4 Check Balanced: Implement a function to check if a binary 
  * tree is balanced. For the purposes of this question, a balanced
  * tree is defined to be a tree such that the heights of the two 
  * subtrees of any node never differ by more than one.
  **/
public class C04E04 extends Exercise {

  public C04E04(String[] args) {
    super(args);
  } 

  public boolean isBalanced(Node<Integer> root) {
    return height(root) != -1;
  }

  private int height(Node<Integer> node) {
    if (node == null) { return 0; }
    int lh = height(node.left);
    if (lh == -1) { return -1; }
    int rh = height(node.right);
    if (rh == -1) { return -1; }
    return Math.abs(rh - lh) > 1 ? -1 : Math.max(rh, lh) + 1;
  }

  public void compute(String[] args) {
    Node<Integer> n1 = new Node<>(1);
    n1.left = new Node<>(2);
    
    n1.dump();
    System.out.println("isBalanced? " + isBalanced(n1));
    
    n1.left.left = new Node<>(4);

    n1.dump();
    System.out.println("isBalanced? " + isBalanced(n1));

    n1.right = new Node<>(3);
    n1.left.left.left = new Node<>(5);
    
    n1.dump();
    System.out.println("isBalanced? " + isBalanced(n1));

    n1.left.right = new Node<>(7);
    n1.right.left = new Node<>(6);

    n1.dump();
    System.out.println("isBalanced? " + isBalanced(n1));
  }

}