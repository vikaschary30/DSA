// Sort characters by frequency - Problem Statement : You are given a string s. Return the array of unique characters, sorted by highest to lowest occurring characters.If two or more characters have same frequency then arrange them in alphabetic order.
//                                1) brute force - TC:O(N+KlogK) SC:O(K) Count frequencies with HashMap, sort characters by frequency (and alphabetically for ties), then build string.
//                                2) better -  TC:O(NlogK) SC:O(K) Count frequencies, push (char, freq) into max-heap, then pop and append.
//                                3) optimal - TC:O(N) SC:O(N+K) Count frequencies, put characters into buckets indexed by frequency, traverse buckets from high to low and append.

import java.util.*;
class S12{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();

        //brute:
        // HashMap<Character,Integer> hm=new HashMap<>();
        // for(int i=0;i<n;i++){
        //     hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i), 0)+1);
        // }
        // List<Character> chars=new ArrayList<>(hm.keySet());
        // Collections.sort(chars, (a,b)->hm.get(b)-hm.get(a));
        // StringBuilder res=new StringBuilder();
        // for(char c:chars){
        //     int cnt=hm.get(c);
        //     for(int i=1;i<=cnt;i++){
        //         res.append(c);
        //     }
        // }
        // System.out.println(res);

        //better :
        // HashMap<Character,Integer> hm=new HashMap<>();
        // for(int i=0;i<n;i++){
        //     hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i), 0)+1);
        // }
        // PriorityQueue<Map.Entry<Character,Integer>> heap=new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        // heap.addAll(hm.entrySet());
        // StringBuilder res=new StringBuilder();
        // while(!heap.isEmpty()){
        //     Map.Entry<Character,Integer> map=heap.poll();
        //     for(int i=0;i<map.getValue();i++){
        //         res.append(map.getKey());
        //     }
        // }
        // System.out.println(res);


        //optimal:
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i), 0)+1);
        }
        List<Character>[] buckets=new List[n+1];
        for(char c:hm.keySet()){
            int cnt=hm.get(c);
            if(buckets[cnt]==null) buckets[cnt] = new ArrayList<>();
            buckets[cnt].add(c);
        }
        StringBuilder res=new StringBuilder();
        for(int i=buckets.length-1;i>0;i--){
            if(buckets[i]!=null){
                for(char ch:buckets[i]){
                    for(int j=0;j<i;j++){
                        res.append(ch);
                    }
                }
            }
        }
        System.out.println(res);
    }
}