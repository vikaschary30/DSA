// Maximum Product Subarray in an Array -- 1) brute force - TC:O(N^2) SC:O(1) checks every subarray by multiplying elements to find the maximum product.
//                                         2) optimal 1 - TC:O(N) SC:O(1) Maintain current max and min products to handle negative flips and update global maximum.
//                                         3) optimal 2 - TC:O(N) SC:O(1) Compute running prefix and suffix products to handle zeros and find the maximum product in one pass.

import java.util.*;
class Arrays40{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        }
        // int pro=1,maxi=1;
        // for(int i=0;i<n;i++){
        //     pro=1;
        //     for(int j=i;j<n;j++){
        //         pro*=a[j];
        //         maxi=Math.max(pro,maxi);
        //     }
        // }


        // int cmax=a[0],cmin=a[0],maxi=a[0];
        // for(int i=1;i<n;i++){
        //     if(a[i]<0){
        //         int temp=cmax;
        //         cmax=cmin;
        //         cmin=temp;
        //     }
        //     cmax=Math.max(cmax*a[i],a[i]);
        //     cmin=Math.min(cmin*a[i],a[i]);
        //     maxi=Math.max(maxi,cmax);
        // }


        int pre=1,suff=1,maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(pre==0){
                pre=1;
            }
            if(suff==0){
                suff=1;
            }
            pre*=a[i];
            suff*=a[n-i-1];
            maxi=Math.max(maxi, Math.max(pre, suff));
        }
        System.out.println(maxi);
    }
}