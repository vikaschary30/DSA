// Non-overlapping Intervals - Problem Statement :  Given an array of N intervals in the form of (start[i], end[i]), where start[i] is the starting point of the interval and end[i] is the ending point of the interval, return the minimum number of intervals that need to be removed to make the remaining intervals non-overlapping.
//                             1) optimal - TC:O(NlogN+N) SC:O(1) Greedy approach that sorts intervals by end time, counts the maximum number of non-overlapping intervals, and returns how many must be removed to achieve that.

import java.util.*;
class G15{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] a=new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }

        Arrays.sort(a, (x, y) -> Integer.compare(x[1], y[1]));
        int c=1;
        int lastend=a[0][1];
        for(int i=1;i<n;i++){
            if(a[i][0]>=lastend){
                c++;
                lastend=a[i][1];
            }
        }
        System.out.println(n-c);
    }
}