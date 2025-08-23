//Count inversions in an array - 1) brute force - TC: O(n^2)  SC: O(1)  Count all pairs (i,j) with i<j and a[i]>a[j]
//                               2) optimal - TC: O(n log n)  SC: O(n) Count inversions during merge process using divide & conquer.



//brute force
// import java.util.*;
// class Arrays39{
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         int n=sc.nextInt();
//         int a[]=new int[n];
//         for (int i = 0; i < n; i++){
//             a[i]=sc.nextInt();
//         }

//         int c=0;
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 if(a[i]>a[j]){
//                     c++;
//                 }
//             }
//         }
//         System.out.println(c);
//     }
// }


// optimal / merge sort
//Merge sort - An optimized sorting algorithm that works on divide and conquer(merge) method.


import java.util.ArrayList;
import java.util.Scanner;
class Arrays39{
    public static int mergesort(int a[], int low, int high){
        int c=0;
        if(low>=high){
            return 0;
        }
        int mid=(low+high)/2;
        c+=mergesort(a, low, mid);
        c+=mergesort(a, mid+1, high);
        c+=merge(a,low,mid,high);
        return c;
    }
    public static int  merge(int a[], int low, int mid, int high){
        int c=0;
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
                c+=(mid-left)+1;
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
        return c;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int ans=mergesort(a, 0, n-1);
        System.out.println(ans);
    }
}