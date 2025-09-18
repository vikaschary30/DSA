// Remove Outermost Parentheses - Problem Statement : A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
//                                                    For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
//                                                    Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
//                                1) Stack - TC:O(N) SC:O(N) using a stack to skip the outermost parentheses of each primitive substring while appending only the inner ones to the result.

import java.util.*;
class S1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();

        StringBuilder res=new StringBuilder();
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                if(!st.isEmpty()){
                    res.append(ch);
                }
                st.push(ch);
            }
            else{
                st.pop();
                if(!st.isEmpty()){
                    res.append(ch);
                }
            }
        }
        System.out.println(res.toString());
    }
}