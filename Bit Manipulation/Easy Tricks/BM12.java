// Divide two integers without using multiplication, division and mod operator

import java.util.*;
class BM12{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int dividend=sc.nextInt();
        int divisor=sc.nextInt();
        if(dividend==divisor){
            System.out.println(1);
            return;
        }
        boolean sign=true;
        if(dividend>=0 && divisor<0) sign=false;
        if(dividend<0 && divisor>0) sign=false;
        int n=Math.abs(dividend);
        int d=Math.abs(divisor);
        int ans=0;
        while(n>=d){
            int c=0;
            while(n>=(d<<(c+1))){
                c++;
            }
            ans+=(1<<(c));
            n=n-(d<<(c));
        }
        if(sign && ans==(1<<31)){
            System.out.println(Integer.MAX_VALUE); 
            return; 
        } 
        if(!sign && ans==(1<<31)){
            System.out.println(Integer.MAX_VALUE);
            return;  
        } 
        System.out.println(sign?ans:(-1*ans));
    }
}