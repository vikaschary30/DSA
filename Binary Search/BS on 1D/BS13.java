// Peak element in Array - 1) iterative : TC:O(LogN) binary search to find an index where an element is greater than its neighbors, returning that peak element.


import java.util.*;
class BS13{
    public static int peakelement(int[] a, int low, int high){
        while(low<=high){
            int mid=(low+high)/2;
            if(a[mid]>a[mid-1] && a[mid]>a[mid+1]){
                return mid;
            }
            else if(a[mid]>a[mid-1]){
                low=mid+1;
            }
            else if(a[mid]>a[mid+1]){
                high=mid-1;
            }
            else{
                high=mid-1;    // any side is correct
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
        if(n==1){
            System.out.println(0);
            return;
        }
        if(a[0]>a[1]){
            System.out.println(0);
            return;
        }
        if(a[n-1]>a[n-2]){
            System.out.println(n-1);
            return;
        }
        ans=peakelement(a,1,n-2);
        System.out.println(ans);
    }
}