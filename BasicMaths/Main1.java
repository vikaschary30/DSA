//Counting digits
import java.util.*;
class Main1{
    public static void main(String...args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c=(int)Math.log10(n)+1; //optimized
        // while(n>0){
        //     n=n/10;
        //     c++;
        // } //bf
        System.out.println(c);
    }
}