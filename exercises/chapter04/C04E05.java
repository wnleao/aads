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

  public static class BST {
    public int value;
    public boolean isBST;
  }

  public boolean isBSTA(Node<Integer> node) {
    BST bst = checkBST(node, true);
    return bst == null || bst.isBST;
  }

  private BST checkBST(Node<Integer> node, boolean min) {
    if (node == null) { return null; }
    BST l = checkBST(node.left, false);
    if (l != null && !l.isBST) { return l; }
    BST r = checkBST(node.right, true);
    if (r != null && !r.isBST) { return r; }
    return checkBST(node.value, l, r, min);
  }

  private BST checkBST(Integer value, BST left, BST right, boolean min) {
    BST bst = new BST();
    bst.isBST = (left == null || left.value <= value) && (right == null || right.value > value);
    bst.value = value;
    if (min) {
      bst.value = left != null ? Math.min(bst.value, left.value) : bst.value;
      bst.value = right != null ? Math.min(bst.value, right.value) : bst.value;
    } else {
      bst.value = left != null ? Math.max(bst.value, left.value) : bst.value;
      bst.value = right != null ? Math.max(bst.value, right.value) : bst.value;
    }
    return bst; 
  }

  public boolean isBSTB(Node<Integer> node) {
    if (node == null) { return true; }
    return checkBSTB(node, true) != null;
  }

  public Integer checkBSTB(Node<Integer> node, boolean min) {
    Integer lv = null;
    if (node.left != null) {
      lv = checkBSTB(node.left, false);
      if (lv == null) { return null; }
    }

    Integer rv = null;
    if (node.right != null) {
      rv = checkBSTB(node.right, true);
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


  public void dumpBST(Node<Integer> node) {
    node.dump();
    System.out.println("isBSTA? " + isBSTA(node));
    System.out.println("isBSTB? " + isBSTB(node));
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
    n1.left.right = new Node<>(2000);
    dumpBST(n1);

    n1.left.right = new Node<>(75);
    dumpBST(n1);
  }

}