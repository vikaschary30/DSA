class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        int maxval=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }
            else
            {
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }
                else{
                    maxval=Math.max(maxval,(i-st.peek()));
                }
            }
        }
        return (maxval==0)? 0: maxval;
    }
}