// Isomorphic String - Problem Statement : Given two strings s and t, determine if they are isomorphic. Two strings s and t are isomorphic if the characters in s can be replaced to get t.All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
//                     1) better - TC:O(N) SC:O(N)
//                     2) optimal - TC:O(N) SC:O(1)


import java.util.*;
class S5{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String t=sc.nextLine();

        if(s.length()!=t.length()){
            System.out.println("Not isomorphic");
            return;
        }

        //better
        HashMap<Character,Character> hm=new HashMap<>();
        HashSet<Character> hs=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char cs=s.charAt(i);
            char st=t.charAt(i);
            if(hm.containsKey(cs)){
                if(hm.get(cs)!=st){
                    System.out.println("not isomorphic");
                    return;
                }
            }
            else{
                if(hs.contains(st)){
                    System.out.println("not isomorphic");
                    return;
                }
                hm.put(cs, st);
                hs.add(st);
            }
        }
        System.out.println("Isomorphic");                        


        //optimal
        // int[] m1=new int[256];
        // int[] m2=new int[256];
        // for(int i=0;i<s.length();i++){
        //     if(m1[s.charAt(i)]!=m2[t.charAt(i)]){
        //         System.out.println("not isomorphic");
        //         return;
        //     }
        //     m1[s.charAt(i)]=i+1;
        //     m2[t.charAt(i)]=i+1;
        // }
        // System.out.println("Isomorphic");
    }
}