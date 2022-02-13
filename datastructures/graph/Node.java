package datastructures.graph;

import java.util.List;
import java.util.ArrayList;

public class Node {

  private final String name;

  public Node(String name) {
    this.name = name;
  }

  public List<Node> nodes = new ArrayList<>();

  public String getName() {
    return name;
  }

  public void add(Node node) {
    nodes.add(node);
  }

  @Override
  public String toString() {
    return name;
  }

}