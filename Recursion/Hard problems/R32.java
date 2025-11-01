// Expression Add Operators - Problem Statement : Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.Note that operands in the returned expressions should not contain leading zeros.Note that a number can contain multiple digits.
//                            1) optimal - Recursively inserts '+', '-', or '*' between digits, evaluating partial expressions while preserving multiplication precedence, and collects those that evaluate exactly to the target.

import java.util.*;
class R32{
    public static void solve(String num, int k, int id, long curr, long prev, String exp, List<String> res){
        if(id==num.length()){
            if(curr==k){
                res.add(exp);
            }
            return;
        }
        for(int i=id;i<num.length();i++){
            if (i != id && num.charAt(id) == '0') break;
            String val=num.substring(id, i+1);
            long value=Long.parseLong(val);
            if(id==0){
                solve(num, k, i+1, value, value, val, res);
            }
            else{
                solve(num, k, i+1, curr+value, value, exp+"+"+val, res);
                solve(num, k, i+1, curr-value, -value, exp+"-"+val, res);
                solve(num, k, i+1, curr-prev+prev*value, prev*value, exp+"*"+val, res);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String num=sc.nextLine();
        int target=sc.nextInt();
        List<String> res=new ArrayList<>();
        solve(num,target,0,0,0,"",res);
        System.out.println(res);
    }
}