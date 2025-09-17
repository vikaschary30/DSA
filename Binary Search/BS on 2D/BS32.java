// Median of Row Wise Sorted Matrix - Problem Statement : Given a row-wise sorted matrix of size MXN, where M is no. of rows and N is no. of columns, find the median in the given matrix.
//                                    1) brute force - TC :O(M*N log(M*N)) SC:O(1) Flatten the matrix, sort it, and return the middle element.
//                                    2) optimal - TC :O(log(maxVal - minVal) * M * log N) SC:O(1) Binary search on the value range (min → max), counting how many elements are ≤ mid using row-wise binary search, until the median position is located.

import java.util.*;
class BS32{
    public static int median(int[][] mat, int m, int n){
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                lst.add(mat[i][j]);
            }
        }
        Collections.sort(lst);
        return lst.get((m * n) / 2);
    }
    public static int countofsmaller(int[][] mat, int m, int n, int x) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            cnt += upperBound(mat[i], x, n);
        }
        return cnt;
    }
    static int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
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

        // brute force :
        // int ans = median(mat, n, m);
        // System.out.println("The median element is: " + ans);

        // optimal :
        int low=Integer.MAX_VALUE, high=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][m - 1]);
        }
        int req=(n*m)/2;
        while(low<=high){
            int mid=(low+high)/2;
            int smallerequals=countofsmaller(mat, n, m, mid);
            if(smallerequals<=req){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        System.out.println(low);
    }
}