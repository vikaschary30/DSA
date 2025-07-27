//Bubble sort - push the maximum to the last to make it to its sorted position

import java.util.*;
class Recursivebubble{
    
    public static void bubble(int a[], int n){
        if(n==1){
            return;
        }
        for(int i=0;i<n-1;i++){
            if(a[i]>a[i+1]){
                int temp=a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
            }
        }
        bubble(a, n-1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        bubble(a,n);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }
    }
}