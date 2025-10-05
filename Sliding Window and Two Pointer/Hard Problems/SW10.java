// Subarray with k different integers - Problem Statement : You are given an integer array nums and an integer k. Return the number of good subarrays of nums.A good subarray is defined as a contiguous subarray of nums that contains exactly k distinct integers. A subarray is a contiguous part of the array.
//                                      1) brute force - TC:O(N^2) SC:O(N) For each starting index, expand the subarray to the right while tracking distinct elements in a set, increment the count when exactly k distinct integers are found, and break if it exceeds k.
//                                      2) optimal - TC:O(N) SC:O(N) Count subarrays with at most k distinct integers using a sliding window and HashMap, then subtract the count of subarrays with at most k-1 distinct integers; the difference gives the number of subarrays with exactly k distinct integers.

import java.util.*;
class SW10{
    public static int subarrayk(int[] a, int n, int k){
        int l=0,r=0,c=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        while(r<n){
            hm.put(a[r],hm.getOrDefault(a[r], 0)+1);
            while(hm.size()>k){
                hm.put(a[l],hm.get(a[l])-1);
                if(hm.get(a[l])==0){
                    hm.remove(a[l]);
                }
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
        //     HashSet<Integer> hs=new HashSet<>();
        //     for(int j=i;j<n;j++){
        //         hs.add(a[j]);
        //         if(hs.size()==k){
        //             c++;
        //         }
        //         if(hs.size()>k){
        //             break;
        //         }
        //     }
        // }
        // System.out.println(c);

        
        //optimal:
        System.out.println(subarrayk(a,n,k)-subarrayk(a,n,k-1));
    }
}