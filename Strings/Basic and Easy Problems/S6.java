// check whether one string is a rotation of another - Problem Statement : Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.A shift on s consists of moving the leftmost character of s to the rightmost position.
//                                                                         For example, if s = "abcde", then it will be "bcdea" after one shift.
//                                                     1) optimal : TC:O(N) SC:O(N) Check if t is a rotation of s by seeing whether it appears as a substring in s + s.

import java.util.*;
class S6{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String t=sc.nextLine();
        String res=s+s;
        if(s.length() != t.length()) {
            System.out.println("false");
            return;
        }
        if(res.contains(t)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}