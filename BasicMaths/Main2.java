//reversing a number
import java.util.*;
class Main2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int rem=0;
        // String ans="";
        // while(n>0){
        //     rem=n%10;
        //     ans+=Integer.toString(rem);
        //     n=n/10;
        // }
        int revvnum=0;
        while(n>0){
            rem=n%10;
            revvnum=(revvnum*10)+rem;
            n=n/10;
        }
        System.out.println(revvnum);
    }
}