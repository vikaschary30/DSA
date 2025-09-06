// Find the Smallest Divisor Given a Threshold - Problem statement : You are given an array of integers 'arr' and an integer i.e. a threshold value 'limit'. Your task is to find the smallest positive integer divisor, such that upon dividing all the elements of the given array by it, the sum of the division's result is less than or equal to the given threshold value.
//                                               1) brute force - TC:O(n*(max)) Find the smallest positive integer divisor such that the sum of all array elements divided by it (rounded up) does not exceed the given threshold.
//                                               2) optimal - TC:O(logn*(max)) Use binary search on the range [1, max(arr)] to find the smallest divisor such that the sum of ceilings of divisions is ≤ threshold.



import java.util.*;
class BS18{
    public static int sumofdiv(int[] a, int n, int num){
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=Math.ceil((double)a[i]/(double)num);
        }
        return sum;
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
        int limit=sc.nextInt();


        //brute force
        // int ans=0;
        // for(int i=1;i<=max;i++){
        //     int sum=sumofdiv(a,n,i);
        //     if(sum<=limit){
        //         ans=i;
        //         break;
        //     }
        // }
        // System.out.println(ans);

        //optimal 
        int low=1, high=max;
        while(low<=high){
            int mid=(low+high)/2;
            int sum=sumofdiv(a, n, mid);
            if(sum<=limit){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        System.out.println(low);
    }
}