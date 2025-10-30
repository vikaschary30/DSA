// N Queen Problem - Problem Statement :  The n-queens is the problem of placing n queens on n × n chessboard such that no two queens can attack each other. Given an integer n, return all distinct solutions to the n -queens puzzle. Each solution contains a distinct boards configuration of the queen's placement, where ‘Q’ and ‘.’ indicate queen and empty space respectively.
//                   1) brute force - TC:O(N!) SC:O(N^2) It uses backtracking to place queens column by column, ensuring no two queens attack each other by checking rows and diagonals for safety before proceeding recursively.
//                   2) optimal - TC:O(N!) SC:O(N^2) It optimizes N-Queens backtracking by using three auxiliary arrays (leftrow, upperdiagonal, lowerdiagonal) to check queen safety in O(1) time instead of scanning the board, significantly reducing redundant checks.

import java.util.*;
class R28{
    public static boolean issafe(int row, int col, char[][] board, int n){
        for(int j=col;j>=0;j--){
            if(board[row][j]=='Q') return false;
        }
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }
        for(int i=row,j=col;i<n && j>=0;i++,j--){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
    //brute force:
    // public static void nqueens(int n, int col, char[][] board, List<List<String>> res){
    //     if(col==n){
            // List<String> temp=new ArrayList<>();
            // for(int i=0;i<n;i++){
            //     temp.add(new String(board[i]));
            // }
            // res.add(temp);
            // return;
    //     }
    //     for(int row=0;row<n;row++){
    //         if(issafe(row,col,board,n)){
    //             board[row][col]='Q';
    //             nqueens(n, col+1, board, res);
    //             board[row][col]='.';
    //         }
    //     }
    // }

    //optimal:
    public static void nqueens(int n, int col, char[][] board, List<List<String>> res, int[] leftrow, int[] upperdiagonal, int[] lowerdiagonal){
        if(col==n){
            List<String> temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            res.add(temp);
            return;
        }
        for(int row=0;row<n;row++){
            if(leftrow[row]==0 && upperdiagonal[n-1+col-row]==0 && lowerdiagonal[row+col]==0){
                board[row][col]='Q';
                leftrow[row]=1;
                upperdiagonal[n-1+col-row]=1;
                lowerdiagonal[row+col]=1;
                nqueens(n, col+1, board, res, leftrow, upperdiagonal, lowerdiagonal);
                board[row][col]='.';
                leftrow[row]=0;
                upperdiagonal[n-1+col-row]=0;
                lowerdiagonal[row+col]=0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i], '.');
        }
        List<List<String>> res=new ArrayList<>();
        int[] leftrow=new int[n];
        int[] upperdiagonal=new int[2*n-1];
        int[] lowerdiagonal=new int[2*n-1];
        nqueens(n,0,board,res,leftrow,upperdiagonal,lowerdiagonal);
        System.out.println(res);
    }
}