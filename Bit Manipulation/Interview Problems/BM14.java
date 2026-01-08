// Find the number that appears odd number of times - Problem Statement :  Given an array of nums of n integers. Every integer in the array appears twice except one integer. Find the number that appeared once in the array.

import java.util.*;
class BM14{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int xor=0;
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            xor^=a[i];
        }
        System.out.println(xor);
    }
}