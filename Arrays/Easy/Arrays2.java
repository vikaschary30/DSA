//Second Largest element -- brute fore: sort the array and travel from back and find the first element that is not the largest.

import java.util.*;
class Arrays2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        // int max=a[0],sm=-1;
        // for(int i=0;i<n;i++){
        //     if(a[i]>max){
        //         max=a[i];
        //     }
        // }
        //for(int i=0;i<n;i++){
        //     if(a[i]>sm && a[i]!=max){
        //         sm=a[i];
        //     }
        // }
        if(n<2){
            System.out.println("Second largest deos not exist");
            return;
        }
        int fm=a[0];
        int sm=-1;
        for(int i=0;i<n;i++){
            if(a[i]>fm){
                sm=fm;
                fm=a[i];
            }
            else if(a[i]>sm && a[i]!=fm){
                sm=a[i];
            }
        }
        System.out.println(sm);
    }
}