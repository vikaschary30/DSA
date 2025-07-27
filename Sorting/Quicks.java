// Quick sort - it is an optimized sorting algo that takes up a pivot element and place it in sorted array,it is a divde and conquer algo.

import java.util.*;
class Quicks{
    public static void quicksort(int a[], int low, int high){
        if(low<high){
            int partition=part(a,low,high);
            quicksort(a, low, partition-1);
            quicksort(a, partition+1, high);
        }
    }
    public static int part(int a[], int low, int high){
        int pivot=a[low];
        int i=low;
        int j=high;
        while(i<j){
            while(a[i]<=pivot && i<=high-1){
                i++;
            }
            while(a[j]>pivot && j>=low+1){
                j--;
            }
            if(i<j){
                swap(a,i,j);
            }
        }
        swap(a,low,j);
        return j;
    }
    public static void swap(int a[],int i, int j){
        int temp;
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        quicksort(a, 0, n-1);
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }    
    }
}