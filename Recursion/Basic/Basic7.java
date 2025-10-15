//string Palindrome

import java.util.*;
class Basic7{
    // public static String palindromestring(String s, int n, String revs){
    //     if(n==0){
    //         return revs;
    //     }
    //     revs+=s.charAt(n-1);
    //     return palindromestring(s, n-1, revs);
    // }
    public static boolean palindromestring(String s, int i){
        if(i>=(s.length()/2)){
            return true;
        }
        if(s.charAt(i)!=s.charAt(s.length()-i-1)){
            return false;
        }
        return palindromestring(s, i+1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        if(palindromestring(s,0)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}