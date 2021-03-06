package exercises;

import datastructures.Heap;
import java.util.Scanner;

public class KeepTrackMedianRandomNumbers {

  public static void main(String[] args) {
    
    Heap minHeap = Heap.minHeap();
    Heap maxHeap = Heap.maxHeap();
   
    Scanner input = new Scanner( System.in );
    while (true) {
      if (!minHeap.isEmpty() || !maxHeap.isEmpty()) {
        System.out.println("min = " + minHeap);
        System.out.println("max = " + maxHeap); 
        double median;
        if(minHeap.size() == maxHeap.size()) {
          median = (minHeap.peek() + maxHeap.peek())/2.0;
        } else {
          median = minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek(); 
        }
        System.out.println("Current median: " + median);  
      }

      System.out.print("Enter a number: ");
      int value = input.nextInt();
      
      if (minHeap.isEmpty()) {
        minHeap.add(value);
        continue;
      }

      if (value > minHeap.peek()) {
        minHeap.add(value);
        if (minHeap.size() == maxHeap.size() + 2) {
          maxHeap.add(minHeap.poll());
        }
      } else {
        maxHeap.add(value);
        if (maxHeap.size() == minHeap.size() + 2) {
          minHeap.add(maxHeap.poll());
        }
      }
    }
  }
}