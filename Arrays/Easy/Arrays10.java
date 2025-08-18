// Find missing number in an array --   1) brute force: linear search i.e O(N^2)
//                                      2) better: use hashset for storing all and retrieve by iterating from 1 to n
//                                      3) optimal: calculate the difference of array sum and actual sum

import java.util.*;
class Arrays10{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int len=n-1;
        int a[]=new int[len];
        // int arrsum=0, nsum=0;
        // for (int i = 0; i < len; i++){
        //     a[i]=sc.nextInt();
        //     arrsum+=a[i];
        // }
        // nsum=(n*(n+1))/2;



        // HashSet<Integer> hs=new HashSet<>();
        // for (int i = 0; i < len; i++){
        //     a[i]=sc.nextInt();
        //     hs.add(a[i]);
        // }
        // int ans=0;
        // for(int i=1;i<=n;i++){
        //     if(!hs.contains(i)){
        //         ans=i;
        //     }
        // }

        for(int i=0;i<len;i++){
            a[i]=sc.nextInt();
        }
        int xor1=0;
        int xor2=0;
        for(int i=0;i<len;i++){
            xor1^=(i+1);
            xor2^=a[i];
        }
        xor1=xor1^n;
        System.out.println(xor1^xor2);
    }
}