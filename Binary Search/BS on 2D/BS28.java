// Find the row with maximum number of 1's -    Problem statement : You have been given a non-empty grid ‘mat’ with 'n' rows and 'm' columns consisting of only 0s and 1s. All the rows are sorted in ascending order.
//                                              Your task is to find the index of the row with the maximum number of ones.Note: If two rows have the same number of ones, consider the one with a smaller index. If there's no row with at least 1 zero, return -1.
//                                              1) brute force : TC:O(N*M) Count 1’s in every row.
//                                              2) optimal : TC:O(N*logM) Find first 1 in each row using binary search.

import java.util.*;
class BS28{
    public static int lowerbound(int a[], int n, int x) {
        int low=0, high=n-1, ans=n;
        while(low<=high){
            int mid=(low+high)/2;
            if(a[mid]>=x){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
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

        //brute force
        // int index=-1,maxcnt=0;
        // for(int i=0;i<n;i++){
        //     int cnt=0;
        //     for(int j=0;j<m;j++){
        //         cnt+=mat[i][j];
        //     }
        //     if(cnt>maxcnt){
        //         maxcnt=cnt;
        //         index=i;
        //     }
        // }
        // System.out.println(index);


        //optimal
        int index=-1,maxcnt=0;
        for(int i=0;i<n;i++){
            int cnt=0;
            cnt=m-lowerbound(mat[i],m,1);
            if(cnt>maxcnt){
                maxcnt=cnt;
                index=i;
            }
        }
        System.out.println(index);
    }
}