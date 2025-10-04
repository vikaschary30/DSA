// longest repeating character replacement - Problem Statement : Given an integer k and a string s, any character in the string can be selected and changed to any other uppercase English character. This operation can be performed up to k times. After completing these steps, return the length of the longest substring that contains the same letter.
//                                           1) brute force - TC:O(N^2) SC:O(26) Check every substring, count character frequencies, and pick the longest valid one within k changes.
//                                           2) better - TC:O(2N) SC:O(26) Use a sliding window with a HashMap to track frequencies, shrinking the window when changes exceed k.
//                                           3) optimal - TC:O(2N) SC:O(26) Use sliding window with a frequency array and track max frequency on the fly.


import java.util.*;
class SW4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        int k=sc.nextInt();

        //brute force:
        // int max=0;
        // for(int i=0;i<n;i++){
        //     HashMap<Character,Integer> hm=new HashMap<>();
        //     int maxfreq=0;
        //     for(int j=i;j<n;j++){
        //         hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0)+1);
        //         maxfreq=Math.max(maxfreq, hm.get(s.charAt(j)));
        //         int changes=(j-i+1)-maxfreq;
        //         if(changes<=k){
        //             max=Math.max(max, j-i+1);
        //         }
        //     }
        // }
        // System.out.println(max);

        
        // better:
        // int max=0;
        // HashMap<Character,Integer> hm=new HashMap<>();
        // int l=0,r=0;
        // int maxfreq=0;
        // while(r<n){
        //     hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0)+1);
        //     int freq=hm.get(s.charAt(r));
        //     maxfreq=Math.max(maxfreq, freq);
        //     while((r-l+1)-maxfreq>k){
        //         hm.put(s.charAt(l), hm.get(s.charAt(l))-1);
        //         l++;
        //     }
        //     if((r-l+1)-maxfreq<=k){
        //         max=Math.max(max, r-l+1);
        //     }
        //     r++;
        // }
        // System.out.println(max);


        //optimal:
        int max=0;
        HashMap<Character,Integer> hm=new HashMap<>();
        int l=0,r=0;
        int maxfreq=0;
        while(r<n){
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0)+1);
            int freq=hm.get(s.charAt(r));
            maxfreq=Math.max(maxfreq, freq);
            if((r-l+1)-maxfreq>k){
                hm.put(s.charAt(l), hm.get(s.charAt(l))-1);
                l++;
            }
            max=Math.max(max, r-l+1);
            r++;
        }
        System.out.println(max);
    }
}