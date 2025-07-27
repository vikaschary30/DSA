//reversing an array

import java.util.*;
class Basic6{
    // public static void revarray(int[] a,int n){
    //     if(n==0){
    //         return;
    //     }
    //     System.out.print(a[n-1]+" ");
    //     revarray(a, n-1);
    // }
    public static void revarray(int i,int[] a,int n){
        if(i>=(n/2)){
            return;
        }
        int temp=0;
        temp=a[i];
        a[i]=a[n-i-1];
        a[n-i-1]=temp;
        revarray(i+1, a, n);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        revarray(0,a,n);
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }
}