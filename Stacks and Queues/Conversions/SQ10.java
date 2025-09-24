// Infix to Prefix - TC:O(N) SC:O(N) Reverse the infix expression (swap parentheses), convert it to postfix using a stack respecting operator precedence and associativity, then reverse the result to get the prefix expression.


import java.util.*;
class SQ10{
    public static int priority(char ch){
        if(ch=='^') return 3;
        else if(ch=='*' || ch=='/') return 2;
        else if(ch=='+' || ch=='-') return 1;
        return -1;
    }
    public static String reverse(String s, int n){
        StringBuilder rev = new StringBuilder();
        for(int i = n-1; i>=0; i--){
            char ch = s.charAt(i);
            if(ch=='(') rev.append(')');
            else if(ch==')') rev.append('(');
            else rev.append(ch);
        }
        return rev.toString();
    }
    public static String InfixtoPrefix(String s, int n){
        s=reverse(s,n);
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
                if(!st.isEmpty()) st.pop();
            }
            else{
                if(ch=='^'){
                    while(!st.isEmpty() && priority(ch)<priority(st.peek())){
                        res.append(st.peek());
                        st.pop();
                    }
                    st.push(ch);
                }
                else{
                    while(!st.isEmpty() && priority(ch)<=priority(st.peek())){
                        res.append(st.peek());
                        st.pop();
                    }
                    st.push(ch);
                }
            }
            i++;
        }
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        return res.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(InfixtoPrefix(s,s.length()));
    }
}