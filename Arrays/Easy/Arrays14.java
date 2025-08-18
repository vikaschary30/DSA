//Longest subarray sum with k(for positive integer arrays only) -- 1) brute force - generate all the possible subarrays and check for longest satisfying one.
//                                                                 2) better - use hashmap by storing the prefixsum with indices as values, and check for (x-k) i.e remaining sum exist == k, if yes return the length.
//                                                                 3) optimal - sliding window and check for the longest subarray with sum k 

import java.util.*;
class Arrays14{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        } 
        int target=sc.nextInt();
        // int len=0,sum=0,maxlen=0;
        // for(int i=0;i<n;i++){
        //     len=0;
        //     sum=0;
        //     for(int j=i;j<n;j++){
        //         sum+=a[j];
        //         if(sum==target){
        //             len=(j-i)+1;
        //             maxlen=Math.max(maxlen, len);
        //         }
        //     }
        // }
        
        // HashMap<Integer,Integer> hm=new HashMap<>();
        // int maxlen=0,sum=0;
        // for(int i=0;i<n;i++){
        //     sum+=a[i];
        //     if(sum==target){
        //         maxlen=Math.max(maxlen, i+1);
        //     }
        //     int rem=sum-target;
        //     if(hm.containsKey(rem)){
        //         int len=i-hm.get(rem);
        //         maxlen=Math.max(maxlen, len);
        //     }
        //     if(!hm.containsKey(sum)){
        //         hm.put(sum, i);
        //     }
        // }

        int len=0,sum=0,maxlen=0;
        int i=0,j=0;
        while(i<n && j<n){
            sum+=a[j];
            if(sum==target){
                len=(j-i)+1;
                maxlen=Math.max(maxlen, len);
            }
            if(sum>target){
                sum-=a[i];
                i++;
            }
            j++;
        }
        System.out.println(maxlen);
    }
}