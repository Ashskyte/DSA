package array;

public class Sort_0_1_2 {
  public static void main(String[] args) {
    int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
    int low = 0;
    int mid = 0;
    int high = arr.length - 1;

    while (mid <= high) {
      switch (arr[mid]) {
        case 0:
          {
            int temp = 0;
            temp = arr[low];
            arr[low] = arr[mid];
            arr[mid] = temp;
            low++;
            mid++;
            break;
          }
        case 1:
          {
            mid++;
            break;
          }
        case 2:
          {
            int temp = arr[mid];
            arr[mid] = arr[high];
            arr[high] = temp;
            high--;
            break;
          }
      }
    }
   for(int i=0;i<arr.length;i++){
      System.out.print(arr[i]);
   }
  }
}
