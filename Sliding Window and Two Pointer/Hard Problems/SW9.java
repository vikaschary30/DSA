// Longest Substring with At Most K Distinct Characters - Problem Statement : Given a string s and an integer k.Find the length of the longest substring with at most k distinct characters
//                                                        1) brute force - TC:O(N^2) SC:O(N) For each starting index, expand the substring to the right while tracking distinct characters in a set, update the maximum length when there are at most k distinct characters, and break if it exceeds k.
//                                                        2) optimal - TC:O(N) SC:O(N) Use two pointers to maintain a window with at most k distinct characters, track frequencies in a hashmap, shrink from the left when distinct characters exceed k, and update maximum length dynamically.


import java.util.*;
class SW9{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        int k=sc.nextInt();

         if (k == 0 || s.length() == 0){
            System.out.println("0");
            return;
         }

        //brute force:
        // int max=0;
        // for(int i=0;i<n;i++){
        //     HashSet<Character> hs=new HashSet<>();
        //     for(int j=i;j<n;j++){
        //         hs.add(s.charAt(j));
        //         if(hs.size()>k){
        //             break;
        //         }
        //         max=Math.max(max, j-i+1);
        //     }
        // }
        // System.out.println(max);


        //optimal:
        int l=0,r=0;
        int max=0;
        HashMap<Character,Integer> hm=new HashMap<>();
        while(r<n){
            hm.put(s.charAt(r),hm.getOrDefault(s.charAt(r), 0)+1);
            if(hm.size()>k){
                if(hm.containsKey(s.charAt(l))){
                    hm.put(s.charAt(l),hm.get(s.charAt(l))-1);
                }
                if(hm.get(s.charAt(l))==0){
                    hm.remove(s.charAt(l));
                }
                l++;
            }
            max=Math.max(max, r-l+1);
            r++;
        }
        System.out.println(max);
    }
}