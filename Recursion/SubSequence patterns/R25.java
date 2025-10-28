// Letter Combinations of a Phone number - Problem Statement : Given a string consisting of digits from 2 to 9 (inclusive). Return all possible letter combinations that the number can represent.
//                                         1) optimal - TC:O(4^N*N) SC:O(N) Use backtracking to try all letters corresponding to each digit sequentially and build all possible combinations.


import java.util.*;
class R25{
    public static void combinations(String digits, int id, StringBuilder curr, String[] map, List<String> res){
        if(id==digits.length()){
            res.add(curr.toString());
            return;
        }
        String letters = map[digits.charAt(id) - '0'];
        for(char ch:letters.toCharArray()){
            curr.append(ch);
            combinations(digits, id+1, curr, map, res);
            curr.deleteCharAt(curr.length()-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String digits=sc.nextLine();

        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            System.out.println(res);
            return;
        }

        String[] map = {
            "",    // 0
            "",    // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs",// 7
            "tuv", // 8
            "wxyz" // 9
        };

        combinations(digits, 0, new StringBuilder(), map, res);
        System.out.println(res);
    }
}