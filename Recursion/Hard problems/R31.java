// Sudoku Solver - Problem Statement :  Given a 9x9 incomplete sudoku, solve it such that it becomes valid sudoku. Valid sudoku has the following properties.1. All the rows should be filled with numbers(1 - 9) exactly once.2. All the columns should be filled with numbers(1 - 9) exactly once.3. Each 3x3 submatrix should be filled with numbers(1 - 9) exactly once.Note: Character '.' indicates empty cell.
//                 1) optimal - TC:O(9^N) SC:O(81 ~ 1) Recursively fills each empty cell '.' with digits '1'–'9', checking row, column, and 3×3 box validity at each step, and backtracks when a placement violates Sudoku rules until the board is completely solved.

import java.util.*;
class R31{
    public static boolean solve(char[][] a){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(a[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isvalid(a,i,j,c)){
                            a[i][j]=c;
                            if(solve(a)){
                                return true;
                            }
                            else{
                                a[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isvalid(char[][] a, int row, int col, char c){
        for(int i=0;i<9;i++){
            if(a[row][i]==c) return false;
            if(a[i][col]==c) return false;
            if(a[3*(row/3)+i/3][3*(col/3)+i%3]==c) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[][] a=new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                a[i][j]=sc.next().charAt(0);
            }
        }
        solve(a);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}