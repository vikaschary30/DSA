//Palindrome of a number


import java.util.*;
class Main3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int rem=0,rev=0,temp=n;
        while(n>0){
            rem=n%10;
            rev=(rev*10)+rem;
            n/=10;
        }
        if(rev==temp){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}