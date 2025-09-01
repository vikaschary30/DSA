// Floor and Ceil in Sorted Array - 1) iterative : TC:O(LogN)


import java.util.*;
class BS5{
    public static int ceil(int a[], int low, int high, int x, int ans) {
        while(low<=high){
            int mid=(low+high)/2;
            if(a[mid]>=x){
                ans=a[mid];
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static int floor(int a[], int low, int high, int x, int ans) {
        while(low<=high){
            int mid=(low+high)/2;
            if(a[mid]<=x){
                ans=a[mid];
                low=mid+1;
            }
            else{
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
        int x=sc.nextInt();
        int ans=-1;
        System.out.print(floor(a,0,n-1,x,ans)+" ");
        System.out.print(ceil(a,0,n-1,x,ans));
    }
}