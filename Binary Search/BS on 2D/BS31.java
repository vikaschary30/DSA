// Find Peak Element (2D Matrix) - Problem Statement : Given a 0-indexed n x m matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the array [i, j]. A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbours to the left, right, top, and bottom.
//                                                     Assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
//                                 1) optimal - TC:O(n*logM) SC:O(1) At each step, pick the middle column, find the maximum element in that column, and use its neighbors (left/right) to decide which half to continue the search, until a peak is found.


import java.util.*;
class BS31{
    public static int maxele(int[][] mat, int n, int m, int col){
        int max=-1, id=-1;
        for(int i=0;i<n;i++){
            if(mat[i][col]>max){
                max=mat[i][col];
                id=i;
            }
        }
        return id;
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

        int low=0, high=m-1;
        while(low<=high){
            int mid=(low+high)/2;
            int row=maxele(mat,n,m,mid);
            int left= mid-1>=0 ? mat[row][mid-1] : -1;
            int right= mid+1<m ? mat[row][mid+1] : -1;
            if(mat[row][mid]>left && mat[row][mid]>right){
                System.out.println(row+" ,"+mid);
                return;
            }
            else if(mat[row][mid]<left){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        System.out.println("-1 ,-1");
    }
}