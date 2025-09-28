// Sort characters by frequency - Problem Statement : You are given a string s. Return the array of unique characters, sorted by highest to lowest occurring characters.If two or more characters have same frequency then arrange them in alphabetic order.
//                                1) brute force -

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


        
    }
}