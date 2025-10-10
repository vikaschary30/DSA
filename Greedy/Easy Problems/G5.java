// Valid Paranthesis Checker - Problem Statement :  Find the validity of an input string s that only contains the letters '(', ')' and '*'. A string entered is legitimate if
//                                                  Any left parenthesis '(' must have a corresponding right parenthesis ')'.right parenthesis ')' must have a corresponding left parenthesis '('.Left parenthesis '(' must go before the corresponding right parenthesis ')'.could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
//                             1) brute force - TC:O(3^N) SC:O(N) recursively tries all possibilities for each *—treating it as '(', ')', or empty—while tracking open parentheses count to check if a valid balance is possible at the end.
//                             2) optimal - TC:O(N) SC:O(1) Keeps track of the possible range [min, max] of open '(' counts.'min' = minimum possible opens, 'max' = maximum possible opens.Adjust per character and ensure range never invalidates.

import java.util.*;
class G5{
    public static boolean isvalid(String s, int id, int n, int c){
        if(c<0) return false;
        if(id==n) return (c==0);
        if(s.charAt(id)=='('){
            return isvalid(s, id+1, n, c+1);
        }
        if(s.charAt(id)==')'){
            return isvalid(s, id+1, n, c-1);
        }
        return isvalid(s, id+1, n, c-1) || isvalid(s, id+1, n, c) || isvalid(s, id+1, n, c+1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();


        //brute force:
        // int c=0;
        // int id=0;
        // System.out.println(isvalid(s,id,n,c));


        //optimal :
        int min=0,max=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                min++;
                max++;
            }
            else if(s.charAt(i)==')'){
                min--;
                max--;
            }
            else{
                min--;
                max++;
            }
            if(min<0) min=0;
            if(max<0){
                System.out.println("false");
                return;
            }
        }
        System.out.println((min==0)?"true":"false");
    }
}