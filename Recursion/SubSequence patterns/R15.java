// Generate Paranthesis - Problem Statement : Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//                        1) brute force - TC:O(2^(2*N)*N) SC:O(K*N)(K=valid strings)Generate all 2^(2n) binary-like strings of '(' and ')' of length 2n by recursion, and filter only those that form valid balanced parentheses using a validity check.

import java.util.*;
class R15{
    public static boolean isvalid(String s){
        int c=0;
        for(char ch:s.toCharArray()){
            if(ch=='(') c++;
            else c--;
            if(c<0) return false;
        }
        return c==0;
    }
    public static void generateallStrings(int n, String curr, List<String> res){
        if(curr.length()==2*n){
            if(isvalid(curr)) res.add(curr);
            return;
        }
        generateallStrings(n, curr+"(", res);
        generateallStrings(n, curr+")", res);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        //brute force:
        List<String> res=new ArrayList<>();
        generateallStrings(n, "", res);
        System.out.println(res);
    }
}