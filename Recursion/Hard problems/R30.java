// Word Break - Problem Statement :  Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words otherwise return false.
//              1) optimal - TC:O(L^2) SC:O(L) Uses recursion with memoization to check if the string can be segmented by trying all prefixes and caching results for each starting index.


import java.util.*;
class R30{
    public static boolean wordbreak(String s, int len, int n, int i, Set<String> hs, Boolean[] memo){
        if(i==len) return true;
        if(memo[i]!=null) return memo[i];
        for(int j=i+1;j<=len;j++){
            String word=s.substring(i,j);
            if(hs.contains(word) && wordbreak(s, len, n, j, hs, memo)){
                return memo[i]=true;
            }
        }
        return memo[i]=false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int len=s.length();
        int n=sc.nextInt();
        sc.nextLine();
        String[] worddict=new String[n];
        HashSet<String> hs=new HashSet<>();
        for(int i=0;i<n;i++){
            worddict[i]=sc.nextLine();
            hs.add(worddict[i]);
        }
        Boolean[] memo=new Boolean[len];
        System.out.println(wordbreak(s,len,n,0,hs,memo));
    }
}