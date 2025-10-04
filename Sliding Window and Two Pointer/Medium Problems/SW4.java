// longest repeating character replacement - Problem Statement : Given an integer k and a string s, any character in the string can be selected and changed to any other uppercase English character. This operation can be performed up to k times. After completing these steps, return the length of the longest substring that contains the same letter.
//                                           1) brute force - 


import java.util.*;
class SW4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        int k=sc.nextInt();

        //brute force:
        int max=0;
        for(int i=0;i<n;i++){
            HashMap<Character,Integer> hm=new HashMap<>();
            int maxfreq=0;
            for(int j=i;j<n;j++){
                hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0)+1);
                maxfreq=Math.max(maxfreq, hm.get(s.charAt(j)));
                int changes=(j-i+1)-maxfreq;
                if(changes<=k){
                    max=Math.max(max, j-i+1);
                }
            }
        }
        System.out.println(max);

        
        
    }
}