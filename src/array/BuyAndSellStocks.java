package array;

public class BuyAndSellStocks {
  public static void main(String[] args) {
    int[] arr={100, 180, 260, 310, 200, 535, 695};
    fetchMaxProfitBySellingStocks(arr);
  }

    private static void fetchMaxProfitBySellingStocks(int[] arr) {
      int minSoFar=arr[0];
      int maxProfit=Integer.MIN_VALUE;

      for(int i=0;i<arr.length;i++){
          if(arr[i]<minSoFar){
              minSoFar=arr[i];
          }
          if(arr[i]-minSoFar>maxProfit){
              maxProfit=arr[i]-minSoFar;
          }
      }
    System.out.println(maxProfit);
    }
}
