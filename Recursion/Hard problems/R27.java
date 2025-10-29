// Word Search - Problem Statement : Given an m x n grid of characters board and a string word, return true if the word exists in the grid. The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
//               1) optimal - 

import java.util.*;
class R27{
    public static boolean dfs(String[][] a, String word,int m, int n, int r, int c, int id){
        if(id==word.length()) return true;
        if(r<0 || c<0 || r>=m || c>=n) return false;
        if(!a[r][c].equals(String.valueOf(word.charAt(id)))) return false;
        String temp=a[r][c];
        a[r][c]="#";
        boolean found= dfs(a, word, m, n, r-1, c, id+1) || dfs(a, word, m, n, r, c+1, id+1) || dfs(a, word, m, n, r+1, c, id+1) || dfs(a, word, m, n, r, c-1, id+1) ;
        a[r][c]=temp;
        return found; 
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        String a[][]=new String[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.next();
            }
            sc.nextLine();
        }
        String word=sc.nextLine();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j].equals(String.valueOf(word.charAt(0)))){
                    if(dfs(a,word,m,n,i,j,0)){
                        System.out.println("true");
                        return;
                    }
                }
            }
        }
        System.out.println("false");
    }
}