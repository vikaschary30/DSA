// Largest Odd Number in String - Problem Statement : You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.
//                                                    A substring is a contiguous sequence of characters within a string.
//                                1) optimal - TC:O(N)


import java.util.*;
class S3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String num=sc.next();
        for(int i=num.length()-1;i>=0;i--){
            int ch=num.charAt(i)-'0';
            if(ch%2!=0){
                System.out.println(num.substring(0,i+1));
                return;
            }
        }
    }
}

 