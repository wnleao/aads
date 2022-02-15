package exercises.chapter04;

import exercises.Exercise;

import datastructures.tree.Node;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
  * 4.3 List of Depths: Given a binary tree, design an algorithm
  * which creates a linked list of all the nodes at each 
  * depth (e.g., if you have a tree with depth D, you'll have D
  * linked lists).
  **/
public class C04E03 extends Exercise {

  public C04E03(String[] args) {
    super(args);
  }

  public void compute(String[] args) {
    C04E02 mt = new C04E02(null);
    Node<Integer> root = mt.toTree(new int[]{ 1,2,3,4,5,6,7,8,9,10,11 });
    if (root != null) {
      root.dump();
    }
    
    System.out.println("S1");
    dump(listOfDepths(root));
    System.out.println("S2");
    dump(listOfDepths2(root));    
  }

  private <T> void dump(List<List<Node<T>>> lists) {
    if (lists.isEmpty()) {
      System.out.println("empty list of depths!");
    }
    int depth = 0;
    for (List<Node<T>> list : lists) {
      System.out.println(depth++ + ". " + list);      
    }    
  }

  public <T> List<List<Node<T>>> listOfDepths(Node<T> root) {
    List<List<Node<T>>> lists = new ArrayList<>();
    visit(root, 0, lists);
    return lists;
  }

  public <T> void visit(Node<T> node, int level, List<List<Node<T>>> lists) {
    if (node == null) { return; }
    if (lists.size() <= level) {
      lists.add(new LinkedList<>());
    }
    lists.get(level).add(node);
    visit(node.left, level+1, lists);
    visit(node.right, level+1, lists);
  }
  
  public <T> List<List<Node<T>>> listOfDepths2(Node<T> root) {
    if (root == null) { return new LinkedList<>(); }
    
    LinkedList<List<Node<T>>> lists = createListOfDepths(root);
    List<Node<T>> current = lists.peek();
    while (true) {
      List<Node<T>> next = new LinkedList<>();
      for (Node<T> node : current) {
        if (node.left != null) {
          next.add(node.left);
        }
        if (node.right != null) {
          next.add(node.right);
        }
      }
      if (next.isEmpty()) { break; } 
      lists.add(next);
      current = next;
    }
    
    return lists;
  }

  private <T> LinkedList<List<Node<T>>> createListOfDepths(Node<T> node) {
    LinkedList<List<Node<T>>> lists = new LinkedList<>();
    List<Node<T>> current = new LinkedList<>();
    current.add(node);
    lists.add(current);
    return lists;
  }

}
