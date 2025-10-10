// Jump Game 2 - Problem Statement : You are given a 0-indexed array nums of length n representing your maximum jump capability from each index.
//                                   You start at index 0. Each element nums[i] represents the maximum number of steps you can jump forward from index i.
//                                   Your goal is to reach the last index of the array (nums[n - 1]) using the minimum number of jumps
//                                   Return the minimum number of jumps required to reach the last index.You can assume that it is always possible to reach the last index.
//               1) brute force - TC:O(N^N) SC:O(N) Recursively explore every possible jump from each index and return the minimum number of jumps needed to reach or surpass the last index.
//               2) optimal - TC:O(N) SC:O(1) Greedily expand the current jump range to the farthest reachable index and count jumps whenever the current range ends until reaching the last index.


import java.util.*;
class G8{
    public static int noofjumps(int[] a, int ind, int n, int jumps){
        if(ind>=n-1) return jumps;
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=a[ind];i++){
            min=Math.min(min,noofjumps(a, ind+i, n, jumps+1));
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }

        //brute force:
        // int jumps=0,ind=0;
        // System.out.println(noofjumps(a,ind,n,jumps));

        //optimal:
        int l=0,r=0;
        int jumps=0;
        while(r<n-1){
            int farthest=0;
            for(int i=l;i<=r;i++){
                farthest=Math.max(farthest,i+a[i]);
            }
            jumps++;
            l=r+1;
            r=farthest;
        }
        System.out.println(jumps);
    }
}