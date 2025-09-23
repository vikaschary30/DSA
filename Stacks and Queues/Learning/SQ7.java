// Check for Balanced Parentheses - Problem Statement : Check Balanced Parentheses. Given string str containing just the characters '(', ')', '{', '}', '[' and ']', check if the input string is valid and return true if the string is balanced otherwise return false.
//                                  1) optimal - TC:O(N) SC:O(N) Use a stack to push opening brackets and match them with closing brackets as they appear; if all match correctly and the stack is empty at the end, the string is balanced.

import java.util.*;
class SQ7{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        if(n<=1){
            System.out.println("false");
            return;
        }
        java.util.Stack<Character> st1=new java.util.Stack<>();
        for(char ch: s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                st1.push(ch);
            }
            else{
                if(st1.isEmpty()){
                    System.out.println("false");
                    return;
                }
                char popped=st1.pop();
                if((ch==')' && popped!='(') || (ch==']' && popped!='[') || (ch=='}' && popped!='{')){
                    System.out.println("false");
                    return;
                }
            }
        }
        if(st1.isEmpty()){
            System.out.println("true");
            return;
        }
        System.out.println("false");
        return;
    }
}