//Merge sort - An optimized sorting algorithm that works on divide and conquer(merge) method


import java.util.ArrayList;
import java.util.Scanner;
class Merges{
    public static void mergesort(int a[], int low, int high){
        if(low>=high){
            return;
        }
        int mid=(low+high)/2;
        mergesort(a, low, mid);
        mergesort(a, mid+1, high);
        merge(a,low,mid,high);
    }
    public static void  merge(int a[], int low, int mid, int high){
        ArrayList<Integer> l=new ArrayList<>();
        int left=low;
        int right=mid+1;
        while(left<=mid && right<=high){
            if(a[left]<=a[right]){
                l.add(a[left]);
                left++;
            }
            else{
                l.add(a[right]);
                right++;
            }
        }
        while(left<=mid){
            l.add(a[left]);
            left++;
        }
        while(right<=high){
            l.add(a[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            a[i]=l.get(i-low);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        mergesort(a, 0, n-1);
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }
}