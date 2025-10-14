// Insert Interval - Problem Statement : You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).Return intervals after the insertion.
//                                       Note that you don't need to modify intervals in-place. You can make a new array and return it.
//                   1) optimal - TC:O(N) SC:O(N) Efficiently inserts a new interval into a sorted list of non-overlapping intervals by merging overlaps in a single pass.

import java.util.*;
class G14{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] a=new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        int[] interval=new int[2];
        interval[0]=sc.nextInt();
        interval[1]=sc.nextInt();


        List<int[]> res=new ArrayList<>();
        int i=0;
        while(i<n && a[i][1]<interval[0]){
            res.add(a[i]);
            i++;
        }
        while(i<n && a[i][0]<=interval[1]){
            interval[0]=Math.min(interval[0],a[i][0]);
            interval[1]=Math.max(interval[1],a[i][1]);
            i++;
        }
        res.add(interval);
        while(i<n){
            res.add(a[i]);
            i++;
        }
        int[][] result=new int[res.size()][2];
        for(int j=0;j<res.size();j++){
            result[j]=res.get(j);
        }
        for(int[] arr:result){
            System.out.print(arr[0]+" "+arr[1]);
        }
    }
}