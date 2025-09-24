// Infix to Postfix - TC:O(N) SC:O(N) The code scans the infix expression left to right, outputs operands immediately, uses a stack to store operators while respecting operator precedence and parentheses, and pops operators to output when higher/equal precedence is encountered or when a closing parenthesis is found, producing the corresponding postfix expression.


import java.util.*;
class SQ9{
    public static int priority(char ch){
        if(ch=='^') return 3;
        else if(ch=='*' || ch=='/') return 2;
        else if(ch=='+' || ch=='-') return 1;
        return -1;
    }
    public static String InfixtoPostfix(String s, int n){
        Stack<Character> st=new Stack<>();
        int i=0;
        StringBuilder res=new StringBuilder();
        while(i<n){
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                res.append(ch);
            }
            else if(ch=='('){
                st.push(ch);
            }
            else if(ch==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    res.append(st.peek());
                    st.pop();
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && priority(ch)<=priority(st.peek())){
                    res.append(st.peek());
                    st.pop();
                }
                st.push(ch);
            }
            i++;
        }
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        return res.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(InfixtoPostfix(s,s.length()));
    }
}