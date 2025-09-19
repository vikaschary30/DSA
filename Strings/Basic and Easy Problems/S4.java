// Longest Common Prefix - Problem Statement : Write a function to find the longest common prefix string amongst an array of strings. If there is no common prefix, return an empty string "".
//                         1) better : TC:O(N*M*logN)
//                         2) optimal : TC:O(N*M)
import java.util.*;
class S4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] s=new String[n];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        // Arrays.sort(s);
        // String s1=s[0];
        // String s2=s[n-1];
        // int p1=0;
        // while(p1 < s1.length() && p1 < s2.length() && s1.charAt(p1) == s2.charAt(p1)){
        //     p1++;
        // }
        // System.out.println(s1.substring(0,p1));

        //
        String s1=s[0];
        for(int i=1;i<n;i++){
            while(!s[i].startsWith(s1)){
                s1=s1.substring(0, s1.length()-1);
                if(s1.equals("")){
                    System.out.println("");
                    return;
                }
            }
        }
        System.out.println(s1);
    }
}