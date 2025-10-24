// Count all subsequences with sum K - Problem Statement :  Given an array nums and an integer k.Return the number of non-empty subsequences of nums such that the sum of all elements in the subsequence is equal to k.
//                                     1) optimal - TC:O(2^N) SC:O(N) Use recursion with pick/not-pick choices to count how many subsequences have sum equal to k.

import java.util.*;
class R19{
    public static int subsequenceswithk(int[] a, int n, int i, int sum, int k, List<Integer> curr){
        if(i==n){
            if(sum==k){
                return 1;
            }
            return 0;
        }
        curr.add(a[i]);
        sum+=a[i];
        int l=subsequenceswithk(a, n, i+1, sum, k, curr);
        curr.remove(curr.size()-1);
        sum-=a[i];
        int r=subsequenceswithk(a, n, i+1, sum, k, curr);
        return l+r;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        int k=sc.nextInt();

        List<Integer> curr=new ArrayList<>();
        System.out.println(subsequenceswithk(a,n,0,0,k,curr));
    }
}