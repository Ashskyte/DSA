package array;

public class NegativeElementsFront {
  public static void main(String[] args) {
    int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
    int j = arr.length - 1;

    int i = 0;

    while (i < j) {
      if (arr[i] < 0 && arr[j] < 0) {
        i++;

      } else if (arr[i] < 0 && arr[j] > 0) {
        i++;
        j--;
      } else if (arr[i] > 0 && arr[j] < 0) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
      } else if (arr[i] > 0 && arr[j] > 0) {
        j--;
      }
    }
    for (int k = 0; k < arr.length; k++) {
      System.out.print(arr[k] + " , ");
    }
  }
}
