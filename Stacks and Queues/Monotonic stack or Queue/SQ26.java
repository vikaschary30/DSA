// Maximal Rectangles - Problem Statement : Given a m x n binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
//                      1) optimal - TC:O(m*n) SC:O(n*m) Treat each matrix row as a histogram of consecutive 1’s, compute the largest rectangle in each row using a monotonic stack, and take the maximum area across all rows.

import java.util.*;
class SQ26{
    public static int LRH(int[] a, int m, int n){
        Stack<Integer> st=new Stack<>();
        int max=0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && a[st.peek()]>a[i]){
                int ele=st.pop();
                int nse=i, pse=st.isEmpty()?-1:st.peek();
                max=Math.max(max, a[ele]*(nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int ele=st.pop();
            int nse=n, pse=st.isEmpty()?-1:st.peek();
            max=Math.max(max, a[ele]*(nse-pse-1));
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] a=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }

        //optimal :
        int[][] psum=new int[m][n];
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<m;j++){
                sum+=a[j][i];
                if(a[j][i]==0){
                    psum[j][i]=0;
                    sum=0;
                }
                else{
                    psum[j][i]=sum;
                }
            }
        }
        int max=0;
        for(int i=0;i<m;i++){
            max=Math.max(max,LRH(psum[i],m,n));
        }
        System.out.println(max);
    }
}