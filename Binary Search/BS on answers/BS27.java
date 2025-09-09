// K-th Element of two sorted arrays - Problem statement : Given two sorted arrays of size m and n respectively, you are tasked with finding the element that would be at the kth position of the final sorted array.
//                                     1) optimal - TC: O(log(min(n1, n2))) SC: O(1) Use binary search on the partition of the smaller array so that the first k elements are correctly distributed between the two arrays.


import java.util.*;
class BS27{
    public static int medianofarrays(int[] a,int[] b, int k){
        int n1=a.length, n2=b.length;
        int n=n1+n2;
        int left=k;
        if(n1>n2) return medianofarrays(b,a,k);
        int low=Math.max(0,k-n2), high=Math.min(n1,k);
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=left-mid1;
            int l1=Integer.MIN_VALUE;
            int l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE;
            int r2=Integer.MAX_VALUE;
            if(mid1>0){
                l1=a[mid1-1];
            }
            if(mid2>0){
                l2=b[mid2-1];
            }
            if(mid1<n1){
                r1=a[mid1];
            }
            if(mid2<n2){
                r2=b[mid2];
            }
            if(l1<=r2 && l2<=r1)
            {
                return Math.max(l1,l2);
            }
            else if(l1>r2){
                high=mid1-1;
            }
            else{
                low=mid1+1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int a[]=new int[n1];
        for(int i=0;i<n1;i++){
            a[i]=sc.nextInt();
        }
        int n2=sc.nextInt();
        int b[]=new int[n2];
        for(int i=0;i<n2;i++){
            b[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        int ans=medianofarrays(a,b,k);
        System.out.println(ans);
    }
}