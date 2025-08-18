//Count Subarray sum Equals K --  1) brute force - O(N^2) Try all subarrays and check if their sum equals k.
//                                2) optimal - O(N) Use prefix sum + HashMap to count how many times (sum - k) has appeared so far.


import java.util.*;
class Arrays29{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        int c=0;
        // for(int i=0;i<n;i++){
        //     int sum=0;
        //     for(int j=i;j<n;j++){
        //         sum+=a[j];
        //         if(sum==k){
        //             c++;
        //         }
        //     }
        // }

        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int psum=0;
        for(int i=0;i<n;i++){
            psum+=a[i];
            int rem=psum-k;
            c+=hm.getOrDefault(rem, 0);
            hm.put(psum,hm.getOrDefault(psum, 0)+1);
        }
        System.out.println(c);
    }
}