// Minimum days to make M bouquets - Problem Statemen : You are given 'N’ roses and you are also given an array 'arr'  where 'arr[i]'  denotes that the 'ith' rose will bloom on the 'arr[i]th' day.
//                                                      You can only pick already bloomed roses that are adjacent to make a bouquet. You are also told that you require exactly 'k' adjacent bloomed roses to make a single bouquet.
//                                                      Find the minimum number of days required to make at least ‘m' bouquets each containing 'k' roses. Return -1 if it is not possible.
//                                  1) brute force - TC : O((max-min+1)*n) Try every day from the earliest bloom (min) to the latest bloom (max), and for each day, count how many bouquets can be formed; the first day with at least m bouquets is the answer.
//                                  2) optimal - TC : O(log(max-min+1)*n) Search for the smallest day between min and max such that at least m bouquets of size k can be made.

import java.util.*;
class BS17{
    public static int noofbouquets(int[] a, int n, int day, int m, int k){
        int c=0,b=0;
        for(int i=0;i<n;i++){
            if(a[i]<=day){
                c++;
            }
            else{
                b+=c/k;
                c=0;
            }
        }
        b+=c/k;
        return b;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            max=Math.max(max, a[i]);
            min=Math.min(min, a[i]);
        }
        int m=sc.nextInt();
        int k=sc.nextInt();

        if(n<(m*k)){
            System.out.println("-1");
            return;
        }

        //brute force
        // int ans=0;
        // for(int i=min;i<=max;i++){
        //     int possiblebouquets=noofbouquets(a,n,i,m,k);
        //     if(possiblebouquets==m){
        //         ans=i;
        //         break;
        //     }
        // }
        // System.out.println(ans);


        //optimal
        int low=min, high=max;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            int possiblebouquets=noofbouquets(a, n, mid, m, k);
            if(possiblebouquets>=m){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        System.out.println(ans); // can also return low and check edge
    }
}