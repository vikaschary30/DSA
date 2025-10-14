// Merge Overlapping Sub-intervals - Problem Statement : Given an array of intervals, merge all the overlapping intervals and return an array of non-overlapping intervals.
//                                   1) optimal - TC:O(N) SC:O(N) Merges all overlapping intervals in a single O(N) pass after sorting (if needed), producing a list of non-overlapping merged intervals.


import java.util.*;
class G12{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] a=new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }

        int res[][]=new int[n][2];
        int id=0;
        res[0]=a[0];
        for(int i=1;i<n;i++){
            if(a[i][0]<=res[id][1]){
                res[id][1]=Math.max(res[id][1],a[i][1]);
            }
            else{
                id++;
                res[id]=a[i];
            }
        }
        int[][] result=new int[id+1][2];
        for(int i=0;i<id+1;i++){
            result[i]=res[i];
        }
        for(int[] arr:result){
            System.out.print(arr[0]+" "+arr[1]);
            System.out.print(", ");
        }
    }
}