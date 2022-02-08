package exercises.chapter03;

import datastructures.Stack;
import java.util.List;
import java.util.ArrayList;

public class Ex03SetOfStacks {

  public static class SetOfStacks<T> {
    
    private Stack<Stack<T>> stacks = new Stack<>();

    private int threshold;

    public SetOfStacks(int threshold) {
      this.threshold = threshold;
    }

    public void push(T value) {
      if (stacks.isEmpty() || stacks.peek().size() == threshold) {
        stacks.push(new Stack<>());
      }
      stacks.peek().push(value);
    } 

    public T pop() {
      T value = stacks.peek().pop();
      if (stacks.peek().isEmpty()) {
        stacks.pop();
      }  
      return value;
    }

    public T peek() {
      return stacks.peek().peek();
    }

    public int size() {
      return stacks.size();
    }

    @Override
    public String toString() {
      return stacks.toString();
    }

  }

  public static class SetOfStacks2<T> {
    
    private List<Stack<T>> stacks = new ArrayList<>();

    private int threshold;

    public SetOfStacks2(int threshold) {
      this.threshold = threshold;
    }

    private Stack<T> last() {
      return stacks.get(stacks.size()-1);
    }

    public void push(T value) {
      if (stacks.isEmpty() || last().size() == threshold) {
        stacks.add(new Stack<>());
      }
      last().push(value);
    } 

    public T pop() {
      T value = last().pop();
      if (last().isEmpty()) {
        stacks.remove(stacks.size()-1);
      }  
      return value;
    }

    public T peek() {
      return last().peek();
    }

    public int size() {
      return stacks.size();
    }

    private void recursivePopPush(int lastIndex) {
      if (size()-1 == lastIndex) {
        return;
      }
      T value = pop();
      recursivePopPush(lastIndex);
      push(value);
    }

    public T popAt(int index) {
      T value = stacks.get(index).pop();
      recursivePopPush(index);
      return value;
    }

    @Override
    public String toString() {
      return stacks.toString();
    }

  }

}