package array;

import static array.arrayReverse.reverse;

public class CyclicRotateArray {
  /* reversal algorithm*/
  /*make two parts of array  (arrLength-k) called A and (k) as B
  reverse A and B
  reverse whole array AB*/
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    int k = 2;
    reverseFirst(arr, arr.length - k);
    reverseSecond(arr, k);
  }

  private static void reverseFirst(int[] arr, int n) {
    reverse(arr, n);
  }

  private static void reverseSecond(int[] arr, int k) {
    {
      int i, t;
      for (i = arr.length - k; i < k / 2; i++) {
        t = arr[i];
        arr[i] = arr[k - i - 1];
        arr[k - i - 1] = t;
      }
    }
    for(int l=0;l<arr.length;l++){
      System.out.println(arr[l]);
    }
  }
}
