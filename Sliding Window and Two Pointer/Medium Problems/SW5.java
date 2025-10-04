// Binary subarray with sum - Problem Statement : You are given a binary array nums (containing only 0s and 1s) and an integer goal. Return the number of non-empty subarrays of nums that sum to goal. A subarray is a contiguous part of the array.
//                            1) brute force - TC:O(N^2) SC:O(1) Check all subarrays and count those with sum = k.
//                            2) better - TC:O(N) SC:O(N) Use prefix sum and a frequency map to count subarrays ending at each index with sum = k.
//                            3) optimal - TC:O(2N) SC:O(1) Count subarrays with sum ≤ k and subtract those with sum ≤ k-1 to get exactly sum = k.

import java.util.*;
class SW5{
    public static int binarysum(int[] a, int n, int k){
        int l=0,r=0,c=0,sum=0;
        while(r<n){
            sum+=a[r];
            while(sum>k){
                sum-=a[l];
                l++;
            }
            c+=(r-l+1);
            r++;
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int k=sc.nextInt();

        //brute force:
        // int c=0;
        // for(int i=0;i<n;i++){
        //     int sum=0;
        //     for(int j=i;j<n;j++){
        //         sum+=a[j];
        //         if(sum==k){
        //             c++;
        //         }
        //     }
        // }
        // System.out.println(c);


        //better:
        // HashMap<Integer,Integer> hm=new HashMap<>();
        // hm.put(0,1);
        // int psum=0;
        // int c=0;
        // for(int i=0;i<n;i++){
        //     psum+=a[i];
        //     int rem=psum-k;
        //     c+=hm.getOrDefault(rem, 0);
        //     hm.put(psum,hm.getOrDefault(psum, 0)+1);
        // }
        // System.out.println(c);

        
        //optimal:
        System.out.println(binarysum(a,n,k)-binarysum(a,n,k-1));
    }
}