// Count no of set bits

import java.util.*;
class BM10{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c=0;
        // while(n>1){
        //     c+=(n&1);
        //     n=n>>1;
        // }
        // if(n==1) c+=1;

        while(n!=0){
            n=n&(n-1);
            c++;
        }
        System.out.println(c);
    }
}