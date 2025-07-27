//printiing 1 to n using recursion


import java.util.*;
class Basic2{
    // static int c=1;
    // public static void printnum(int n){
    //         if(c>n){
    //             return;
    //         }
    //         System.out.println(c);
    //         c++;
    //         printnum(n);
    //     }
    public static void printnum(int i, int n){
        if(i<1){
            return;
        }
        printnum(i-1, n);
        System.out.println(i);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        printnum(n,n);
    }
}