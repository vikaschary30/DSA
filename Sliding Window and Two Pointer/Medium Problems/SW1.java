// Length of Longest Substring without any Repeating Character - Problem Statement : Given a String, find the length of longest substring without any repeating character.
//                                                               1) brute force - TC:O(N^2) SC:O(N) finds the length of the longest substring without repeating characters by checking all possible substrings using a nested loop and a HashSet to track seen characters.
//                                                               2) optimal - 


import java.util.*;
class SW1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();

        //brute force:
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            HashSet<Character> hs=new HashSet<>();
            for(int j=i;j<n;j++){
                if(hs.contains(s.charAt(j))){
                    break;
                }
                hs.add(s.charAt(j));
                max=Math.max(max, j-i+1);
            }
        }
        System.out.println(max);
    }
}