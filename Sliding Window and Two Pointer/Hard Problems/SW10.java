// Subarray with k different integers - Problem Statement : You are given an integer array nums and an integer k. Return the number of good subarrays of nums.A good subarray is defined as a contiguous subarray of nums that contains exactly k distinct integers. A subarray is a contiguous part of the array.
//                                      1) brute force - TC:O(N^2) SC:O(N) For each starting index, expand the subarray to the right while tracking distinct elements in a set, increment the count when exactly k distinct integers are found, and break if it exceeds k.

import java.util.*;
class SW10{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int k=sc.nextInt();

        //brute force:
        int c=0;
        for(int i=0;i<n;i++){
            HashSet<Integer> hs=new HashSet<>();
            for(int j=i;j<n;j++){
                hs.add(a[j]);
                if(hs.size()==k){
                    c++;
                }
                if(hs.size()>k){
                    break;
                }
            }
        }
        System.out.println(c);
    }
}