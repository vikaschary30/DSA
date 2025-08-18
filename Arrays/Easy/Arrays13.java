//Find the number that appears once, and the other numbers twice -- 1) brute force - O(N^2) by counting the frequency
//                                                                  2) better - O(NlogN)/O(N) by using hashmap and maintaining freq
//                                                                  3) optimal - O(N) use XOR for all array elements

import java.util.*;
class Arrays13{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        // HashMap<Integer,Integer> hm=new HashMap<>();
        for (int i = 0; i < n; i++){
            a[i]=sc.nextInt();
            // hm.put(a[i],hm.getOrDefault(a[i], 0)+1);
        } 
        // for(int i=0;i<n;i++){
        //     int c=0;
        //     for(int j=i+1;j<n;j++){
        //         if(a[j]==a[i]){
        //             c++;
        //         }
        //     }                                             
        //     if(c==0){
        //         System.out.println(a[i]);
        //         break;
        //     }
        // }

        // for(Map.Entry<Integer,Integer> entry: hm.entrySet()){
        //     if(entry.getValue()==1){
        //         System.out.println(entry.getKey());
        //         break;
        //     }
        // }
        int xor=0;
        for(int i=0;i<n;i++){
            xor^=a[i];
        }
        System.out.println(xor);
    }
}