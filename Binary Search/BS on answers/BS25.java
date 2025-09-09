// Minimise Maximum Distance between Gas Stations - Problem statement : You are given a sorted array ‘arr’ of length ‘n’, which contains positive integer positions of ‘n’ gas stations on the X-axis. You are also given an integer ‘k’. You have to place 'k' new gas stations on the X-axis. You can place them anywhere on the non-negative side of the X-axis, even on non-integer positions. Let 'dist' be the maximum value of the distance between adjacent gas stations after adding k new gas stations.Find the minimum value of ‘dist’.
//                                                                      Note: Answers within 10^-6 of the actual answer will be accepted. For example, if the actual answer is 0.65421678124, it is okay to return 0.654216. Our answer will be accepted if that is the same as the actual answer up to the 6th decimal place. 
//                                                  1) brute force - TC:O(n*k) SC:O(n) We have n existing gas stations and need to add k new ones. To minimize the maximum distance between adjacent stations, we always place each new station in the largest gap available, splitting it into smaller sections.
//                                                  2) better - TC:O(logn*k) SC:O(n) Use a max-heap to repeatedly split the largest current gap by placing new stations, updating its section length after each placement.
//                                                  3) optimal - TC:O(logn*k) SC:O(1) Use binary search on the minimum possible maximum distance (dist) and check if k stations are enough to ensure no gap exceeds dist.

import java.util.*;
class BS25{
    public static int countofstations(int[] a, double  pos, int n, int k){
        int c=0;
        for(int i=1;i<n;i++){
            int bet=(int)((a[i]-a[i-1])/pos);
            if((a[i]-a[i-1])==(bet*pos)){
                bet--;
            }
            c+=bet;
        }
        return c;
    }
    public static class Pair {
        double first;
        int second;

        Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            max=Math.max(a[i], max);
        }
        int k=sc.nextInt();

        //brute force
        // int[] howmany=new int[n-1];
        // for(int gas=1;gas<=k;gas++){
        //     int maxid=-1;
        //     double maxsec=-1;
        //     for(int i=0;i<n-1;i++){
        //         double diff=a[i+1]-a[i];
        //         double sectionlen=diff/(double)(howmany[i]+1);  
        //         if(sectionlen>maxsec){
        //             maxsec=sectionlen;
        //             maxid=i;
        //         }
        //     }
        //     howmany[maxid]++;
        // }
        // double ans=-1;
        // for(int i=0;i<n-1;i++){
        //     double diff=a[i+1]-a[i];
        //     double sectionlen=diff/(double)(howmany[i]+1);
        //     ans=Math.max(ans, sectionlen);
        // }
        // System.out.println(ans);


        // better
        // int[] howmany=new int[n-1];
        // PriorityQueue<Pair> pq=new PriorityQueue<>((b, c) -> Double.compare(c.first, b.first));
        // for(int i=0;i<n-1;i++){
        //     pq.add(new Pair(a[i+1]-a[i], i));
        // }
        // for(int gas=1;gas<=k;gas++){
        //     Pair tp=pq.poll();
        //     int secid=tp.second;
        //     howmany[secid]++;
        //     double initial=a[secid+1]-a[secid];
        //     double newlen=initial/(double)(howmany[secid]+1);
        //     pq.add(new Pair(newlen, secid));
        // }
        // System.out.println(pq.peek().first);



        //optimal
        double low=0, high=max;
        while((high-low)>1e-6){
            double mid=(low+high)/(2.0);
            int c=countofstations(a,mid,n,k);
            if(c<=k){
                high=mid;
            }
            else{
                low=mid;
            }
        }
        System.out.println(high);
    }
}