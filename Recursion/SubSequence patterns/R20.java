// Combination Sum 1 - Problem Statement : Given an array of distinct integers and a target, you have to return the list of all unique combinations where the chosen numbers sum to target. You may return the combinations in any order.The same number may be chosen from the given array an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input. 
//                     1) optimal - TC:O(2^k*c) SC:O(k*c) (c=no of combinations) It tries to include the current element (staying at same index for unlimited reuse) or skip it (move to next index), and whenever the running sum hits zero at the end, that built list is stored in the result.

import java.util.*;
class R20{
    public static void combinations(int[] a, int n, int k, int i, List<Integer> curr, List<List<Integer>> res){
        if(i==n){
            if(k==0){
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        if(a[i]<=k){
            curr.add(a[i]);
            combinations(a, n, k-a[i], i, curr, res);
            curr.remove(curr.size()-1);
        }
        combinations(a, n, k, i+1, curr, res);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        int k=sc.nextInt();

        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        combinations(a,n,k,0,curr,res);
        System.out.println(res);
    }
}