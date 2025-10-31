// Rat in a Maze -  Problem Statement :  Given a grid of dimensions n x n. A rat is placed at coordinates (0, 0) and wants to reach at coordinates (n-1, n-1). Find all possible paths that rat can take to travel from (0, 0) to (n-1, n-1). The directions in which rat can move are 'U' (up) , 'D' (down) , 'L' (left) , 'R' (right).The value 0 in grid denotes that the cell is blocked and rat cannot use that cell for travelling, whereas value 1 represents that rat can travel through the cell. If the cell (0, 0) has 0 value, then mouse cannot move to any other cell.
//                 1) brute force - TC:O(4^(N*N)) SC:O(N^2) It uses backtracking to explore all possible paths from (0, 0) to (n−1, n−1), moving in all four directions (‘U’, ‘D’, ‘L’, ‘R’) while marking and unmarking visited cells to avoid revisiting.
//                 2) optimal - TC:O(4^(N*N)) SC:O(N^2) It uses optimized backtracking with direction arrays (di, dj) and a direction string "DLRU" to explore all valid paths from the start to the destination, marking visited cells and efficiently iterating over all 4 moves in a loop.

import java.util.*;
class R29{
    public static boolean isSafe(int i, int j, int n, int[][] grid, int[][] visited) {
        return (i >= 0 && i < n && j >= 0 && j < n &&
                grid[i][j] == 1 && visited[i][j] == 0);
    }
    // public static void solve(int i, int j, int n, int[][] grid, int[][] visited, String curr, List<String> res){
    //     if(i==n-1 && j==n-1){
    //         res.add(curr.toString());
    //         return;
    //     }
    //     visited[i][j]=1;
    //     if(isSafe(i+1, j, n, grid, visited)){
    //         solve(i+1, j, n, grid, visited, curr+"D", res);
    //     }
    //     if(isSafe(i, j-1, n, grid, visited)){
    //         solve(i, j-1, n, grid, visited, curr+"L", res);
    //     }
    //     if(isSafe(i, j+1, n, grid, visited)){
    //         solve(i, j+1, n, grid, visited, curr+"R", res);
    //     }
    //     if(isSafe(i-1, j, n, grid, visited)){
    //         solve(i-1, j, n, grid, visited, curr+"U", res);
    //     }
    //     visited[i][j]=0;
    // }

    //optimal:
     public static void solve(int i, int j, int n, int[][] grid, int[][] visited, String curr, int[] di, int[] dj, List<String> res){
        if(i==n-1 && j==n-1){
            res.add(curr);
            return;
        }
        String dir="DLRU";
        for(int ind=0;ind<4;ind++){
            int nexti=i+di[ind];
            int nextj=j+dj[ind];
            if(nexti>=0 && nextj>=0 && nexti<n && nextj<n && visited[nexti][nextj]==0 && grid[nexti][nextj]==1){
                visited[i][j]=1;
                solve(nexti, nextj, n, grid, visited, curr+dir.charAt(ind), di, dj, res);
                visited[i][j]=0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] grid=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        List<String> res=new ArrayList<>();
        int[][] visited = new int[n][n];
        int[] di={+1,0,0,-1};
        int[] dj={0,-1,1,0};
        if (grid[0][0] == 1) {
            solve(0, 0, n, grid, visited, "", di, dj, res);
        }
        System.out.println(res);
    }
}