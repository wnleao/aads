package exercises.chapter03;

import datastructures.Stack;
import java.util.Comparator;

public class Ex05SortStack {

  private static <T extends Comparable<T>> void sort(Stack<T> stack) {
    Stack<T> tmp = new Stack<>();
    while (!stack.isEmpty()) {
      pushOrdered(stack.pop(), tmp, false);
    }
    while (!tmp.isEmpty()) {
      stack.push(tmp.pop());
    }
  }

  private static <T extends Comparable<T>> void sortR(Stack<T> stack) {
    if (stack.isEmpty()) {
      return;
    }
    T value = stack.pop();
    sortR(stack);
    pushOrdered(value, stack, true);    
  }

  private static <T extends Comparable<T>> void pushOrdered(T value, Stack<T> tmp, boolean ascending) {
    if (tmp.isEmpty() || compareOrEqual(tmp.peek(), value, ascending)) {
      tmp.push(value);
      return;
    }
    T curr = tmp.pop();
    pushOrdered(value, tmp, ascending);
    tmp.push(curr);
  }

  private static <T extends Comparable<T>> boolean compareOrEqual(T v1, T v2, boolean greater) {
    return greater ? v1.compareTo(v2) >= 0 : v1.compareTo(v2) <= 0;
  }

  public static void main(String[] args) {
    Stack<Integer> stackA = new Stack<>();
    stackA.push(10, 30, 20, 50, 40, 60, 70, 90, 80);

    Stack<Integer> stackB = new Stack<>();
    stackB.push(10, 30, 20, 50, 40, 60, 70, 90, 80);
    
    System.out.println("before = " + stackA);    
    sort(stackA);
    System.out.println("after  = " + stackA);

    System.out.println("before = " + stackB);    
    sortR(stackB);
    System.out.println("after  = " + stackB);
  }

}
