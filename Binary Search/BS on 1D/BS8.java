// Search Element in a Rotated Sorted Array - 1) iterative : TC:O(logN) binary search by identifying the sorted half in each step and adjusting the search range accordingly.


import java.util.*;
class BS8{
    public static int search(int[] a, int low, int high, int target){
        while(low<=high){
            int mid=(low+high)/2;
            if(a[mid]==target){
                return mid;
            }
            if(a[low]<=a[mid]){
                if(target>=a[low] && target<=a[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else{
                if(target>=a[mid] && target<=a[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        }
        int target=sc.nextInt();
        int ans=search(a,0,n-1,target);
        if(ans==-1){
            System.out.println("Target not found");
        }
        else{
            System.out.println(ans);
        }
    }
}