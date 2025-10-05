// Number of substring containing all three characters - Problem Statement : Given a string s , consisting only of characters 'a' , 'b' , 'c'.Find the number of substrings that contain at least one occurrence of all these characters 'a' , 'b' , 'c'.
//                                                       1) brute force - TC:O(N^2) SC:O(3) For each starting index, expand the substring until all three characters 'a', 'b', and 'c' are found, then directly add all possible extensions to the count.
//                                                       2) optimal - TC:O(N) SC:O(1) Track the latest index of each character (a, b, c), and whenever all are seen, add 1 + min(lastA, lastB, lastC) to count all valid substrings ending at the current position.


import java.util.*;
class SW7{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();

        //brute force:
        // int c=0;
        // for(int i=0;i<n;i++){
        //     int[] freq=new int[3];
        //     for(int j=i;j<n;j++){
        //         freq[s.charAt(j)-'a']++;
        //         if(freq[0]>0 && freq[1]>0 && freq[2]>0){
        //             c++;
        //         }
        //     }
        // }
        // System.out.println(c);


        //optimal:
        int c=0;
        int[] freq={-1,-1,-1};
        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']=i;
            if(freq[0]!=-1 && freq[1]!=-1 && freq[2]!=-1){
                c+=(1+Math.min(freq[0],Math.min(freq[1],freq[2])));
            }
        }
        System.out.println(c);
    }
}