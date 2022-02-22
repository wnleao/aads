package exercises.chapter04;

import exercises.Exercise;

import datastructures.tree.Node;

import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

/**
  * 4.9 BST Sequences
  **/
public class C04E09 extends Exercise {

  public C04E09(String[] args) {
    super(args);
  } 

  public List<LinkedList<Integer>> findSequences(Node<Integer> n) {
    if (n == null) return Collections.emptyList();
    
    List<LinkedList<Integer>> seqsLeft = findSequences(n.left);
    List<LinkedList<Integer>> seqsRight = findSequences(n.right);
    
    List<LinkedList<Integer>> seqs = new LinkedList<>();
    if (!seqsLeft.isEmpty() && !seqsRight.isEmpty()) {
      seqs.addAll(combineSimple(seqsLeft, seqsRight));
      seqs.addAll(combineBreak(seqsLeft, seqsRight));
      seqs.addAll(combineSimple(seqsRight, seqsLeft));
      seqs.addAll(combineBreak(seqsRight, seqsLeft));
    } else if (!seqsRight.isEmpty()) {
      seqs.addAll(seqsRight);
    } else if (!seqsLeft.isEmpty()) {
      seqs.addAll(seqsLeft);
    } else {
      seqs.add(new LinkedList<>());
    }
    seqs.forEach(s -> s.push(n.value));

    return seqs;
  }

  private List<LinkedList<Integer>> combineSimple(List<LinkedList<Integer>> seqsA, List<LinkedList<Integer>> seqsB) {
    List<LinkedList<Integer>> seqs = new LinkedList<>();
    for (LinkedList<Integer> seqA : seqsA) {
      LinkedList<LinkedList<Integer>> inner = new LinkedList<>();
      for (LinkedList<Integer> seqB : seqsB) {
        LinkedList<Integer> seq = new LinkedList<>();
        seq.addAll(seqA);
        seq.addAll(seqB);
        inner.add(seq);
      }
      seqs.addAll(inner);
    }
    return seqs;
  }

  private List<LinkedList<Integer>> combineBreak(List<LinkedList<Integer>> seqsA, List<LinkedList<Integer>> seqsB) {
    if (seqsA.get(0).size() == 1) return Collections.emptyList();

    List<LinkedList<Integer>> seqs = new LinkedList<>();
    for (LinkedList<Integer> seqA : seqsA) {
      Integer a = seqA.pop();
      LinkedList<LinkedList<Integer>> inner = new LinkedList<>();
      for (LinkedList<Integer> seqB : seqsB) {
          LinkedList<Integer> seqRL = new LinkedList<>();
          seqRL.addAll(seqB);
          seqRL.addAll(seqA);
          inner.add(seqRL);
      
          if (seqB.size() > 1) {
            LinkedList<Integer> seqRLR = new LinkedList<>();
            Integer b = seqB.pop();
            seqRLR.add(b);
            seqRLR.addAll(seqA);
            seqRLR.addAll(seqB);
            seqB.push(b);
            inner.add(seqRLR);    
          }                    
      }
      seqA.push(a);
      inner.forEach(s -> s.push(a));
      seqs.addAll(inner);
    }
    return seqs;
  }

  public void compute(String[] args) {
      Node<Integer> n1 = new Node<>(2);
      n1.setLeft(Node.of(1));
      n1.setRight(Node.of(3));
      
      n1.dump();

      findSequences(n1).forEach(System.out::println);

      n1 = new Node<>(7);
      n1.setLeft(Node.of(4));
      n1.left.setLeft(Node.of(1));
      n1.left.setRight(Node.of(6));
      n1.setRight(Node.of(13));
      n1.right.setLeft(Node.of(8));
      n1.right.setRight(Node.of(15));
    
      n1.dump();

      findSequences(n1).forEach(System.out::println);
  }

}