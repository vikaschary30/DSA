//factorial of n

import java.util.*;
class Basic5{
    public static int fact(int n){
        if(n==1){
            return 1;
        }
        return fact(n-1)*n;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(fact(n));
    }
}