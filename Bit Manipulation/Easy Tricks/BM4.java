// Check if i-th bit is set or not

import java.util.*;
class BM4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int i=sc.nextInt();
        if(((1<<i)&n)!=0){
            System.out.println("Yes");
        }
        else System.out.println("No");
        // another way
        // if(((n>>i)&1)==1){
        //     System.out.println("Yes");
        // }
        // else System.out.println("No");
    }
}