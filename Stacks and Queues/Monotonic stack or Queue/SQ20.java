// Sum of Subarray Minimums - Problem Statement : Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.
//                            1) brute force - TC:O(N^2) SC:O(1) Iterate over all subarrays, compute the minimum of each, and sum them.
//                            2) optimal - TC:O(N) SC:O(N) Use previous smaller/equal and next smaller element stacks to count each element’s contribution as subarray minimum.


import java.util.*;
class SQ20{
    public static int[] findnse(int[] a, int n){
        int nse[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && a[i]>a[st.peek()]){
                st.pop();
            }
            nse[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nse;
    }
    public static int[] findpsee(int[] a, int n){
        int psee[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && a[i]<=a[st.peek()]){
                st.pop();
            }
            psee[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return psee;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }

        // brute force: 
        // int sum=0,mod=(int)1e9+7;
        // for(int i=0;i<n;i++){
        //     int min=a[i];
        //     for(int j=i;j<n;j++){
        //         min=Math.min(min,a[j]);
        //         sum+=min%mod;
        //     }
        // }
        // System.out.println(sum);

        
        //optimal :
        int nse[]=findnse(a,n);
        int psee[]=findpsee(a,n);
        int sum=0;
        int mod=(int)1e9+7;
        for(int i=0;i<n;i++){
            int left=i-psee[i];
            int right=nse[i]-i;
            sum=(int)(sum+(right*left*1L*a[i])%mod)%mod;
        }
        System.out.println(sum);
    }
}