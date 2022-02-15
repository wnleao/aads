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
  public static boolean isRoute(Node a, Node b) {
    Set<Node> visited = new HashSet<>();
    LinkedList<Node> queue = new LinkedList<>();
    queue.add(a);
    while (!queue.isEmpty()) {
      Node c = queue.remove();
      if (c == b) { return true; }   
      if (!visited.contains(c)) {
        visited.add(c);        
        c.nodes.forEach(queue::add);
      }
    }
    return false; 
  }

  public void compute(String[] args) {
    Node n1 = new Node("1");
    Node n2 = new Node("2");
    Node n3 = new Node("3");
    Node n4 = new Node("4");
    Node n5 = new Node("5");
    Node n6 = new Node("6");
    Node n7 = new Node("7");

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

    List<Node> nodes = Arrays.asList(n1, n2, n3, n4, n5, n6, n7);

    for (Node a : nodes) {
      for (Node b : nodes) {
        System.out.println(String.format("isRoute(%s, %s) ? %s", a, b, isRoute(a, b)));
      }
    }
  }

}