// Sum of Subarray Ranges - Problem Statement : You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.Return the sum of all subarray ranges of nums.A subarray is a contiguous non-empty sequence of elements within an array.
//                          1) brute force - TC:O(N^2) SC:O(1) For every subarray, compute max and min directly, add their difference.
//                          2) optimal - TC:O(N) SC:O(N) Use monotonic stacks to compute each element’s contribution as maximum and minimum separately, then subtract total minimums from total maximums.


import java.util.*;
class SQ23{
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
    public static int findmax(int[] a, int n){
        int nge[]=findnge(a,n);
        int pge[]=findpge(a,n);
        int sum=0;
        int mod=(int)1e9+7;
        for(int i=0;i<n;i++){
            int left=i-pge[i];
            int right=nge[i]-i;
            sum=(int)(sum+(right*left*1L*a[i])%mod)%mod;
        }
        return sum;
    }
    public static int[] findnse(int[] a, int n){
        int nse[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && a[i]<=a[st.peek()]){
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
            while(!st.isEmpty() && a[i]<a[st.peek()]){
                st.pop();
            }
            psee[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return psee;
    }
    public static int findmin(int[] a, int n){
        int nse[]=findnse(a,n);
        int psee[]=findpsee(a,n);
        int sum=0;
        int mod=(int)1e9+7;
        for(int i=0;i<n;i++){
            int left=i-psee[i];
            int right=nse[i]-i;
            sum=(int)(sum+(right*left*1L*a[i])%mod)%mod;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }

        // //brute force:
        // int sum=0;
        // for(int i=0;i<n;i++){
        //     int max=a[i], min=a[i];
        //     for(int j=i;j<n;j++){
        //         max=Math.max(a[i],max);
        //         min=Math.min(a[i],min);
        //         sum+=(max-min);
        //     }
        // }
        // System.out.println(sum);


        //optimal:
        int sum=findmax(a,n)-findmin(a,n);
        System.out.println(sum);
    }
}