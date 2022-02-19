package datastructures.graph;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.stream.Collectors;

public class Graph<T> {

  private Map<T, Node<T>> nodes = new HashMap<>();

  public Graph() {
  }

  public Graph(T[] values, T[][] links) {
    for (T v : values) {
      add(v);
    }
    for(T[] l : links) {
      link(nodes.get(l[0]), nodes.get(l[1]));
    }
  }

  public boolean isEmpty() {
    return nodes.isEmpty();
  }

  public Node<T> add(Node<T> node) {
    nodes.put(node.value, node);
    return node;
  }

  public Node<T> add(T value) {
    return add(Node.of(value));
  }

  public Collection<Node<T>> getNodes() {
    return nodes.values();
  }

  public Collection<Node<T>> getSources() {
    return getNodes().stream().filter(n -> n.in.isEmpty()).collect(Collectors.toList());    
  }

  public Node<T> remove(Node<T> node) {
    Node<T> removed = nodes.remove(node.value);
    if (removed != null) {
      node.out.forEach(o -> o.in.remove(node));
      node.out.clear();      
    }
    return removed;
  }

  public void link(Node<T> source, Node<T> target) {
    source.add(target);    
  }

}
