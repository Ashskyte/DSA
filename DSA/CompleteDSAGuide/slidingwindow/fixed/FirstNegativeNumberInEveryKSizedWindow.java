package slidingwindow.fixed;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeNumberInEveryKSizedWindow {
    public static void main(String[] args){
        int[] arr={12,-1,-7,8,-15,30,16,23};
        int k=3;
        findFirstNegative(arr,k);
    }

    private static void findFirstNegative(int[] arr, int k) {
        int i=0;int j=0;
        List<Integer> negativeList=new ArrayList<>();

        while(j<arr.length){
            if(arr[j]<0){
                negativeList.add(arr[j]);
            }
            if(j-i+1<k){
                j++;
            }
            else if((j-i+1)==k){
                if(!negativeList.isEmpty()){
                    System.out.print(negativeList.get(0) +" ");
                    if(arr[i]==negativeList.get(0)){
                        negativeList.remove(0);
                    }

                }
                else{
                    System.out.println("0" + " ");
                }
                i++;
                j++;
            }
        }
    }
}
