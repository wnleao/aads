package datastructures.graph;

import java.util.List;
import java.util.ArrayList;

public class Node {

  public final String name;

  public Node(String name) {
    this.name = name;
  }

  public List<Node> nodes = new ArrayList<>();

  public void add(Node node) {
    nodes.add(node);
  }

  @Override
  public String toString() {
    return name;
  }

}