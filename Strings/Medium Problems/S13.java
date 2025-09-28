// Implement Atoi - Problem Statement : Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
//                                      The algorithm for myAtoi(string s) is as follows:
//                                      1. Whitespace: Ignore any leading whitespace (" ").
//                                      2. Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
//                                      3. Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
//                                      4. Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
//                                      Return the integer as the final result.
//                  1) optimal - TC:O(N) SC:O(1) follows the algorithm.

import java.util.*;
class S13{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        s=s.trim();
        if(s.length()==0){
            System.out.println("0");
            return;
        }
        char[] st=s.toCharArray();
        int i=0,sign=1;
        if(st[i]=='-'){
            sign=-1;
            i++;
        }
        else if(st[i]=='+'){
            i++;
        }
        long val=0;
        while(i<st.length && Character.isDigit(st[i])){
            val=val*10+(st[i]-'0');
            if(sign==1 && val>Integer.MAX_VALUE){
                System.out.println(Integer.MAX_VALUE); 
                return;
            } 
            if(sign==-1 && val<Integer.MIN_VALUE){
                System.out.println(Integer.MIN_VALUE); 
                return;
            }
            i++;
        }
        System.out.println((int)val*sign);
    }
}