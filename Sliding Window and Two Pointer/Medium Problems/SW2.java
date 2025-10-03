// Max Consecutive Ones III - Problem Statement : Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
//                            1) brute force - TC:O(N^2) SC:O(1) Try every subarray, count zeros, and record the longest one with ≤ k zeros.
//                            2) better - TC:O(2N) SC:O(1) Use sliding window with two pointers, shrink from left until zeros ≤ k, then update max length.
//                            3) optimal - TC:O(N) SC:O(1) Same sliding window but tighter — continuously expand right and shrink left while zeros > k to always maintain a valid window.


import java.util.*;
class SW2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int k=sc.nextInt();

        //brute force:
        // int max=Integer.MIN_VALUE;
        // for(int i=0;i<n;i++){
        //     int zeroes=0;
        //     for(int j=i;j<n;j++){
        //         if(a[j]==0){
        //             zeroes++;
        //         }
        //         if(zeroes>k){
        //             break;
        //         }
        //         max=Math.max(max,j-i+1);
        //     }
        // }
        // System.out.println(max);


        // better :
        // int max=Integer.MIN_VALUE;
        // int l=0,r=0;
        // int zeroes=0;
        // while(r<n){
        //     if(a[r]==0) zeroes++;
        //     while(zeroes>k){
        //         if(a[l]==0) zeroes--;
        //         l++;
        //     }
        //     if(zeroes<=k){
        //         max=Math.max(max, r-l+1);
        //     }
        //     r++;
        // }
        // System.out.println(max);


        //optimal:
        int max=Integer.MIN_VALUE;
        int l=0,r=0;
        int zeroes=0;
        while(r<n){
            if(a[r]==0) zeroes++;
            if(zeroes>k){
                if(a[l]==0) zeroes--;
                l++;
            }
            if(zeroes<=k){
                max=Math.max(max, r-l+1);
            }
            r++;
        }
        System.out.println(max);
    }
}