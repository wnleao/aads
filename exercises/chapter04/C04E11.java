package exercises.chapter04;

import exercises.Exercise;

import datastructures.tree.Node;
import java.util.Random;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

/**
  * 4.11 Random Node
  **/
public class C04E11 extends Exercise {

  public C04E11(String[] args) {
    super(args);
  } 

  private <T> void dumpDelete(BinaryTree<T> bt, T value) {
    System.out.println("delete " + value);
    if (bt.delete(value)) {
      bt.dump();  
    } else {
      System.out.println("not found!");
    }    
  }

  private <T> void dumpInsert(BinaryTree<T> bt, T value) {
    System.out.println("insert " + value);
    bt.insert(value);
    bt.dump();
  }
  
  public void compute(String[] args) {
    BinaryTree<Integer> bt = new BinaryTree<>();
    bt.insert(5, 10, 4);

    System.out.println("random node " + bt.getRandomNode());
    
    dumpInsert(bt, 21);
    dumpDelete(bt, 10);
    dumpDelete(bt, 4);
    dumpInsert(bt, 10);
    dumpInsert(bt, 11);
    dumpDelete(bt, 5);
    dumpDelete(bt, 21);
    dumpDelete(bt, 11);
    dumpDelete(bt, 10);
    dumpInsert(bt, 12);
    dumpInsert(bt, 19);
  }

  public static class BinaryTree<T> {
  
    public Node<T> root;      

    private int pointer;
    
    private List<Node<T>> nodes = new ArrayList<>();

    private Random random = new Random();

    public void dump() {
      if (root != null) {
        root.dump();
      } else {
        System.out.println("empty!");
      }
    }
    
    public Optional<Node<T>> find(T value) {
      return root == null ? Optional.empty() : root.find(value);
    }
    
    public boolean delete(T value) {
      return find(value).map(n -> {
        nodes.remove(nodes.size()-1);
        if (nodes.isEmpty()) {
          root = null;
          pointer = -1;
        } else {  
          Node<T> parent = nodes.get(pointer);    
          if (parent.right != null) {
            n.value = parent.right.value;  
            parent.setRight(null);
          } else {
            n.value = parent.left.value;      
            parent.setLeft(null);
            pointer--;
          }
        }
        return true;   
      }).orElse(false);
    }
    
    public void insert(T value) {
      Node<T> node = Node.of(value);
      if (root == null) {
        root = node;
        pointer = 0;
      } else {
        Node<T> parent = nodes.get(pointer);
        if (parent.left != null && parent.right != null) {
          parent = nodes.get(++pointer);
        }
        if (parent.left == null) {
          parent.setLeft(node);  
        } else {
          parent.setRight(node);
        } 
      }
      nodes.add(node);
    }

    public void insert(T... values) {
      for (T value : values) {
        insert(value);
      }
    }
    
    public Node<T> getRandomNode() {
      if (nodes.isEmpty()) {
        return null;
      }
      return nodes.get(random.nextInt(nodes.size()));
    }
    
  }

}