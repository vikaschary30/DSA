// Find out how many times the array has been rotated - 1) iterative : TC:O(logN) 


import java.util.*;
class BS11{
    public static int search(int[] a, int low, int high, int ans, int id){
        while(low<=high){
            int mid=(low+high)/2;
            if(a[low]<=a[high]){
                ans=Math.min(ans,a[low]);
                id=low;
                return id;
            }
            if(a[low]<=a[mid]){
                ans=Math.min(ans, a[low]);
                id=low;
                low=mid+1;
            }
            else{
                ans=Math.min(ans, a[mid]);
                id=mid;
                high=mid-1;
            }
        }
        return id;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        }
        int ans=Integer.MAX_VALUE;
        int id=-1;
        id=search(a,0,n-1,ans,id);
        System.out.println(id);
    }
}