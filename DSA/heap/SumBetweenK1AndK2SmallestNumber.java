import java.util.Comparator;
import java.util.PriorityQueue;

public class SumBetweenK1AndK2SmallestNumber {

    public static void main(String[] args){
        int[] arr={1,9,11,4,2,8,17};
        int k1=2;
        int k2=4;
        findSumBetweenK1AndK2SmallestNumber(arr,k1,k2);
    }
    
    private static PriorityQueue<Integer> findSmallestInKthPosition(int[] arr, int k1) {
        PriorityQueue<Integer> pq = makeHeap(arr);
        for(int i=0;i<k1-1;i++){
            pq.poll();
        }
        return pq;
    }

    private static PriorityQueue<Integer> makeHeap(int[] arr) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i = 0; i< arr.length; i++){
            pq.add(arr[i]);
        }
        return pq;
    }
    
    private static void findSumBetweenK1AndK2SmallestNumber(int[] arr, int k1, int k2) {
        PriorityQueue<Integer> firstPq=findSmallestInKthPosition(arr,k1);
        System.out.println("firstsmallest : " +firstPq.peek());
        System.out.println("result sum is :" +findSum(firstPq,k2-k1));
    }

    private static int findSum(PriorityQueue<Integer> firstPq, int k2) {
        int firstToIgnore=firstPq.poll();
        int res=0;

        for(int i=0;i<k2-1;i++){
            res+=firstPq.poll();
        }
        return res;
    }
}
