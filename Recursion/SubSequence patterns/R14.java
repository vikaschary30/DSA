// Generate all binary strings - Problem Statement : Given an integer n, return all binary strings of length n that do not contain consecutive 1s. Return the result in lexicographically increasing order.
//                               1) optimal - TC:O(2^N) SC:O(K*N)(K=no of strings) Recursively build strings of length n by always appending '0' and appending '1' only when the previous character is not '1', collecting all valid results in lexicographic order.

import java.util.*;
class R14{
    public static void binaryStrings(int n, String temp, List<String> res){
        if(temp.length()==n){
            res.add(temp);
            return;
        }
        binaryStrings(n, temp+"0", res);
        if(temp.isEmpty() || !temp.endsWith("1")){
            binaryStrings(n, temp+"1", res);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<String> res=new ArrayList<>();
        binaryStrings(n, "", res);
        System.out.println(res);
    }
}