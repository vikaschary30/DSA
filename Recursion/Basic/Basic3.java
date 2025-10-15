//sum of n numbers using recursion

import java.util.*;
class Basic3{
    // static int sum=0;
    // public static int printnum(int n){
    //     if(n==0){
    //         return sum;
    //     }
    //     sum+=n;
    //     printnum(n-1);
    //     return sum;
    // }
    public static int printnum(int n){
        if(n==0){
            return 0;
        }
        return printnum(n-1)+n;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(printnum(n));
    }
}