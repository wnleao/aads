package exercises.chapter04;

import exercises.Exercise;

import datastructures.tree.Node;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 4.2 Minimal Tree: Given a sorted (increasing order) array with 
 * unique integer elements, write an algorithm to create a binary 
 * search tree with minimal height.
 **/
public class C04E02 extends Exercise {

  public C04E02(String[] args) {
    super(args);
  } 

  public Node<Integer> toTree(int[] values) {
    return toTree(values, 0, values.length);
  }

  private Node<Integer> toTree(int[] values, int from, int to) {
    if (from >= to) { return null; }      
    int mid = (from + to)/2;
    Node<Integer> n = new Node<>(values[mid]);
    n.left = toTree(values, from, mid);    
    n.right = toTree(values, mid+1, to);
    return n;
  }

  public void dumpToTree(int[] values) {
    System.out.print("Array = ");
    System.out.println(Arrays.stream(values)
            .mapToObj(Integer::toString)
            .collect(Collectors.joining(", ", "[", "]")));
    System.out.println("Tree  = ");
    Node<Integer> root = toTree(values);
    if (root != null) {
      root.dump();
    } else {
      System.out.println("Empty tree!");
    }
  }

  public void compute(String[] args) {
    dumpToTree(new int[] { });
    dumpToTree(new int[] { 1 });
    dumpToTree(new int[] {1, 2});
    dumpToTree(new int[] {1, 2, 3});
    dumpToTree(new int[] {1, 2, 3, 4, 5, 6, 7});
    dumpToTree(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
  }

}