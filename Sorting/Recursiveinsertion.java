// Insertion Sort - takes an element from the index and put it in the sorted position(correct order).

import java.util.*;
class Recursiveinsertion{
    public static void insertion(int a[], int n){
        if(n<=1){
            return;
        }
        insertion(a, n-1);
        int last=a[n-1];
        int j=n-2;
        while(j>=0 && a[j]>last){
            a[j+1]=a[j];
            j--;
        }
        a[j+1]=last;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        insertion(a, n);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
