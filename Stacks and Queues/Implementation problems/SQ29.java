// Celebrity Problem - Problem Statement : A celebrity is a person who is known by everyone else at the party but does not know anyone in return. Given a square matrix M of size N x N where M[i][j] is 1 if person i knows person j, and 0 otherwise, determine if there is a celebrity at the party. Return the index of the celebrity or -1 if no such person exists.
//                     1) brute force - TC:O(N^2) SC:O(2N) Count for each person how many know them and how many they know; a celebrity is someone known by everyone else (knowme[i] = n-1) and knows no one (iknow[i] = 0).
//                     2) optimal - 


import java.util.*;
class SQ29{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] a=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }

        //brute force:
        int[] knowme=new int[n];
        int[] iknow=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]==1){
                    knowme[j]++;
                    iknow[i]++;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(knowme[i]==n-1 && iknow[i]==0){
                System.out.println(i);
                return;
            }
        }
        System.out.println("-1");
    }
}