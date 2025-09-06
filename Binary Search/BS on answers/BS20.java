// Kth Missing Positive Number - Problem Statement : You are given a strictly increasing array ‘vec’ and a positive integer 'k'. Find the 'kth' positive integer missing from 'vec'.
//                               1) brute force - TC:O(n) Start with ans = k and increment it for every array element less than or equal to ans to account for the missing shift.
//                               2) optimal - TC:O(logn) Use binary search to find the position where the count of missing numbers reaches k and compute the result as low + k.


import java.util.*;
class BS20{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int k=sc.nextInt();

        //brute force
        // int ans=k;
        // for(int i=0;i<n;i++){
        //     if(a[i]<=ans){
        //         ans++;
        //     }
        //     else{
        //         break;
        //     }
        // }
        // System.out.println(ans);



        //optimal
        int low=0, high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            int missing=a[mid]-(mid+1);
            if(missing<k){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        System.out.println(low+k);
    }
}