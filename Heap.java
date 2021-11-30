import java.util.Arrays;

public class MaxHeap extends Heap {
  @Override
  protected boolean checkItems(int indexA, int indexB) {
    return items[indexA] > items[indexB];
  }
}

public class MinHeap extends Heap {
  @Override
  protected boolean checkItems(int indexA, int indexB) {
    return items[indexA] < items[indexB];
  }
}

public abstract class Heap {
  private final int INITIAL_CAPACITY = 2;
  int size = 0;
  int[] items = new int[INITIAL_CAPACITY];
  
  public int size() { return size; }
  
  public boolean isEmpty() { return size() == 0; }

  private int parentIndex(int index) { return (index-1)/2; }
    
  private int leftIndex(int index) { return index*2 + 1; }
  
  private int rightIndex(int index) { return index*2 + 2; }
  
  private boolean hasParent(int index) { return parentIndex(index) >= 0; }
  
  private boolean hasLeft(int index) { return leftIndex(index) < size; }

  private boolean hasRight(int index) { return rightIndex(index) < size; }

  public int peek() {
    if (size==0) { throw new IllegalArgumentException(); }
    return items[0];
  }

  public void add(int item) {
    ensureCapacity();
    items[size] = item;
    size++;
    heapifyUp();
  }

  public int poll() {
    if (size==0) { throw new IllegalArgumentException(); }
    int item = items[0];
    size--;
    heapifyDown();
    return item;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
      sb.append(i  +". " + items[i]);
      if(i < size-1) {
        sb.append(", ");
      }
    }
    return sb.toString();
  }

  protected abstract boolean checkItems(int indexA, int indexB);
    
  private void heapifyUp() {
    int index = size-1;
    while(hasParent(index) && checkItems(index, parentIndex(index))) {
      swap(items, parentIndex(index), index);
      index = parentIndex(index);
    }
  }

  private void heapifyDown() {
    if (size == 0) { return; }
    int index = 0;
    items[index] = items[size];
    while(hasLeft(index)) {
      int currIndex = leftIndex(index);
      if (hasRight(index) && checkItems(rightIndex(index), currIndex)) {
        currIndex = rightIndex(index);
      }
      if (checkItems(index, currIndex)) {
        break;
      }
      swap(items, currIndex, index);
      index = currIndex;
    }
  }

  private void swap(int[] array, int indexA, int indexB) {
    int tmp = array[indexA];
    array[indexA] = array[indexB];
    array[indexB] = tmp;
  }

  private void ensureCapacity() {
    if (size == items.length) {
      items = Arrays.copyOf(items, 2*items.length);
    }    
  }

}

class HeapMain {
  private static void minheap() {
    MinHeap mh = new MinHeap();
    mh.add(20);
    mh.add(25);
    mh.add(30);
    mh.add(35);
    mh.add(12);
    mh.add(1);
    mh.add(9);
    System.out.println(mh);
    while (mh.size() > 0) {
      int item = mh.poll();
      System.out.println(item);
      System.out.println(mh);
    }    
  }

  private static void maxheap() {
    MaxHeap mh = new MaxHeap();
    mh.add(20);
    mh.add(25);
    mh.add(30);
    mh.add(35);
    mh.add(12);
    mh.add(1);
    mh.add(9);
    System.out.println(mh);
    while (mh.size() > 0) {
      int item = mh.poll();
      System.out.println(item);
      System.out.println(mh);
    }    
  }

  public static void main(String[] args) {
    System.out.println("MinHeap");
    minheap();  
    System.out.println("MaxHeap");
    maxheap();  
  }
}