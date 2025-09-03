// Search Single Element in a sorted array - 1) TC:O(LogN) binary search with index parity to find the element that occurs only once in a sorted array where all other elements appear twice.


import java.util.*;
class BS12{
    public static int singleele(int[] a, int low, int high){
        while(low<=high){
            int mid=(low+high)/2;
            if(a[mid]!=a[mid-1] && a[mid]!=a[mid+1]){
                return a[mid];
            }
            if((mid%2!=0  && a[mid]==a[mid-1]) || (mid%2==0  && a[mid]==a[mid+1])){
                low=mid+1;
            }
            else{
                high=mid-1;
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
        int ans=-1;
        if(a[0]!=a[1]){
            System.out.println(a[0]);
            return;
        }
        if(a[n-1]!=a[n-2]){
            System.out.println(a[n-1]);
            return;
        }
        ans=singleele(a,1,n-2);
        System.out.println(ans);
    }
}