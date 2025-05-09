class Solution {
    public int evalRPN(String[] tokens) {
        int ans=0;
        Stack<Integer> st=new Stack<>();
        for(String token: tokens){
            if(!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")){
                int tk=Integer.parseInt(token);
                st.push(tk);
            }
            else{
                int a=st.pop();
                int b=st.pop();
                if(token.equals("+")){
                    ans=b+a;
                    st.push(ans);
                }
                if(token.equals("-")){
                    ans=b-a;
                    st.push(ans);
                }
                if(token.equals("*")){
                    ans=b*a;
                    st.push(ans);
                }
                if(token.equals("/")){
                    ans=b/a;
                    st.push(ans);
                }
            }
        }
        return st.pop();
    }
}