// Search insert position - iterative : TC:O(LogN)


import java.util.*;
class BS4{
    public static int searchpos(int a[], int low, int high, int x, int ans) {
        while(low<=high){
            int mid=(low+high)/2;
            if(a[mid]>=x){
                ans=mid;
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
        int ans=n;
        System.out.println(searchpos(a,0,n-1,x,ans));
    }
}