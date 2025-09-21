// Sum of Beauty of All Substrings - Problem Statement : The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.
//                                                       For example, the beauty of "abaacc" is 3 - 1 = 2.Given a string s, return the sum of beauty of all of its substrings.
//                                   1) brute force - TC: O(N^2) SC:O(1) Use a hashmap to incrementally count character frequencies for all substrings and sum the difference between max and min frequencies for each substring.
//                                   2) optimal - TC: O(N^2) SC:O(1) Use a frequency array to track character counts for all substrings, and sum the difference between the maximum and minimum frequencies (ignoring zeros) for each substring.

import java.util.*;
class S11{
    //  public static int beautySum(String s) {
    //     int n=s.length();
    //     int sum=0;
    //     for(int i=0;i<n;i++){
    //         HashMap<Character,Integer> hm=new HashMap<>();
    //         for(int j=i;j<n;i++){
    //             hm.put(s.charAt(j),hm.getOrDefault(s.charAt(j),0)+1);
    //             int max=Collections.max(hm.values());
    //             int min=Collections.min(hm.values());
    //             sum+=(max-min);
    //         }
    //     }
    //     return sum;
    // }

    public static int beautySum(String s){
        int n=s.length();
        int sum=0;
        for(int i=0;i<n;i++){
            int[] freq=new int[26];
            for(int j=i;j<n;j++){
                freq[s.charAt(j)-'a']++;
                int max=0;
                int min=Integer.MAX_VALUE;
                for(int k=0;k<freq.length;k++){
                    if(freq[k]>0){
                        max=Math.max(max,freq[k]);
                        min=Math.min(min,freq[k]);
                    }
                }
                sum+=(max-min);
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(beautySum(s));
    }
}