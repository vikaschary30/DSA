// Merge Overlapping sub-intervals -- 1) brute force - TC:O(NlogN + 2N) SC:O(N) Sort intervals by start time and merge them in a single pass by extending the last interval if overlapping, else adding a new one.
//                                    2) optimal - TC:O(NlogN + N) SC:O(N) Sort intervals by start time and either append a new interval if non-overlapping or update the last interval’s end to the maximum if overlapping.

import java.util.*;
class Arrays36{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[][]=new int[n][2];
        for (int i = 0; i < n; i++){
            for(int j=0;j<2;j++){
                a[i][j]=sc.nextInt();
            }
        }
        List<List<Integer>> res=new ArrayList<>();

        Arrays.sort(a, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        // for(int i=0;i<n;i++){
        //     int st=a[i][0];
        //     int end=a[i][1];
        //     if(!res.isEmpty() && end<=res.get(res.size()-1).get(1)){
        //         continue;
        //     }
        //     for(int j=i+1;j<n;j++){
        //         if(a[j][0]<=end){
        //             end=Math.max(end, a[j][1]);
        //         }
        //         else{
        //             break;
        //         }
        //     }
        //     List<Integer> temp=Arrays.asList(st,end);
        //     res.add(temp);
        // }


        for(int i=0;i<n;i++){
            if(res.isEmpty() || a[i][0]>res.get(res.size()-1).get(1)){
                List<Integer> temp=Arrays.asList(a[i][0],a[i][1]);
                res.add(temp);
            }
            else{
                res.get(res.size() - 1).set(1,Math.max(res.get(res.size() - 1).get(1), a[i][1]));
            }
        }


        System.out.println(res);
    }
}