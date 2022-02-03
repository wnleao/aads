package exercises.chapter02;

import datastructures.LinkedNode;

public class Ex05SumLists {

  public static LinkedNode addA(LinkedNode a, LinkedNode b) {
    LinkedNode head = null;   
    LinkedNode curr = null;   
    LinkedNode r1 = a;
    LinkedNode r2 = b;
    int carry = 0;
    while (r1 != null || r2 != null || carry == 1) {
      AddResult res = addNodes(r1, r2, carry);
      carry = res.carry;
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
    return addRecursive(a, b, 0);
  }

  private static LinkedNode addRecursive(LinkedNode a, LinkedNode b, int carry) {
    if (a == null && b == null && carry == 0) {
      return null;
    }
    AddResult r = addNodes(a, b, carry);
    return new LinkedNode(r.digit, addRecursive(a != null ? a.getNext() : null, b != null ? b.getNext() : null, r.carry));
  }

  private static LinkedNode reverse(LinkedNode list) {
    if (list == null) {
      return null;
    }
    LinkedNode head = new LinkedNode(list.getValue(), null);
    LinkedNode curr = list;
    while((curr = curr.getNext()) != null) {
      head = new LinkedNode(curr.getValue(), head);
    }
    return head;
  }

  public static LinkedNode addFollowUpA(LinkedNode a, LinkedNode b) {
    return reverse(addB(reverse(a), reverse(b)));
  }

  public static LinkedNode addFollowUpB(LinkedNode a, LinkedNode b) {
    // pad left zeros in to the shortest list
    if (a.size() > b.size()) {
      b = padZeros(b, a.size() - b.size());
    } else if (b.size() > a.size()) {
      a = padZeros(a, b.size() - a.size());
    }
    // both lists have the same size, now it's easy to add the nodes
    LinkedNode head = addFollowUpRecursive(a, b);
    if (head.getValue() >= 10) {
      head.setValue(head.getValue() % 10);
      head = new LinkedNode(1, head);
    }
    return head;    
  }

  private static LinkedNode padZeros(LinkedNode list, int n) {
    LinkedNode head = list;
    for (; n > 0; n--, head = new LinkedNode(0, head));
    return head;
  }

  private static LinkedNode addFollowUpRecursive(LinkedNode a, LinkedNode b) {
    if (a.getNext() == null && b.getNext() == null) {
      return new LinkedNode(a.getValue() + b.getValue());
    } 
    LinkedNode next = addFollowUpRecursive(a.getNext(), b.getNext());
    int carry = 0;
    if (next.getValue() >= 10) {
      next.setValue(next.getValue() % 10);
      carry = 1;
    }
    return new LinkedNode(a.getValue() + b.getValue() + carry, next);
  }
  
  public static void printAdd(LinkedNode a, LinkedNode b) {
    System.out.println("R. " + a + " + " + b + " = ");
    System.out.println(addA(a, b));
    System.out.println(addB(a, b));
  }

  public static void printAddFollowUp(LinkedNode a, LinkedNode b) {
    System.out.println("F. " + a + " + " + b + " = ");
    System.out.println(addFollowUpA(a, b));    
    System.out.println(addFollowUpB(a, b));    
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
    printAddFollowUp(new LinkedNode(1,2), new LinkedNode(7));
    printAddFollowUp(new LinkedNode(1,2,3,4,5,6), new LinkedNode(7));
    printAddFollowUp(new LinkedNode(7), new LinkedNode(1,2,3,4,5,6));
    printAddFollowUp(new LinkedNode(9,9), new LinkedNode(9,9));
  }   

  private static AddResult addNodes(LinkedNode a, LinkedNode b, int carry) {
    return new AddResult(a, b, carry);
  }

  private static class AddResult {
    
    public final int digit;

    public final int carry;

    AddResult(LinkedNode a, LinkedNode b, int c) {
      int v1 = a != null ? a.getValue() : 0;
      int v2 = b != null ? b.getValue() : 0;
      int r = v1 + v2 + c;
      carry = r / 10;
      digit = r % 10;      
    }
  }
}

