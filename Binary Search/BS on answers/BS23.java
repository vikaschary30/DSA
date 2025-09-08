// Split Array Largest Sum - Problem Statement : Given an integer array ‘A’ of size ‘N’ and an integer ‘K'. Split the array ‘A’ into ‘K’ non-empty subarrays such that the largest sum of any subarray is minimized. Your task is to return the minimized largest sum of the split.
//                                               A subarray is a contiguous part of the array.
//                           1) brute force -  TC:O((sum-max)*n) Try every possible max subarray sum from max(arr) to sum(arr) and pick the smallest that allows ≤ k partitions.
//                           2) optimal -  TC:O(log(sum-max)*n) Use binary search between max(arr) and sum(arr) to find the minimum largest subarray sum for ≤ k partitions.


import java.util.*;
class BS23{
    public static int noofpartitions(int[] a, int maxsum, int n, int k){
        int csum=0, part=1;
        for(int i=0;i<n;i++){
            if(a[i]+csum<=maxsum){
                csum+=a[i];
            }
            else{
                part++;
                csum=a[i];
            }
        } 
        return part;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            max=Math.max(a[i], max);
            sum+=a[i];
        }
        int k=sc.nextInt();

        //brute force
        // int ans=max;
        // for(int i=max;i<=sum;i++){
        //     int part=noofpartitions(a,i,n,k);
        //     if(part<=k){
        //         ans=i;
        //         break;
        //     }
        // }
        // System.out.println(ans);

        // optimal
        // int ans=0;
        int low=max, high=sum;
        while(low<=high){
            int mid=(low+high)/2;
            int part=noofpartitions(a, mid, n, k);
            if(part<=k){
                // ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }   
        System.out.println(low);    
    }
}