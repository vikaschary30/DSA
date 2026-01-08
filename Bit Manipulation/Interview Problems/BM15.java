// Power Set | Bit Manipulation - Problem Statement : Given an array of numbers, print all subsets of it using bitwise operators.

import java.util.*;
class BM15{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        List<List<Integer>> res=new ArrayList<>();
        int subsets=1<<n;
        for(int i=0;i<subsets;i++){
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=0){
                    temp.add(a[j]);
                }
            }
            res.add(temp);
        }
        System.out.println(res);
    }
}