// Sum of Subarray Maximums - Problem Statement : Given an array of integers arr, find the sum of max(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.
//                            1) brute force - TC:O(N^2) SC:O(1) Iterate over all subarrays, compute the maximum of each, and sum them.
//                            2) optimal - TC:O(N) SC:O(N) Use previous greater/equal and next greater element stacks to count each element’s contribution as subarray minimum.


import java.util.*;
class SQ22{
    public static int[] findnge(int[] a, int n){
        int nge[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && a[i]>=a[st.peek()]){
                st.pop();
            }
            nge[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nge;
    }
    public static int[] findpge(int[] a, int n){
        int pge[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && a[i]>a[st.peek()]){
                st.pop();
            }
            pge[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pge;
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
        //     int max=a[i];
        //     for(int j=i;j<n;j++){
        //         max=Math.max(max,a[j]);
        //         sum+=max%mod;
        //     }
        // }
        // System.out.println(sum);

        
        //optimal :
        int nge[]=findnge(a,n);
        int pge[]=findpge(a,n);
        int sum=0;
        int mod=(int)1e9+7;
        for(int i=0;i<n;i++){
            int left=i-pge[i];
            int right=nge[i]-i;
            sum=(int)(sum+(right*left*1L*a[i])%mod)%mod;
        }
        System.out.println(sum);
    }
}