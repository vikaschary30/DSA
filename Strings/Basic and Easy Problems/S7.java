// Check if two Strings are anagrams of each other - Problem Statement :  Given two strings, check if two strings are anagrams of each other or not.
//                                                   1)better : TC:O(NlogN) SC:O(N) Sort both strings and check if the sorted strings are identical.
//                                                   2)optimal : TC:O(N) SC:O(N) Count character frequencies in both strings and check if the frequency maps are equal.
//                                                   3)others :
//                                                          a) Single frequency array approach: Increment counts for characters in the first string and decrement for the second; if all counts are zero, they are anagrams.
//                                                          b) Update counts in one map by incrementing for the first string and decrementing for the second; if all values are zero, the strings are anagrams.

import java.util.*;
class S7{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        if(s1.length()!=s2.length()){
            System.out.println("not anagram");
            return;
        }

        //optimal
        HashMap<Character,Integer> hm1=new HashMap<>();
        HashMap<Character,Integer> hm2=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            hm1.put(s1.charAt(i), hm1.getOrDefault(s1.charAt(i),0)+1);
            hm2.put(s2.charAt(i), hm2.getOrDefault(s2.charAt(i),0)+1);
        }
        if(hm1.equals(hm2)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }


        //better
        // char[] c1=s1.toCharArray();
        // char[] c2=s2.toCharArray();
        // Arrays.sort(c1);
        // Arrays.sort(c2);
        // String r1=new String(c1);
        // String r2=new String(c2);
        // if(r1.equals(r2)){
        //     System.out.println("true");
        // }
        // else{
        //     System.out.println("false");
        // }
    }
}