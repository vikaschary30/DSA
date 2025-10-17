// Recursive Implementation of atoi() - Problem Statement :  Implement the function myAtoi(s) which converts the given string s to a 32-bit signed integer (similar to the C/C++ atoi function).
//                                                           Steps to Implement: 1. First, ignore any leading whitespace characters ' ' until the first non-whitespace character is found.
//                                                           2. Check the next character to determine the sign. If it’s a '-', the number should be negative. If it’s a '+', the number should be positive. If neither is found, assume the number is positive.
//                                                           3. Read the digits and convert them into a number. Stop reading once a non-digit character is encountered or the end of the string is reached. Leading zeros should be ignored during conversion.
//                                                           4. The result should be clamped within the 32-bit signed integer range: [-2147483648, 2147483647]. If the computed number is outside this range, return -2147483648 if the number is less than -2147483648, or return 2147483647 if the number is greater than 2147483647.
//                                                           5. Finally, return the computed number after applying all the above steps.
//                                      1) optimal - TC:(n) SC:O(n) Recursively process each digit of the trimmed string, building the result while handling sign and clamping to 32-bit integer limits.


import java.util.*;
class R9{
    public static int atoi(String s, int i, long res, int sign){
        if(i>=s.length() || !Character.isDigit(s.charAt(i))){
            long val=res*sign;
            if(val>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(val<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            return (int)val;
        }
        if(res>(Integer.MAX_VALUE-(s.charAt(i)-'0'))/10){
            if(sign==1){
                return Integer.MAX_VALUE;
            }
            else{
                return Integer.MIN_VALUE;
            }
        }
        res=res*10+(s.charAt(i)-'0');
        return atoi(s,i+1,res,sign);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();

        int n=s.length();
        s=s.trim();
        int sign=1, i=0;
        if(s.charAt(i)=='-'){
            sign=-1;
            i++;
        }
        else if(s.charAt(i)=='+'){
            i++;
        }
        long res=0;
        System.out.println((int)atoi(s,i,res,sign));
    }
}