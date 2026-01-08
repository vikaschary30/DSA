// Find the two numbers appearing odd number of times - Problem Statement : Given an array nums of length n, every integer in the array appears twice except for two integers. Identify and return the two integers that appear only once in the array. Return the two numbers in ascending order.

import java.util.*;
class BM17{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        long xor=0;
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            xor^=a[i];
        }
        int rightbit=((int)xor&(int)(xor-1))^(int)xor;
        int b1=0,b2=0;
        for(int i=0;i<n;i++){
            if((a[i]&rightbit)!=0){
                b1^=a[i];
            }
            else{
                b2^=a[i];
            }
        }
        System.out.println(b1+" "+b2);
    }
}