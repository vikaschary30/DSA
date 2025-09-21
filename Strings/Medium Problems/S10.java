// Longest Palindromic Substring - Problem Statement : Given a string s, return the longest palindromic substring in s.
//                                 1) better - TC:O(n^2) SC:O(1) Check each character as the center, expand outward for odd and even palindromes, and track the longest substring.


import java.util.*;
class S10{
    public static int expand(char[] st, int left, int right) {
        while(left>=0 && right<st.length && st[left]==st[right]){
            left--;
            right++;
        }
        return right-left-1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        if(s.isEmpty()){
            System.out.println("no string");
            return;
        }
        int n=s.length();
        char[] st=s.toCharArray();
        int maxlen=0, start=0;
        for(int i=0;i<n;i++){
            int oddlen=expand(st,i,i);
            int evenlen=expand(st,i,i+1);
            int len=Math.max(oddlen,evenlen);
            if(len>maxlen){
                maxlen=len;
                start=i-((len-1)/2);
            }
        }
        System.out.println(s.substring(start,start+maxlen));
    }
}