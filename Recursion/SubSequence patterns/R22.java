// Subset Sum : Sum of all Subsets - Problem Statement : Given an array print all the sum of the subset generated from it, in the increasing order.
//                                   1) optimal - TC:O(2^N) SC:O(2^N) Recursively explore all subsets by either taking or skipping each element, collect their sums, then sort and print them.

import java.util.*;
class R22{
    public static void subsetsum(int[] a, int n, int id, int sum, List<Integer> res){
        if(id==n){
            res.add(sum);
            return;
        }
        subsetsum(a, n, id+1, sum+a[id], res);
        subsetsum(a, n, id+1, sum, res);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }

        List<Integer> res=new ArrayList<>();
        subsetsum(a,n,0,0,res);
        Collections.sort(res);
        System.out.println(res);
    }
}