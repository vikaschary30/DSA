// Maximum Nesting Depth of the Parentheses - Problem Statement : Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.
//                                            1) optimal - TC:O(N) SC:O(1) Track the current depth by incrementing for '(' and decrementing for ')', and keep the maximum depth seen.


import java.util.*;
class S8{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        int c=0,mc=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                c++;
                mc=Math.max(mc,c);
            }
            else if(s.charAt(i)==')'){
                c--;
            }
        } 
        System.out.println(mc);
    }
}