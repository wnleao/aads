package exercises.chapter02;

import datastructures.LinkedNode;

public class RunnerTechnique {

  public static LinkedNode interweave(LinkedNode list) {
    LinkedNode p1 = list;
    LinkedNode p2 = list;
    while (p2 != null) {
      p2 = p2.getNext();
      if (p2 != null) {
        p2 = p2.getNext();
      } 
      if (p2 != null) {
        p1 = p1.getNext();
      }  else {    
        LinkedNode tmp = p1.getNext();
        p1.setNext(null);
        p1 = tmp;
      }
    }
    p2 = list;
    while (p1 != null) {
      p2.insert(p1.getValue());
      p1 = p1.getNext();  
      p2 = p2.getNext().getNext();
    }
    return list;
  }

  public static void main(String[] args) {
    System.out.println("RunnerTechinque...");   
    
    LinkedNode list = new LinkedNode(1,3,5,7,2,4,6,8); 
    System.out.println("original = " + list);
    System.out.println("result   = " + interweave(list));

    list = new LinkedNode(1,3,5,7,9,2,4,6,8); 
    System.out.println("original = " + list);
    System.out.println("result   = " + interweave(list));

    list = new LinkedNode(1,3,5,7,2,4,6); 
    System.out.println("original = " + list);
    System.out.println("result   = " + interweave(list));
  }

}