//Count reverse pairs - 1) brute force - TC: O(N^2) SC:O(1) Iterate through every pair (i, j) with i < j and count how many satisfy a[i] > 2 * a[j].
//                      2) optimal - TC: O(2NlogN) SC:O(N) Use a modified merge sort to count reverse pairs during the merge step by leveraging sorted halves for efficient comparisons.



// brute force
// import java.util.*;
// class Arrays41{
//     public static void main(String[] args) {
//             Scanner sc=new Scanner(System.in);
//             int n=sc.nextInt();
//             int a[]=new int[n];
//             for (int i = 0; i < n; i++){
//                 a[i]=sc.nextInt();
//             }
//             int c=0;
//             for(int i=0;i<n;i++){
//                 for(int j=i+1;j<n;j++){
//                     if(a[i]>2*a[j]){
//                         c++;
//                     }
//                 }
//             }
//             System.out.println(c);
//     }
// }


//Merge sort - An optimized sorting algorithm that works on divide and conquer(merge) method


import java.util.ArrayList;
import java.util.Scanner;
class Arrays41{
    public static int countPairs(int a[], int low, int mid, int high){
        int c=0;
        int right=mid+1;
        for(int i=low;i<=mid;i++){
            while(right<=high && a[i]>2*a[right]){
                right++;
            }
            c+=right-(mid+1);
        }
        return c;
    }
    public static int mergesort(int a[], int low, int high){
        int c=0;
        if(low>=high){
            return c;
        }
        int mid=(low+high)/2;
        c+=mergesort(a, low, mid);
        c+=mergesort(a, mid+1, high);
        c+=countPairs(a, low, mid, high);
        merge(a,low,mid,high);
        return c;
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
        int ans=mergesort(a, 0, n-1);
        System.out.println(ans);
    }
}