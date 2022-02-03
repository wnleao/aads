package exercises.chapter02;

import datastructures.LinkedNode;

public class Ex05SumLists {

  public static LinkedNode addA(LinkedNode a, LinkedNode b) {
    LinkedNode head = null;   
    LinkedNode curr = null;   
    LinkedNode r1 = a;
    LinkedNode r2 = b;
    boolean overflow = false;
    while (r1 != null || r2 != null || overflow) {
      AddResult res = addNodes(r1, r2, overflow);
      overflow = res.overflow;
      LinkedNode node = new LinkedNode(res.digit);
      if (head == null) {
        head = node;        
      } else {
        curr.setNext(node);
      }
      curr = node;
      r1 = r1 != null ? r1.getNext() : null;
      r2 = r2 != null ? r2.getNext() : null;
    }
    return head;
  }

  public static LinkedNode addB(LinkedNode a, LinkedNode b) {
    return addRecursive(a, b, false);
  }

  private static LinkedNode addRecursive(LinkedNode a, LinkedNode b, boolean overflow) {
    if (a == null && b == null && !overflow) {
      return null;
    }
    AddResult r = addNodes(a, b, overflow);
    return new LinkedNode(r.digit, addRecursive(a != null ? a.getNext() : null, b != null ? b.getNext() : null, r.overflow));
  }

  private static LinkedNode reverse(LinkedNode list) {
    if (list == null || list.getNext() == null) {
      return list;
    }
    LinkedNode head = new LinkedNode(list.getValue(), null);
    LinkedNode curr = list;
    while((curr = curr.getNext()) != null) {
      head = new LinkedNode(curr.getValue(), head);
    }
    return head;
  }

  public static LinkedNode addFollowUp(LinkedNode a, LinkedNode b) {
    return reverse(addB(reverse(a), reverse(b)));
  }
  
  public static void printAdd(LinkedNode a, LinkedNode b) {
    System.out.println(a + " + " + b + " = ");
    System.out.println(addA(a, b));
    System.out.println(addB(a, b));
  }

  public static void printAddFollowUp(LinkedNode a, LinkedNode b) {
    System.out.println(a + " + " + b + " = ");
    System.out.println(addFollowUp(a, b));    
  }
  
  public static void main(String[] args) {
    printAdd(new LinkedNode(7,1,6), new LinkedNode(5,9,2));
    printAdd(new LinkedNode(5,9,2), new LinkedNode(7,1,6));
    printAdd(new LinkedNode(0), new LinkedNode(0));
    printAdd(new LinkedNode(0,0), new LinkedNode(0,0));
    printAdd(new LinkedNode(1,2,3,4,5,6), new LinkedNode(7));
    printAdd(new LinkedNode(7), new LinkedNode(1,2,3,4,5,6));
    printAdd(new LinkedNode(9,9,9), new LinkedNode(9,9,9));

    printAddFollowUp(new LinkedNode(6,1,7), new LinkedNode(2,9,5));
    printAddFollowUp(new LinkedNode(6,1,7), new LinkedNode(3,9,5));
    printAddFollowUp(new LinkedNode(7), new LinkedNode(1,2));
  }   

  private static AddResult addNodes(LinkedNode a, LinkedNode b, boolean overflow) {
    return new AddResult(a, b, overflow);
  }

  private static class AddResult {
    
    public final int digit;

    public final boolean overflow;

    AddResult(LinkedNode a, LinkedNode b, boolean o) {
      int v1 = a != null ? a.getValue() : 0;
      int v2 = b != null ? b.getValue() : 0;
      int r = v1 + v2 + (o ? 1 : 0);
      overflow = r >= 10;
      digit = overflow ? r % 10 : r;      
    }
  }
}

