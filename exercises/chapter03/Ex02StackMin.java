package exercises.chapter03;

import datastructures.Stack;

public class Ex02StackMin {

  private static class StackMin<T extends Comparable<T>> {
    
    Stack<T> vals = new Stack<>();
    Stack<T> mins = new Stack<>();

    public void push(T value) {
      vals.push(value);
      if (mins.isEmpty() || value.compareTo(mins.peek()) <= 0) {
        mins.push(value);
      }
    }

    public T pop() {
      if (vals.peek() == mins.peek()) {
        mins.pop(); 
      }
      return vals.pop();      
    }

    public T min() {
      return mins.peek();
    }

  }

} 