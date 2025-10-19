package array;

public class MergeTwoSortedArrays {
  public static void main(String[] args) {
    int[] arr1 = {1, 5, 6, 8};
    int[] arr2 = {3, 7, 9, 10, 34};
    // todo o/p ={1,3,5,6,7,8,9,10,34}
    merge(arr1, arr2);
  }

  private static void merge(int[] arr1, int[] arr2) {
    int len = arr1.length + arr2.length;
    int i = 0;
    int j = 0;
    int k = 0;
    int[] arr3 = new int[len];
    while (i < arr1.length && j < arr2.length) {
      if (arr1[i] < arr2[j]) {
        arr3[k] = arr1[i];
        i++;
      } else {
        arr3[k] = arr2[j];
        j++;
      }
      k++;
    }
    while (i < arr1.length) {
      arr3[k] = arr1[i];
      i++;
      k++;
    }
    while (j < arr2.length) {
      arr3[k] = arr2[j];
      j++;
      k++;
    }
    for (Integer temp : arr3) {
      System.out.print(temp + " ");
    }
  }
}
