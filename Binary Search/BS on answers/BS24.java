// Painter's Partition Problem - Problem statement : Given an array/list of length ‘N’, where the array/list represents the boards and each element of the given array/list represents the length of each board. Some ‘K’ numbers of painters are available to paint these boards. Consider that each unit of a board takes 1 unit of time to paint. You are supposed to return the area of the minimum time to get this job done of painting all the ‘N’ boards under the constraint that any painter will only paint the continuous sections of boards.
//                               1) brute force - O((sum - max) * n) Try every possible max board length sum from max(board) to sum(board) and return the first that allows ≤ k painters.
//                               2) optimal - O(n * log(sum - max)) Use binary search between max(board) and sum(board) to find the minimum time for painting all boards with ≤ k painters.


import java.util.*;
class BS24{
    public static int noofpartitions(int[] a, int maxsum, int n, int k){
        int csum=0, part=1;
        for(int i=0;i<n;i++){
            if(a[i]+csum<=maxsum){
                csum+=a[i];
            }
            else{
                part++;
                csum=a[i];
            }
        } 
        return part;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            max=Math.max(a[i], max);
            sum+=a[i];
        }
        int k=sc.nextInt();

        //brute force
        // int ans=max;
        // for(int i=max;i<=sum;i++){
        //     int part=noofpartitions(a,i,n,k);
        //     if(part<=k){
        //         ans=i;
        //         break;
        //     }
        // }
        // System.out.println(ans);

        // optimal
        // int ans=0;
        int low=max, high=sum;
        while(low<=high){
            int mid=(low+high)/2;
            int part=noofpartitions(a, mid, n, k);
            if(part<=k){
                // ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }   
        System.out.println(low);    
    }
}