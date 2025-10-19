
import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap {
  MinHeapHelper minHeapHelper = new MinHeapHelper();
  private int capacity = 10;
  int[] items = new int[capacity];
  private int size = 0;

  public static void main(String[] args) {
    MinHeap m = new MinHeap();
    m.add(1);
    m.add(5);
    m.add(3);
    m.add(6);
    m.add(7);
    int count = 0;
    while (count < 2) {
      m.poll();
      count++;
    }
    System.out.println("3rd smallest element is " + m.peek());
  }
  private int peek() {
    if (size == 0) {
      throw new NoSuchElementException("heap does not have enough elements present");
    }
    return items[0];
  }

  private void swap(int indexOne, int indexTwo) {
    int temp = items[indexOne];
    items[indexOne] = items[indexTwo];
    items[indexTwo] = temp;
  }

  private void ensureCapacity() {
    if (size == capacity) {
      items = Arrays.copyOf(items, capacity * 2);
      capacity *= 2;
    }
  }

  private int poll() {
    int minimum = items[0];
    items[0] = items[size - 1];
    size--;
    heapifyDown();
    return minimum;
  }

  private void heapifyDown() {
    int index = 0;

    while (minHeapHelper.hasLeftChild(index, size)) {

      int smallerIndex = minHeapHelper.getLeftChildIndex(index);
      if (minHeapHelper.leftChild(index, items) > minHeapHelper.rightChild(index, items)) {
        smallerIndex = minHeapHelper.getRightChildIndex(index);
      }
      if (items[index] < items[smallerIndex]) {
        break;
      } else {
        swap(index, smallerIndex);
      }
      index = smallerIndex;
    }
  }

  private void add(int item) {
    ensureCapacity();
    items[size] = item;
    size++;
    heapifyUp();
  }

  private void heapifyUp() {
    int index = size - 1;
    while (minHeapHelper.hasParent(index) && items[index] < minHeapHelper.parent(index, items)) {
      swap(index, minHeapHelper.getParentIndex(index));
      index = minHeapHelper.getParentIndex(index);
    }
  }
}
