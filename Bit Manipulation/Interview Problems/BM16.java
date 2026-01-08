// Find XOR of numbers from L to R - Problem Statement : Given two integers L and R. Find the XOR of the elements in the range [L , R]. 

import java.util.*;
class BM16{
    public static int findxor(int n){
        if(n%4==1) return 1;
        else if(n%4==2) return n+1;
        else if(n%4==3) return 0;
        return n;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int l=sc.nextInt();
        int r=sc.nextInt();

        int ans=0;
        //brute force:
        // for(int i=l;i<=r;i++){
        //     ans^=i;
        // }
        // System.out.println(ans);

        //optimal:
        System.out.println(findxor(l-1)^findxor(r));
    }
}