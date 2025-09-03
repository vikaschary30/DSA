// Minimum in Rotated Sorted Array - 1) iterative : TC:O(logN) binary search to iteratively narrow down the rotated sorted array and update the minimum value by comparing the sorted halves.


import java.util.*;
class BS10{
    public static int search(int[] a, int low, int high, int ans){
        while(low<=high){
            int mid=(low+high)/2;
            if(a[low]<=a[high]){
                ans=Math.min(ans,a[low]);
                return ans;
            }
            if(a[low]<=a[mid]){
                ans=Math.min(ans, a[low]);
                low=mid+1;
            }
            else{
                ans=Math.min(ans, a[mid]);
                high=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        }
        int ans=Integer.MAX_VALUE;
        ans=search(a,0,n-1,ans);
        System.out.println(ans);
    }
}