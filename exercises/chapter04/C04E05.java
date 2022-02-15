package exercises.chapter04;

import exercises.Exercise;

import datastructures.tree.Node;

/**
  * 4.5 Validate BST: Implement a function to check if a 
  * binary tree is a binary search tree.
  **/
public class C04E05 extends Exercise {

  public C04E05(String[] args) {
    super(args);
  } 

  public boolean isBST(Node<Integer> node) {
    if (node == null) { return true; }
    return checkBST(node, true) != null;
  }

  public Integer checkBST(Node<Integer> node, boolean min) {
    Integer lv = null;
    if (node.left != null) {
      lv = checkBST(node.left, false);
      if (lv == null) { return null; }
    }

    Integer rv = null;
    if (node.right != null) {
      rv = checkBST(node.right, true);
      if (rv == null) { return null; }
    }
    
    if (lv != null && lv > node.value) { return null; }
    if (rv != null && rv <= node.value) { return null; }

    Integer value = node.value;
    if (min) {
      value = lv != null ? Math.min(value, lv) : value;
      value = rv != null ? Math.min(value, rv) : value;
    } else {
      value = lv != null ? Math.max(value, lv) : value;
      value = rv != null ? Math.max(value, rv) : value;
    }

    return value;
  }

  public static class BST {
    
    private static int tmp;
    
    public static boolean validate(Node<Integer> node) {
      tmp = Integer.MIN_VALUE;
      return validateR(node);
    }

    private static boolean validateR(Node<Integer> node) {
      if (node == null) { return true; }    
      if (!validateR(node.left)) { return false; }
      if (node.value < tmp) { return false; }
      tmp = node.value;
      return validateR(node.right);
    }

  }

  public void dumpBST(Node<Integer> node) {
    node.dump();
    System.out.println("isBST? " + isBST(node));
    System.out.println("isBST? " + BST.validate(node));
  }

  public void compute(String[] args) {
    Node<Integer> n1 = new Node<>(100);
    dumpBST(n1);

    n1.left = new Node<>(1000);
    dumpBST(n1);

    n1.left = new Node<>(50);
    dumpBST(n1);

    n1.right = new Node<>(0);
    dumpBST(n1);

    n1.right = new Node<>(1000);
    dumpBST(n1);

    n1.left.left = new Node<>(25);
    n1.left.right = new Node<>(101);
    dumpBST(n1);

    n1.left.right = new Node<>(75);
    dumpBST(n1);
  }

}