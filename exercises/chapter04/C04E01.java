package exercises.chapter04;

import exercises.Exercise;
import datastructures.graph.*;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

/**
 * 4.1 Route Between Nodes: Given a directed graph, 
 * design an algorithm to find out whether there is a
 * route between two nodes.
 **/
public class C04E01 extends Exercise {

  public C04E01(String[] args) {
    super(args);
  } 

  /**
   * This uses BFS to found out whether 
   * there is a route between the given nodes.
   **/
  public static <T> boolean isRoute(Node<T> a, Node<T> b) {
    Set<Node<T>> visited = new HashSet<>();
    LinkedList<Node<T>> queue = new LinkedList<>();
    queue.add(a);
    while (!queue.isEmpty()) {
      Node<T> c = queue.remove();
      if (c == b) { return true; }   
      if (!visited.contains(c)) {
        visited.add(c);        
        c.out.forEach(queue::add);
      }
    }
    return false; 
  }

  public void compute(String[] args) {
    Node<String> n1 = Node.of("1");
    Node<String> n2 = Node.of("2");
    Node<String> n3 = Node.of("3");
    Node<String> n4 = Node.of("4");
    Node<String> n5 = Node.of("5");
    Node<String> n6 = Node.of("6");
    Node<String> n7 = Node.of("7");

    // n1 -> n2 -> n4 -> n6
    //  \.    '\        '/
    //   n3 -> (    n5   )
    //             '/
    //             n7

    n1.add(n2);
    n1.add(n3);
    n2.add(n4);
    n3.add(n5);
    n4.add(n6);
    n5.add(n6);
    n5.add(n2);
    n7.add(n5);

    List<Node<String>> nodes = Arrays.asList(n1, n2, n3, n4, n5, n6, n7);

    for (Node<String> a : nodes) {
      for (Node<String> b : nodes) {
        System.out.println(String.format("isRoute(%s, %s) ? %s", a, b, isRoute(a, b)));
      }
    }
  }

}