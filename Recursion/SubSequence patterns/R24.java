// Combination Sum III - Problem Statement : Determine all possible set of k numbers that can be added together to equal n while meeting the following requirements:
//                                           1. There is only use of numerals 1 through 9.
//                                           2. A single use is made of each number.
//                                           Return list of every feasible combination that is allowed. The combinations can be returned in any order, but the list cannot have the same combination twice.
//                       1) optimal - Backtrack through numbers 1 to 9, picking each number at most once, decreasing both sum n and count k until exactly k numbers form a sum equal to n.

import java.util.*;
class R24{
    public static void allcombinations(int n, int id, int k, List<Integer> curr, List<List<Integer>> res){
        if(k==0){
            if(n==0){
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        if(n<0 || k==0) return;
        for(int i=id;i<=9;i++){
            curr.add(i);
            allcombinations(n-i, i+1, k-1, curr, res);
            curr.remove(curr.size()-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        allcombinations(n,1,k,curr,res);
        System.out.println(res);
    }
}