// Postfix to Infix - TC:O(N) SC:O(N) Scan the postfix expression from left to right, push operands onto a stack, and whenever an operator is found, pop two operands, combine them with parentheses in the order operand1 operator operand2, and push the result back.

import java.util.*;
class SQ12{
    public static String PostfixtoInfix(String s, int n){
        int i=0;
        Stack<String> st=new Stack<>();
        while(i<n){
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(Character.toString(ch));
            }
            else{
                String top1=st.pop();
                String top2=st.pop();
                st.push("("+top2+ch+top1+")");
            }
            i++;
        }
        return st.peek();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(PostfixtoInfix(s,s.length()));
    }
}