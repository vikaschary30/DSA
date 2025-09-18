// Reverse Words in a String - Problem Statement: Given a string s, reverse the words of the string.
//                             1) brute force - TC:O(N) SC:O(N) Split the string into words, push them onto a stack, and pop them back to build the sentence in reverse order.
//                             2) optimal - TC:O(N) SC:O(1) The code constructs each word while traversing and prepends it to the result string, reversing the word order without extra data structures.


import java.util.*;
class S2{
    public static String resultString(String s){
        s=s.trim();
        int left=0, right=s.length()-1;
        String temp="";
        String ans="";
        while(left<=right){
            char ch=s.charAt(left);
            if(ch!=' '){
                temp+=ch;
            }
            else if(ch==' '){
                if(!ans.isEmpty()){
                    ans=temp+" "+ans;
                }
                else{
                    ans=temp;
                }
                temp="";
            }
            left++;
        }
        if(!temp.isEmpty()){
            if(!ans.isEmpty()){
                ans=temp+" "+ans;
            }
            else{
                ans=temp;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();

        // brute force
        // Stack<String> st=new Stack<>();
        // String res="";
        // for(int i=0;i<s.length();i++){
        //     if(s.charAt(i)==' '){
        //         if(!res.isEmpty()){
        //             st.push(res);
        //             res="";
        //         }
        //     }
        //     else{
        //         res+=s.charAt(i);
        //     }
        // }
        // if(!res.isEmpty()){
        //     st.push(res);
        // }
        // String ans="";
        // while(!st.isEmpty()){
        //     ans+=st.pop();
        //     if(!st.isEmpty()){
        //         ans+=" ";
        //     }
        // }
        // System.out.println(ans);

        //optimal
        System.out.println(resultString(s));
    }
}