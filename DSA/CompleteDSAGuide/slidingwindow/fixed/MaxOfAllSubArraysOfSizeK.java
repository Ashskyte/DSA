package slidingwindow.fixed;

import java.util.ArrayList;
import java.util.List;

public class MaxOfAllSubArraysOfSizeK {
    public static void main(String[] args){
        int[] arr={-1,-1,3,-3,-9,-5,7,112,3,112,445,67};
        int k=3;
        printMaxOfAllSubArray(arr,k);
    }

    private static void printMaxOfAllSubArray(int[] arr, int k) {
        List<Integer> result=new ArrayList<>();

        int i=0;int j=0;
        int maxInWindow=Integer.MIN_VALUE;

        while (j<arr.length){
            if(arr[j]>maxInWindow){
                maxInWindow=arr[j];
            }
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                result.add(maxInWindow);
                if(arr[i]==maxInWindow){
                    maxInWindow=Integer.MIN_VALUE;
                }
                i++;
                j++;
            }


        }
        result.stream().forEach(System.out::println);
    }
}
