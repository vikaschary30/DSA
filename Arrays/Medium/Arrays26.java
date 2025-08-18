// Set matrix 0's -- 1) brute force - O((N*M)*(N+M))For every 0 found, traverse its entire row and column and mark them -1, then convert -1 to 0 in a second pass.
//                   2) better - TC : O(N*M), SC : O(N+M) Use extra arrays to mark rows and columns containing zeros, then update the matrix in a second pass.
//                   3) optimal - TC : O(N*M), SC : O(1) Use the first row and column as marker arrays, plus a col0 flag for the first column, to set zeros in-place with O(1) extra space.

import java.util.*;
class Arrays26{
    public static void markrow(int[][] a,int i,int n,int m){
        for(int j=0;j<n;j++){
            if(a[i][j]!=0){
                a[i][j]=-1;
            }
        }
    }
    public static void markcol(int[][] a,int j,int n,int m){
        for(int i=0;i<m;i++){
            if(a[i][j]!=0){
                a[i][j]=-1;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int a[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j]=sc.nextInt();
            }
        }

        // brute force 
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(a[i][j]==0){
        //             markrow(a,i,n,m);
        //             markcol(a,j,n,m);
        //         }
        //     }
        // }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(a[i][j]==-1){
        //             a[i][j]=0;
        //         }
        //     }
        // }

        // better 
        // int row[]=new int[n];
        // int col[]=new int[m];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(a[i][j]==0){
        //             row[i]=1;
        //             col[j]=1;
        //         }
        //     }
        // }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(row[i]==1 || col[j]==1){
        //             a[i][j]=0;
        //         }
        //     }
        // }

        //optimal
        int col0=1;
        for(int i=0;i<n;i++){
            if(a[i][0]==0){
                col0=0;
            }
            for(int j=0;j<m;j++){
                if(a[i][j]==0){
                    a[0][j]=0;
                    a[i][0]=0;
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(a[i][j]!=0){
                    if(a[i][0]==0 || a[0][j]==0){
                        a[i][j]=0;
                    }
                }
            }
        }
        if(a[0][0]==0){
            for(int i=0;i<m;i++){
                a[0][i]=0;
            }
        }
        if(col0==0){
            for(int i=0;i<n;i++){
                a[i][0]=0;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}