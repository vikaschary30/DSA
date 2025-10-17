// Count Good numbers - Problem Statement :  A digit string is considered good if the digits at even indices (0-based) are even digits (0, 2, 4, 6, 8) and the digits at odd indices are prime digits (2, 3, 5, 7).Given an integer n, return the total number of good digit strings of length n. As the result may be large, return it modulo 109 + 7.A digit string is a string consisting only of the digits '0' through '9'. It may contain leading zeros.
//                      1) optimal - 

import java.util.*;
class R11{
    static long mod=1000000009L;
    public static long pow(long x, long n){
        if(n==0) return 1;
        long half=pow(x,n/2);
        if(n%2==0){
            return (half*half)%mod;
        }
        return (((half*half)%mod)*x)%mod;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        long ec=(n+1)/2;
        long oc=n/2;
        long ans=(pow(5,ec)*pow(4,oc))%mod;
        System.out.println((int)ans);
    }
}