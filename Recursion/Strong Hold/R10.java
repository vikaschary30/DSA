// Implement Pow(x,n) | X raised to the power N - Problem Statement : Given a double x and integer n, calculate x raised to power n. Basically Implement pow(x, n).
//                                                1) optimal - TC:O(LogN) SC:O(LogN) recursively dividing the exponent n by 2, computing x^(n/2) once, and then squaring it — multiplying by an extra x if n is odd — to efficiently calculate x^n.


import java.util.*;
class R10{
    public static double pow(double x, int n){
        if(n==0) return 1;
        double half=pow(x,n/2);
        if(n%2==0){
            return half*half;
        }
        return half*half*x;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double x=sc.nextDouble();
        int n=sc.nextInt();
        if(n<0){
            x=1/x;
            if(n==Integer.MIN_VALUE){
                n=Integer.MAX_VALUE;
                System.out.println(x*pow(x,n));
                return;
            }
            n=-n;
        }
        System.out.println(pow(x,n));
    }
}