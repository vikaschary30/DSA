//print the Maximum subarray sum -- 1) brute force - O(N^2) iterate through array and find the maximum sum out of all the subarrays.
//                                  2) kadane's algo - O(N) Kadane’s Algorithm scans the array once, extending the current subarray if it’s beneficial or starting fresh when the sum becomes negative, keeping track of the maximum sum found and print the array from indices.

import java.util.*;
class Arrays20{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int sum=0,maxsum=Integer.MIN_VALUE;

        int st=0,ansst=0,ansend=0;
        for(int i=0;i<n;i++){
            if(sum==0){
                st=i;
            }
            sum+=a[i];
            if(sum>maxsum){
                ansst=st;
                ansend=i;
                maxsum=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        for(int i=ansst;i<=ansend;i++){
            System.out.print(a[i]+" ");
        }
    }
}