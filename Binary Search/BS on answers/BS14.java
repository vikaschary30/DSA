// Finding Sqrt of a number using Binary Search - 1) brute force/Linear search : TC:O(N) Iterates from 1 to n, updating the last integer whose square ≤ n.
//                                                2) Optimal/Binary Search : TC:O(Logn) Narrows down the largest integer whose square ≤ n by checking midpoints.

import java.util.*;
class BS14{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();


        if (n == 0 || n == 1) {
            System.out.println(n);
            return;
        }

        //brute force
        // int ans=1;
        // for(int i=1;i<=n;i++){
        //     if(i*i<=n){
        //         ans=i;
        //     }
        //     else{
        //         break;
        //     }
        // }


        int ans=1;
        int low=1, high=n;
        while(low<=high){
            int mid=(low+high)/2;
            if((long)mid*mid<=n){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        System.out.println(ans);
    }
}