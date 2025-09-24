// Postfix to Prefix - TC:O(N) SC:O(N) Scan the postfix expression left to right. Push operands onto a stack. When an operator is found, pop two operands, combine as operator operand1 operand2 (prefix form), and push the result back. At the end, the stack contains the prefix expression.

import java.util.*;
class SQ14{
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
                st.push(ch+top2+top1);
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