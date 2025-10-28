// Subset - II | Print all the Unique Subsets - Problem Statement : Given an array of integers that may contain duplicates the task is to return all possible subsets. Return only unique subsets and they can be in any order.
//                                              1) optimal - TC:O(2^N*k) SC:O(2^N*k)  Sort the array and use backtracking to generate all subsets while skipping duplicate elements at the same recursion level to ensure only unique subsets are added.

import java.util.*;
class R23{
    public static void subsetsum(int[] a, int n, int id, List<Integer> curr, List<List<Integer>> res){
        res.add(new ArrayList<>(curr));
        for(int i=id;i<n;i++){
            if(i!=id && a[i]==a[i-1]) continue;
            curr.add(a[i]);
            subsetsum(a, n, i+1, curr, res);
            curr.remove(curr.size()-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }

        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        Arrays.sort(a);
        subsetsum(a,n,0,curr,res);
        System.out.println(res);
    }
}