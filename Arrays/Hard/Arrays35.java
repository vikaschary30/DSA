// Count the number of subarrays with given xor K -- 1) brute force - TC:O(N^2) SC:O(1) Check XOR of every possible subarray using two nested loops.
//                                                   2) optimal - TC:O(N) SC:O(N) Maintain prefix XOR and use a HashMap to count how many previous prefixes make xor ^ k, updating the result.


import java.util.*;
class Arrays35{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        int c=0;
        // for(int i=0;i<n;i++){
        //     int xor=0;
        //     for(int j=i;j<n;j++){
        //         xor=xor^a[j];
        //         if(xor==k){
        //             c++;
        //         }
        //     }
        // }

        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0, 1);
        int xor=0;
        for(int i=0;i<n;i++){
            xor=xor^a[i];
            int rem=xor^k;
            if(hm.containsKey(rem)){
                c+=hm.get(rem);
            }
            hm.put(xor,hm.getOrDefault(xor, 0)+1);
        }
        System.out.println(c);  
    }
}