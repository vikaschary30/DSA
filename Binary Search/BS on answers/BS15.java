//  Nth Root of a Number using Binary Search - 1) brute force - TC:O(N) checks every integer i starting from 1 and computes i^n until it matches or exceeds m.
//                                             2) optimal - TC:O(LogN) Binary search over range [1, m], using a helper to compare mid^n with m without overflow, narrows to the exact n-th root if it exists.


import java.util.*;
class BS15{
    public static int pow(int mid, int n, int m){
        int ans=1;
        for(int i=1;i<=n;i++){
            ans=ans*mid;
            if(ans>m) return 2;
        }
        if(ans==m) return 1;
        return 0; 
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        //brute force
        // int ans=-1;
        // for(int i=1;i<=m;i++){
        //     if(pow(i,n)==m){
        //         ans=i;
        //         break;
        //     }
        //     else if(pow(i,n)>m){
        //         break;
        //     }
        // }
        // System.out.println(ans);


        // optimal
        int ans=-1;
        int low=1, high=m;
        while(low<=high){
            int mid=(low+high)/2;
            int midnumber=pow(mid,n,m);
            if(midnumber==1){
                ans=mid;
                break;
            }
            else if(midnumber==0){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        System.out.println(ans);
    }
}



