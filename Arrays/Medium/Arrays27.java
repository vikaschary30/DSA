//rotate matrix by 90 degrees -- 1) brute force - TC : O(N^2), SC : O(N*M) Create a new matrix and move each element to its rotated position res[j][n-1-i]
//                               2) optimal - TC : O(N^2), SC : O(1) Transpose the matrix in-place, then reverse each row to rotate it 90° clockwise.

import java.util.*;
class Arrays27{
    public static void reverse(int a[][], int row, int n){
        int i=0,j=n-1;
        while(i<j){
            int temp=a[row][i];
            a[row][i]=a[row][j];
            a[row][j]=temp;
            i++;
            j--;
        }
    }
    public static void swap(int a[][], int i, int j){
        int temp=a[i][j];
        a[i][j]=a[j][i];
        a[j][i]=temp;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        // int m=sc.nextInt();
        int a[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }
        // int res[][]=new int[n][n];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         res[j][(n-1)-i]=a[i][j];
        //     }
        // }

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                swap(a,i,j);
            }
        }
        for(int i=0;i<n;i++){
            reverse(a,i,n);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}