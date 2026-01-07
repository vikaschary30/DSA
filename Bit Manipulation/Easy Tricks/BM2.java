//  Binary to Decimal

import java.util.*;
class BM2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String n=sc.next();
        int res=0,p2=1;
        for(int i=n.length()-1;i>=0;i--){
            if(n.charAt(i)=='1'){
                res+=p2;
            }
            p2*=2;
        }
        System.out.println(res);
    }
}