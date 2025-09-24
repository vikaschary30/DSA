// Prefix to Postfix - TC:O(N) SC:O(N) Scan the prefix expression from right to left. Push operands onto a stack. For an operator, pop two operands, combine as operand1 operand2 operator (postfix form), and push back. At the end, the stack contains the postfix expression.

import java.util.*;
class SQ13{
    public static String PrefixtoPostfix(String s, int n){
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
                st.push(top1+top2+ch);
            }
            i--;
        }
        return st.peek();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(PrefixtoPostfix(s,s.length()));
    }
}