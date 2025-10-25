package heap;

public class MinHeapHelper {
  public int getLeftChildIndex(int parentIndex) {
    return 2 * parentIndex + 1;
  }

  public int getRightChildIndex(int parentIndex) {
    return 2 * parentIndex + 2;
  }

  public int getParentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }

  public boolean hasParent(int index) {
    return getParentIndex(index) >= 0;
  }

  public boolean hasLeftChild(int index, int size) {
    return getLeftChildIndex(index) < size;
  }

  public boolean hasRightChild(int index, int size) {
    return getRightChildIndex(index) < size;
  }

  public int leftChild(int index, int[] items) {
    return items[getLeftChildIndex(index)];
  }

  public int rightChild(int index, int[] items) {
    return items[getRightChildIndex(index)];
  }

  public int parent(int index, int[] items) {
    return items[getParentIndex(index)];
  }
}
