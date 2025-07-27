// Insertion Sort - takes an element from the index and put it in the sorted position(correct order).

import java.util.*;
class Insertions{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int temp=0;
        for(int i=0;i<n;i++){
            int j=i;
            while(j>0 && a[j-1]>a[j]){
                temp=a[j-1];
                a[j-1]=a[j];
                a[j]=temp;
                j--;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
