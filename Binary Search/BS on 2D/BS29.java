    // Search in a sorted 2D matrix - Problem Statement : You have been given a 2-D array 'mat' of size 'N x M' where 'N' and 'M' denote the number of rows and columns, respectively. The elements of each row are sorted in non-decreasing order. Moreover, the first element of a row is greater than the last element of the previous row (if it exists). You are given an integer ‘target’, and your task is to find if it exists in the given 'mat' or not.
    //                                1)brute force -  TC:O(N*M) SC:O(1) Linearly scan every element in the 2D matrix to check for the target.
    //                                2)better - TC:O(N*log(M)) SC:O(1) Identify the possible row using range check, then apply binary search on that row.
    //                                3)optimal - TC:O(log(N*M)) SC:O(1) Treat the 2D matrix as a flattened 1D sorted array and apply binary search directly.


    import java.util.*;
    class BS29{
        public static boolean binarysearch(int[] mat, int k){
            int n=mat.length;
            int low=0, high=n-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(mat[mid]==k){
                    return true;
                }
                else if(k<mat[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            return false;
        }
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[][] mat=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    mat[i][j]=sc.nextInt();
                }
            }
            int k=sc.nextInt();

            //brute force:
            // for(int i=0;i<n;i++){
            //     for(int j=0;j<m;j++){
            //         if(mat[i][j]==k)
            //         {
            //             System.out.println("true");
            //             return;
            //         }
            //     }
            // }


            //better
            // for(int i=0;i<n;i++){
            //     if(mat[i][0]<=k && mat[i][m-1]>=k){
            //         System.out.println(binarysearch(mat[i],k));
            //         return;
            //     }
            // }


            //optimal
            int low=0, high=(n*m)-1;
            while(low<=high){
                int mid=(low+high)/2;
                int row=mid/m, col=mid%m;
                if(mat[row][col]==k){
                    System.out.println("true");
                    return;
                }
                else if(k<mat[row][col]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            System.out.println("element not found");
        }
    }