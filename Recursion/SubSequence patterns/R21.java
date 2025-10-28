// Combination Sum II - Find all unique combinations - Problem Statement : Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target. Each number in candidates may only be used once in the combination.
//                                                                         Note: The solution set must not contain duplicate combinations.
//                                                     1) optimal - TC:O(2^N+NLogN) SC:O(N) Sort the array and use backtracking to try each element at most once, skipping duplicates at the same level and stopping when the sum reaches target.

import java.util.*;
class R21{
    public static void allcombinations(int[] a, int n, int id, int k, List<Integer> curr, List<List<Integer>> res){
        if(k==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=id;i<n;i++){
            if(i>id && a[i]==a[i-1]) continue;
            if(a[i]>k) break;
            curr.add(a[i]);
            allcombinations(a, n, i+1, k-a[i], curr, res);
            curr.remove(curr.size()-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        int k=sc.nextInt();

        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        Arrays.sort(a);
        allcombinations(a,n,0,k,curr,res);
        System.out.println(res);
    }
}