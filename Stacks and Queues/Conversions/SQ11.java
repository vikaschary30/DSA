// Prefix to Infix - TC:O(2N) SC:O(N) Scan the prefix expression from right to left, push operands onto a stack, and whenever an operator is found, pop two operands, combine them with parentheses, and push the result back onto the stack.

import java.util.*;
class SQ11{
    public static String PrefixtoInfix(String s, int n){
        int i=n-1;
        Stack<String> st=new Stack<>();
        while(i>=0){
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(Character.toString(ch));
            }
            else{
                String top1=st.pop();
                String top2=st.pop();
                st.push("("+top1+ch+top2+")");
            }
            i--;
        }
        return st.peek();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(PrefixtoInfix(s,s.length()));
    }
}