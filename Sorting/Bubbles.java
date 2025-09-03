//Bubble sort - push the maximum to the last to make it to its sorted position

import java.util.*;
class Bubbles{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int temp=0;
        for(int i=n-1;i>=1;i--){
            int f=0;
            for(int j=0;j<=i-1;j++){
                if(a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    f=1;
                }
            }
            if(f==0){
                break;
            }
        }   
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n-i-1;j++){
        //         if(a[j]>a[j+1]){
        //             temp=a[j];
        //             a[j]=a[j+1];
        //             a[j+1]=temp;
        //         }
        //     }
        // }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }
    }
}