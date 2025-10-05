// Longest Substring with At Most K Distinct Characters - Problem Statement : Given a string s and an integer k.Find the length of the longest substring with at most k distinct characters
//                                                        1) brute force - TC:O(N^2) SC:O(N) For each starting index, expand the substring to the right while tracking distinct characters in a set, update the maximum length when there are at most k distinct characters, and break if it exceeds k.


import java.util.*;
class SW9{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        int k=sc.nextInt();

        //brute force:
        int max=0;
        for(int i=0;i<n;i++){
            HashSet<Character> hs=new HashSet<>();
            for(int j=i;j<n;j++){
                hs.add(s.charAt(j));
                if(hs.size()>k){
                    break;
                }
                max=Math.max(max, j-i+1);
            }
        }
        System.out.println(max);
    }
}