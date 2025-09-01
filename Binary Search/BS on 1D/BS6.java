// First and Last occurrence in a sorted array - 1) iterative : TC:O(2LogN)


import java.util.*;
class BS6{
    public static int firstoccurence(int a[], int low, int high, int x, int ans) {
        while(low<=high){
            int mid=(low+high)/2;
            if(a[mid]==x){
                ans=mid;
                high=mid-1;
            }
            else if(x<a[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static int lastoccurence(int a[], int low, int high, int x, int ans) {
        while(low<=high){
            int mid=(low+high)/2;
            if(a[mid]==x){
                ans=mid;
                low=mid+1;
            }
            else if(x<a[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
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
        System.out.print(firstoccurence(a,0,n-1,x,ans)+" ");
        System.out.print(lastoccurence(a,0,n-1,x,ans));
    }
}   