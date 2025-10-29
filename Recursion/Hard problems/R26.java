// Palindrome Partitioning - Problem Statement : You are given a string s, partition it in such a way that every substring is a palindrome. Return all such palindromic partitions of string s. A palindrome string is a string that reads the same backward as forward.
//                           1) optimal - TC:O(N*2^N) SC:O(K*N)(k=no of palindromic partitions) Backtrack over all possible cut positions, and whenever the current substring is a palindrome, take it and recurse further to collect all palindromic partitions.

import java.util.*;
class R26{
    public static boolean ispalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    public static void partitioning(String s, int n, int id, List<String> curr, List<List<String>> res){
        if(id==s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=id;i<n;i++){ 
            if(ispalindrome(s,id,i)){
                curr.add(s.substring(id,i+1));
                partitioning(s, n, i+1, curr, res);
                curr.remove(curr.size()-1);  
            } 
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();

        List<List<String>> res=new ArrayList<>();
        List<String> curr=new ArrayList<>();
        partitioning(s,n,0,curr,res);
        System.out.println(res);
    }
}