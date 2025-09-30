// Stock span problem - Problem Statement : Given an array arr of size n, where each element arr[i] represents the stock price on day i. Calculate the span of stock prices for each day.The span Sᵢ for a specific day i is defined as the maximum number of consecutive previous days (including the current day) for which the stock price was less than or equal to the price on day i.
//                      1) brute force - TC:O(n^2) SC:O(N) For each day, count consecutive previous days (including today) with stock prices less than or equal to the current day's price.


class StockSpan{
    public int[] Stock(int[] a, int n) {
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int current=0;
            for(int j=i;j>=0;j--){
                if(a[j]<=a[i]){
                    current++;
                }
                else{
                    break;
                }
            }
            ans[i]=current;
        }
        return ans;
    }
}
class SQ28{
    public static void main(String[] args) {
        int n = 7; 
        int[] arr = {120, 100, 60, 80, 90, 110, 115};
        StockSpan sol = new StockSpan(); 
        int[] ans = sol.Stock(arr, n);
        System.out.print("The span of stock prices is: ");
        for(int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}