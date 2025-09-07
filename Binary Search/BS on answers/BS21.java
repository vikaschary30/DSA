// Aggressive Cows - Problem statement : You are given an array 'arr' of size 'n' which denotes the position of stalls.You are also given an integer 'k' which denotes the number of aggressive cows.
//                                       You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.
//                                       Find the maximum possible minimum distance.
//                   1) brute force - TC:nlogn+O((max-min)*n) After sorting the array, Try every possible minimum distance from 1 to (max - min) and check for each if k cows can be placed in the stalls, keeping the last valid distance as the answer.
//                   2) optimal - TC:nlogn+O(log(max-min)*n) After sorting the array, Use binary search on the distance range (1 to max-min), and for each mid, check if k cows can be placed with at least that distance; maximize the valid distance.

import java.util.*;
class BS21{
    public static boolean canweplace(int[] a, int n, int d, int k){
        int c=1,last=a[0];
        for(int i=1;i<n;i++){
            if(a[i]-last>=d){
                c++;
                last=a[i];
            }
            if(c>=k){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int k=sc.nextInt(); 
        

        //brute force:
        // Arrays.sort(a);
        // int limit=a[n-1]-a[0];
        // int ans=0;
        // for(int i=1;i<=limit;i++){
        //     if(canweplace(a,n,i,k)){
        //         ans=i;
        //     }
        //     else{
        //         break;
        //     }
        // }
        // System.out.println(ans);


        //optimal
        Arrays.sort(a);
        int low=1, high=a[n-1]-a[0];
        while(low<=high){
            int mid=(low+high)/2;
            boolean possible=canweplace(a, n, mid, k);
            if(possible){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        System.out.println(high);
    }
}