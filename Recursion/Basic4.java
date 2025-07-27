//printiing n to 1 using recursion


import java.util.*;
class Basic4{
    public static void printnum(int i,int n){
            if(i>n){
                return;
            }
            printnum(i+1,n);
            System.out.println(i);
        }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        printnum(1,n);
    }
}