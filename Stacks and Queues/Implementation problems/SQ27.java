// Sliding Window Maximum - Problem Statement : Given an array of integers arr, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
//                          1) brute force - TC:O(n*k) SC:O(n-k+1) For each window of size k, iterate through all k elements to find the maximum, giving O(n·k) time.
//                          2) optimal - TC:O(n) SC:O(k) Maintain a decreasing deque of indices, popping out-of-window and smaller elements, so the front always holds the maximum of the current window in O(n) time.


import java.util.*;
class SQ27{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        List<Integer> res=new ArrayList<>();


        //brute froce:
        // for(int i=0;i<=n-k;i++){
        //     int max=a[i];
        //     for(int j=i;j<i+k;j++){
        //         max=Math.max(max,a[j]);
        //     }
        //     res.add(max);
        // }
        // System.out.println(res);

        
        //optimal:
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.peek()==i-k){
                dq.poll();
            }
            while(!dq.isEmpty() && a[dq.peekLast()]<a[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1){
                res.add(a[dq.peek()]);
            }
        }
        System.out.println(res);
    }
}