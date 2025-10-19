package array;

public class MaxMinArray {
  public static void main(String[] args) {
    int[] arr={1,-3,4,62,0,5,7};
    int max=Integer.MIN_VALUE;
    int min=Integer.MAX_VALUE;
    sortArrayIn_N_Complexity(arr, max, min);
  }

  private static void sortArrayIn_N_Complexity(int[] arr, int max, int min) {
    for(int i = 0; i< arr.length; i++){
        if(arr[i]< min){
          min = arr[i];
        }
        else if(arr[i]> max){
          max = arr[i];
        }
    }
    System.out.println("max is "+max +", min is "+min );
  }
}
