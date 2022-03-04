package exercises.chapter04;

import exercises.Exercise;

import datastructures.tree.Node;
import java.util.List;
import java.util.ArrayList;

/**
  * 4.12 Paths with Sum 
  **/
public class C04E12 extends Exercise {

  public C04E12(String[] args) {
    super(args);
  } 

  public long pathsWithSums(Node<Integer> node, int sum) {
    return sums(node, sum).count;
  }

  private SumResult sums(Node<Integer> node, int sum) {
    if (node == null) {
      return SumResult.empty();      
    } else {
      return SumResult.of(node.value, sums(node.left, sum), sums(node.right, sum), sum);
    } 
  }

  private void dumpSums(Node<Integer> tree, int sum) {
    tree.dump();
    System.out.println(String.format("paths with sum %d = %d", sum, pathsWithSums(tree, sum)));
  }

  public void compute(String[] args) {
    Node<Integer> tree = new Node<>(7);
    tree.setLeft(Node.of(2));
    tree.left.setLeft(Node.of(3));
    tree.left.left.setLeft(Node.of(2));
    tree.left.left.left.setLeft(Node.of(1));
    tree.left.left.left.left.setLeft(Node.of(1));
    tree.left.left.left.left.left.setLeft(Node.of(8));
    tree.left.left.left.left.setRight(Node.of(-1));
    tree.left.left.left.left.right.setLeft(Node.of(10));
    tree.left.left.left.setRight(Node.of(3));
    tree.left.left.setRight(Node.of(4));
    
    
    dumpSums(tree, 7);  
  }

  private static class SumResult {

    public List<Integer> sums = new ArrayList<>();

    public int count;

    private SumResult() {
    }
    
    public static SumResult empty() {
      return new SumResult();
    }

    public static SumResult of(int value, SumResult left, SumResult right, int sum) {
      SumResult sr = new SumResult();
      sr.sums.add(value);
      left.sums.forEach(lv -> sr.sums.add(lv + value));
      right.sums.forEach(rv -> sr.sums.add(rv + value));
      sr.count += left.count + right.count;
      for (Integer v : sr.sums) {
        sr.count += v == sum ? 1 : 0;
      }
      return sr;
    }
    
  }
  
}