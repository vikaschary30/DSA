//printing name n times

import java.util.*;
class Basic1{
    public static void namerecursion(String s, int n){
        if(n==0)
            return;
        else
            System.out.println(s);
            namerecursion(s, n-1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=sc.nextInt();
        namerecursion(s,n);
    }
}