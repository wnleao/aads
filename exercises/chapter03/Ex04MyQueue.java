package exercises.chapter03;

import datastructures.Stack;

public class Ex04MyQueue {
  
  public static class MyQueue<T> {

    private Stack<T> main = new Stack<>();
    private Stack<T> back = new Stack<>();

    public T remove() {
      return main.pop();
    }    

    public void add(T value) {
      while(!main.isEmpty()) {
        back.push(main.pop());
      }
      main.push(value);
      while(!back.isEmpty()) {
        main.push(back.pop());
      }
    }

    public T peek() {
      return main.peek();
    }

    @Override
    public String toString() {
      return main.toString();
    }

  }

}