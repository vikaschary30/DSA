// Count number of nice subarrays - Problem Statement : Given an array nums and an integer k. An array is called nice if and only if it contains k odd numbers. Find the number of nice subarrays in the given array nums. A subarray is continuous part of the array.
//                                  1) brute force - TC:O(N^2) SC:O(1) Check every possible subarray and count those that contain exactly k odd numbers.
//                                  2) better - TC:O(N) SC:O(N) Use prefix sums and a hashmap to track counts of odd numbers seen so far, adding up subarrays that end at each index with exactly k odds.
//                                  3) optimal - TC:O(2N) SC:O(1) It counts subarrays with exactly k odd numbers by calculating the difference between the number of subarrays with at most k odds and at most k-1 odds.

import java.util.*;
class SW6{
    public static int binarysum(int[] a, int n, int k){
        if(k<0) return 0;
        int l=0,r=0,c=0,sum=0;
        while(r<n){
            sum+=a[r]%2;
            while(sum>k){
                sum-=a[l]%2;
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
        //         sum+=a[j]%2;
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
        //     psum+=a[i]%2;
        //     int rem=psum-k;
        //     c+=hm.getOrDefault(rem, 0);
        //     hm.put(psum,hm.getOrDefault(psum, 0)+1);
        // }
        // System.out.println(c);

        
        //optimal:
        System.out.println(binarysum(a,n,k)-binarysum(a,n,k-1));
    }
}