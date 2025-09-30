
import java.util.Stack;

// Stock span problem - Problem Statement : Given an array arr of size n, where each element arr[i] represents the stock price on day i. Calculate the span of stock prices for each day.The span Sᵢ for a specific day i is defined as the maximum number of consecutive previous days (including the current day) for which the stock price was less than or equal to the price on day i.
//                      1) brute force - TC:O(N^2) SC:O(N) For each day, count consecutive previous days (including today) with stock prices less than or equal to the current day's price.
//                      2) optimal - TC:O(N) SC:O(N) Use a stack to track indices of previous greater elements; for each day, the span is the distance from the current index to the index of the previous greater element, giving O(n) time and O(n) space.


//brute force:
// class StockSpan{
//     public int[] Stock(int[] a, int n) {
//         int[] ans=new int[n];
//         for(int i=0;i<n;i++){
//             int current=0;
//             for(int j=i;j>=0;j--){
//                 if(a[j]<=a[i]){
//                     current++;
//                 }
//                 else{
//                     break;
//                 }
//             }
//             ans[i]=current;
//         }
//         return ans;
//     }
// }


// optimal :
class StockSpan{
    public int[] findpge(int[] a, int n){
        int[] pge=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && a[st.peek()]<=a[i]){
                st.pop();
            }
            pge[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pge;
    }
    public int[] Stock(int[] a, int n){
        int[] pge=findpge(a,n);
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=i-pge[i];
        }
        return res;
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