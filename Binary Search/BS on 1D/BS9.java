// Search Element in a Rotated Sorted Array II - 1) iterative : TC:O(logN)


import java.util.*;
class BS9{
    public static boolean search(int[] a, int low, int high, int target){
        while(low<=high){
            int mid=(low+high)/2;
            if(a[mid]==target){
                return true;
            }
            if(a[mid]==a[low] && a[mid]==a[high]){
                low++;
                high--;
                continue;
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
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        }
        int target=sc.nextInt();
        System.out.println(search(a, 0, n-1, target));
    }
}