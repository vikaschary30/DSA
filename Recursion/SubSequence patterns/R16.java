// Print all the possible subsequences of the String - Problem Statement : Given a string, find all the possible subsequences of the string.
//                                                     1) brute force - TC:O(2^N*N) SC:O(2^N*N) Generate all 2^n binary masks and form subsequences based on bits.
//                                                     2) optimal - TC:O(2^N*N) SC:O(2^N*N) Recursively include or exclude each character to build subsequences


import java.util.*;
class R16{
    public static void generateSubsequences(String s, int n, int ind, StringBuilder curr, List<String> res){
        if(ind==n){
            res.add(curr.toString());
            return;
        }
        curr.append(s.charAt(ind));
        generateSubsequences(s, n, ind+1, curr, res);
        curr.deleteCharAt(curr.length()-1);
        generateSubsequences(s, n, ind+1, curr, res);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();

        //brute force:
        // List<String> res=new ArrayList<>();
        // for(int i=0;i<(1<<n);i++){
        //     StringBuilder temp=new StringBuilder();
        //     for(int j=0;j<n;j++){
        //         if(((1<<j)&i)!=0){
        //             temp.append(s.charAt(j));
        //         }
        //     }
        //     res.add(temp.toString());
        // }
        // System.out.println(res);


        //optimal:
        List<String> res=new ArrayList<>();
        StringBuilder curr=new StringBuilder();
        generateSubsequences(s,n,0,curr,res);
        System.out.println(res);
    }
}