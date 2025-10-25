package slidingwindow.fixed;

public class MaxSumSubArrayOfSizeK {
    public static void main(String[] args){
        int [] arr={1,4,2,3,4,5,6,3,4,5};
        findMaxSumSubArrayOfSizeK(arr,0);
    }

    private static void findMaxSumSubArrayOfSizeK(int[] arr, int k) {
        int currentSum=0;
        int maxSum=Integer.MIN_VALUE;
        System.out.println(maxSum);
        int i=0;
        int j=0;
        if(k<=0){
            System.out.println("please provide positive value of integer k and must be greater than 0");
            return;
        }
        while(j<arr.length){
            currentSum+=arr[j];

            if((j-i+1)<k){
                j++;
            }
            else if((j-i+1)==k){
                maxSum=Math.max(currentSum,maxSum);
                currentSum=currentSum-arr[i];
                i++;
                j++;
            }
        }
        System.out.println("Max sum subarray of size : " +k +" is : " +maxSum);

    }
}
