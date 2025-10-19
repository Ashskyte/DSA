import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPairsFromOrigin {
    public static void main(String[] args){
        int[][]arr= {{1,3},{-2,2},{5,-1},{3,2},{1,1}};
        int k=3;
        printKClosestPairsFromOrigin(arr,k);

    }

    private static void printKClosestPairsFromOrigin(int[][] arr, int k) {
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq =
                new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        for(int i=0;i<arr.length;i++){
            int[] points=arr[i];

            int distanceFromOrigin=points[0]*points[0]+points[1]*points[1];

            pq.add(new Pair(distanceFromOrigin,new Pair(points[0],points[1])));
            if(pq.size()>k){
                pq.poll();
            }


        }

        pq.stream().map(s->s.getValue()).forEach(System.out::println);

    }
}
