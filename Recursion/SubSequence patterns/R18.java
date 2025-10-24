// Check if there exists subsequences with sum K - Problem Statement : Given an array nums and an integer k. Return true if there exist subsequences such that the sum of all elements in subsequences is equal to k else false.
//                                     1) optimal - TC:O(2^N) SC:O(N) Recursively explore pick/not-pick subsequences and return true as soon as any subsequence reaches sum k.

import java.util.*;
class R18{
    public static boolean subsequenceswithk(int[] a, int n, int i, int sum, int k, List<Integer> curr){
        if(i==n){
            if(sum==k){
                return true;
            }
            return false;
        }
        curr.add(a[i]);
        sum+=a[i];
        if(subsequenceswithk(a, n, i+1, sum, k, curr)==true){
            return true;
        }
        curr.remove(curr.size()-1);
        sum-=a[i];
        if(subsequenceswithk(a, n, i+1, sum, k, curr)==true){
            return true;
        }
        return false;
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