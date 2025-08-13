//Maximum subarray sum -- 1) brute force - O(N^2) iterate through array and find the maximum sum out of all the subarrays.
//                        2) kadane's algo - O(N) Kadane’s Algorithm scans the array once, extending the current subarray if it’s beneficial or starting fresh when the sum becomes negative, keeping track of the maximum sum found.


import java.util.*;
class Arrays19{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int sum=0,maxsum=Integer.MIN_VALUE;
        // for(int i=0;i<n;i++){
        //     sum=0;
        //     for(int j=i;j<n;j++){
        //         sum+=a[j];
        //         maxsum=Math.max(maxsum, sum);
        //     }
        // }

        // int st=0,ansst=0,ansend=0; if wanted to print the subarray as well.
        for(int i=0;i<n;i++){
            // if(sum==0){
            //     st=i;
            // }
            sum+=a[i];
            maxsum=Math.max(maxsum, sum);
            // ansst=st;
            // ansend=i;
            if(sum<0){
                sum=0;
            }
        }
        System.out.println(maxsum);
    }
}