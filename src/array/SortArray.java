package array;

public class SortArray {
  public static void main(String[] args) {
    //
    int[] arr = {1, 2, 3,4,4,6};
    int j = arr.length - 1;
    int mid = arr.length / 2;

    if (mid % 2 == 0) {
      for (int i = 0; i < mid; i++) {
        computation(arr, j, i);
      }
    } else {
      for (int i = 0; i <= mid - 1; i++) {
        computation(arr, j, i);
      }
    }

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  private static void computation(int[] arr, int j, int i) {
    int temp;
    temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    j--;
  }
}
