package exercises.chapter04;

import exercises.Exercise;

import datastructures.graph.*;
import java.util.Map;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

/**
  * 4.7 Build Order
  **/
public class C04E07 extends Exercise {

  public C04E07(String[] args) {
    super(args);
  } 

  public String findBuildOrder(String[] projects, String[][] dependencies) {
    if (dependencies.length == 0) {
      return Arrays.stream(projects).collect(Collectors.joining(", ")); 
    }    
    return findBuildOrderGraph(projects, dependencies).map(buildOrder -> {
      return Arrays.stream(buildOrder).collect(Collectors.joining(", "));
    }).orElse("no build order! There's a circular dependency!");
  }

  private Optional<String[]> findBuildOrderGraph(String[] projects, String[][] dependencies) {
    Graph<String> graph = new Graph<>(projects, dependencies);    
    String[] buildOrder = new String[projects.length];
    int i = 0;
    while (!graph.isEmpty()) {
      Collection<Node<String>> sources = graph.getSources();
      if (sources.isEmpty()) return Optional.empty();
      for (Node<String> n : sources) {
        buildOrder[i++] = n.value;
        graph.remove(n);
      }        
    }
    return Optional.of(buildOrder);
  }

  private Optional<String[]> findBuildOrderNoGraph(String[] projects, String[][] dependencies) {
    // build order data structures
    Map<String, List<String>> deps = new HashMap<>();
    for (String p : projects) { 
      deps.put(p, new ArrayList<>());      
    }
    for (String[] d : dependencies) {
      deps.get(d[1]).add(d[0]);      
    } 
    String[] buildOrder = new String[projects.length];
    int index = 0;
    while (!deps.isEmpty()) {
      String current = null;
      for (Entry<String, List<String>> entry : deps.entrySet()) {
        if (entry.getValue().isEmpty()) {
          current = entry.getKey();
          break;
        }
      }
      if (current == null) return Optional.empty(); 
      deps.remove(current);
      for (Entry<String, List<String>> entry : deps.entrySet()) {
        entry.getValue().remove(current);        
      }
      buildOrder[index++] = current;      
    }
    return Optional.of(buildOrder);
  }

  public void compute(String[] args) {
    // projects: a, b, c, d, e, f
    String[] projects = new String[] {"a", "b", "c", "d", "e", "f"};
    // dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
    String[][] dependencies = new String[][] {{"a", "d"}, {"f", "b"}, {"b","d"}, {"f", "a"}, {"d", "c"}};
    System.out.println(findBuildOrder(projects, dependencies));
  }

}