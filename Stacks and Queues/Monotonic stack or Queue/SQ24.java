// Remove K Digits - Problem Statement : Given a string nums representing a non-negative integer, and an integer k, find the smallest possible integer after removing k digits from num.
//                   1) optimal - TC:O(N) SC:O(N)  Uses a monotonic stack to greedily remove larger digits before smaller ones, then trims leading zeros to form the smallest possible number.

import java.util.*;
class SQ24{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        int k=sc.nextInt();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && k>0 && st.peek()>s.charAt(i)){
                st.pop();
                k--;
            }
            st.push(s.charAt(i));
        }
        while(k>0){
            st.pop();
            k--;
        }
        if(st.isEmpty()){
            System.out.println("0");
            return;
        }
        StringBuilder res=new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        while(res.length()>0 && res.charAt(res.length()-1)=='0'){
            res.deleteCharAt(res.length()-1);
        }
        res.reverse();
        System.out.println(res);
    }
}