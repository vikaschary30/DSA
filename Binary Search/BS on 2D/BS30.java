// Search in a row and column-wise sorted matrix - Problem Statement :  You have been given a 2-D array 'mat' of size 'N x M' where 'N' and 'M' denote the number of rows and columns, respectively. The elements of each row and each column are sorted in non-decreasing order.
//                                                                      But, the first element of a row is not necessarily greater than the last element of the previous row (if it exists).You are given an integer ‘target’, and your task is to find the position of the element if exists, else return {-1, -1}.
//                                                 1) brute force - TC:O(N*M) SC:O(1) Scan every element in the matrix to check if it matches the target.
//                                                 2) better - TC:O(N*logM) SC:O(1) Perform binary search on each row independently since rows are sorted.
//                                                 3) optimal - TC:O(N+M) SC:O(1) Start from the top-right corner and eliminate a row or column in each step using the sorted property.

import java.util.*;
class BS30{
    public static int binarysearch(int[] mat, int k){
        int n=mat.length;
        int low=0, high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(mat[mid]==k){
                return mid;
            }
            else if(k<mat[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
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
        //             System.out.println(i+", "+j);
        //             return;
        //         }
        //     }
        // }

        //better:
        // for(int i=0;i<n;i++){
        //     int id=binarysearch(mat[i],k);
        //     if(id!=-1){
        //         System.out.println(i+", "+id);
        //         return;
        //     }
        //     else{
        //         System.out.println("-1 ,-1");
        //     }
        // }

        //optimal
        int row=0, col=m-1;
        while(row<n && col>=0){
            if(mat[row][col]==k){
                System.out.println(row+", "+col);
                return;
            }
            else if(k<mat[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        System.out.println("-1 ,-1");
    }
}