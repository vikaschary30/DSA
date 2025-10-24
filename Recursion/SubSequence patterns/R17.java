// Count all subsequences with sum K - Problem Statement : Given an array nums and an integer k.Return the number of non-empty subsequences of nums such that the sum of all elements in the subsequence is equal to k.
//                                     1) optimal - TC:O(2^N) SC:O(N) Recursively generate all pick/not-pick subsequences and store those whose running sum equals k.

import java.util.*;
class R17{
    public static void subsequenceswithk(int[] a, int n, int i, int sum, int k, List<Integer> curr, List<List<Integer>> res){
        if(i==n){
            if(sum==k){
                res.add(new ArrayList<>(curr));
                return;
            }
            return;
        }
        curr.add(a[i]);
        sum+=a[i];
        subsequenceswithk(a, n, i+1, sum, k, curr, res);
        curr.remove(curr.size()-1);
        sum-=a[i];
        subsequenceswithk(a, n, i+1, sum, k, curr, res);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        int k=sc.nextInt();

        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        subsequenceswithk(a,n,0,0,k,curr,res);
        System.out.println(res);
    }
}