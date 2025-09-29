// Area of largest rectangle in Histogram - Problem Statement : Given an array of integers heights representing the histogram's bar height where the width of each bar is 1  return the area of the largest rectangle in histogram.
//                                          1) better - TC:O(5N) SC:O(4N) For each bar, use stacks to find its nearest smaller elements on left and right, then compute area = height × (right − left − 1) and take the maximum. 


import java.util.*;
class SQ25{
    public static int[] findnse(int[] a, int n){
        int[] nse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && a[st.peek()]>=a[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nse;
    }
    public static int[] findpse(int[] a, int n){
        int[] pse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && a[st.peek()]>a[i]){
                st.pop();
            }
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pse;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }

        //brute force:
        int[] nse=findnse(a,n);
        int[] pse=findpse(a,n);
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max, a[i]*(nse[i]-pse[i]-1));
        }
        System.out.println(max);
    }
}