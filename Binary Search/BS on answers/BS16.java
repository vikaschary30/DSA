// Koko Eating Bananas - Problem Statement : A monkey is given ‘n’ piles of bananas, whereas the 'ith' pile has ‘a[i]’ bananas. An integer ‘h’ is also given, which denotes the time (in hours) for all the bananas to be eaten.
//                                           Each hour, the monkey chooses a non-empty pile of bananas and eats ‘k’ bananas. If the pile contains less than ‘k’ bananas, then the monkey consumes all the bananas and won’t eat any more bananas in that hour.
//                                           Find the minimum number of bananas ‘k’ to eat per hour so that the monkey can eat all the bananas within ‘h’ hours.
//                       1) brute force - TC: O(max*n) Try every possible eating speed k from 1 to max(a) and find the smallest k that allows eating all bananas within h hours.
//                       2) optimal - TC: O(logn*n) Use binary search on k (range 1 to max(a)) and pick the smallest speed where total hours ≤ h.


import java.util.*;
class BS16{
    public static int totalhours(int[] a, int hours){
        int totalhrs=0;
        for(int i=0;i<a.length;i++){
            totalhrs+=Math.ceil((double)a[i]/(double)hours);
        }
        return totalhrs;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            max=Math.max(max, a[i]);
        }
        int h=sc.nextInt();

        //brute force
        // for(int i=1;i<=max;i++){
        //     int time=totalhours(a,i);
        //     if(time<=h){
        //         System.out.println(i);
        //         break;
        //     }
        // }

        //optimal
        int low=1,high=max;
        // int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            int time=totalhours(a, mid);
            if(time<=h){
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