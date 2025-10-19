package array;

public class RainWaterTrapping {
  public static void main(String[] args) {
    int[] arr = {3, 0, 2, 0, 4};

    int[] maxArrLeft = maxArrayLeft(arr);
    int[] maxArrRight = maxArrayRight(arr);
    findTrappedwater(maxArrLeft, maxArrRight, arr);
    /*for (int j : maxArrLeft) {
      System.out.print(j + " ");
    }
    System.out.println();
    System.out.println("right array max");

    for(int k:maxArrRight){
      System.out.print(k+" ");
    }*/
  }

  private static void findTrappedwater(int[] maxArrLeft, int[] maxArrRight, int[] arr) {
    int[] water = new int[arr.length];
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      water[i] = Math.min(maxArrLeft[i], maxArrRight[i]) - arr[i];
    }

    for (int k = 0; k < water.length; k++) {
      sum += arr[k];
    }
    System.out.println();
    System.out.println("trapped water unit is " + sum);
  }

  private static int[] maxArrayRight(int[] arr) {
    int length = arr.length;
    int[] maxArrRight = new int[length];
    maxArrRight[length - 1] = arr[length - 1];
    for (int i = length - 2; i >= 0; i--) {
      if (arr[i] > maxArrRight[i + 1]) {
        maxArrRight[i] = arr[i];

      } else {
        maxArrRight[i] = maxArrRight[i + 1];
      }
    }
    return maxArrRight;
  }

  private static int[] maxArrayLeft(int[] arr) {
    int[] maxArrLeft = new int[arr.length];
    maxArrLeft[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > maxArrLeft[i - 1]) {
        maxArrLeft[i] = arr[i];
      } else {
        maxArrLeft[i] = maxArrLeft[i - 1];
      }
    }
    return maxArrLeft;
  }
}
