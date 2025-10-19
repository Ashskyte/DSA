import java.util.Comparator;
import java.util.PriorityQueue;
import javafx.util.Pair;


public class KClosestNumbers {
    public static void main(String[] args){
        int []arr={5,6,7,8,9};
        int k=3;
        int x=8;
        findKClosestNumbers(arr,k,x);
    }

    private static void findKClosestNumbers(int[] arr, int k, int x) {
        PriorityQueue<Pair<Integer,Integer>> pq=new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
        for(int num:arr){
           pq.add(new Pair(Math.abs(num-x),num));
           if(pq.size()>k){
               pq.poll();
           }
        }
        pq.stream().map(Pair::getValue).forEach(System.out::println);
    }



}
