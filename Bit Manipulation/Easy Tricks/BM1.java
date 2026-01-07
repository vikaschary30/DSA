// Decimal to Binary

import java.util.*;
class BM1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        StringBuilder res=new StringBuilder();
        while(n>0){
            if(n%2==1) res.append("1");
            else res.append("0");
            n/=2;
        }
        System.out.println(res.reverse());
    }
}