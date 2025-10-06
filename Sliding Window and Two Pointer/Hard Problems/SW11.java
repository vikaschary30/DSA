// Minimum Window Substring - Problem Statement : Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
//                            1) brute force - TC:O(N^2) SC:O(256) For every starting index, rebuild the frequency map of t and expand the window until all characters of t are matched, then update the minimum window length if smaller.
//                            2) optimal - TC:O(N) SC:O(256) Use a sliding window and frequency map of t, expand right to include characters, decrement their counts, and shrink left when all characters are matched, updating the minimum window length.


import java.util.*;
class SW11{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        String t=sc.nextLine();
        int m=t.length();

        //brute force:
        // int minlen=Integer.MAX_VALUE,c=0,stind=-1;
        // for(int i=0;i<n;i++){
        //     HashMap<Character,Integer> hm=new HashMap<>();
        //     c=0;
        //      for(int j=0;j<m;j++){
        //          hm.put(t.charAt(j), hm.getOrDefault(t.charAt(j), 0)+1);
        //      }
        //     for(int j=i;j<n;j++){
        //         if(hm.containsKey(s.charAt(j)) && hm.get(s.charAt(j))>0){
        //             c++;
        //             hm.put(s.charAt(j),hm.getOrDefault(s.charAt(j),0)-1);
        //         }
        //         if(c==m){
        //             if(minlen>(j-i+1)){
        //                 minlen=(j-i+1);
        //                 stind=i;
        //                 break;
        //             }
        //         }
        //     }
        // }


        //optimal:
        int minlen=Integer.MAX_VALUE,c=0,stind=-1;
        int l=0,r=0;
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int j=0;j<m;j++){
            hm.put(t.charAt(j), hm.getOrDefault(t.charAt(j), 0)+1);
        }
        while(r<n){
            if(hm.containsKey(s.charAt(r))){
                hm.put(s.charAt(r), hm.get(s.charAt(r))-1);
                if(hm.get(s.charAt(r))>=0){
                    c++;
                }
            }
            while(c==m){
                if(minlen>(r-l+1)){
                    minlen=(r-l+1);
                    stind=l;
                }
                if(hm.containsKey(s.charAt(l))){
                    hm.put(s.charAt(l),hm.get(s.charAt(l))+1);
                    if(hm.get(s.charAt(l))>0){
                        c--;
                    }
                }
                l++;
            }
            r++;
        }
        if(stind==-1){
            System.out.println("");
            return;
        }
        System.out.println(s.substring(stind, stind+minlen));
    }
}