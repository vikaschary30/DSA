class Solution {
    public boolean isValid(String s) {
        if(s.length()<=1){
            return false;
        }
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                st.push(ch);
            }
            else
            {
                if(st.isEmpty()){
                    return false;
                }
                char top=st.pop();
                if((ch=='(' && top!=')') || (ch=='[' && top!=']') || (ch=='{' && top!='}')){
                    return false;
                }
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;   
    }
}