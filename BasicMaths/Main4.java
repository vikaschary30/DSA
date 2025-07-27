//Armstrong number


import java.util.*;
class Main4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int rem=0,temp=0,dup=n;
        int c=(int)Math.log10(n)+1;
        while(n>0){
            rem=n%10;
            temp+=(int)Math.pow(rem,c);
            n=n/10;
        }
        if(dup==temp){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }
}