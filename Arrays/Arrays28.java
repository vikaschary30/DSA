//spiral matrix printing -- 1) only one way - O(N^2) Use four boundaries (top, bottom, left, right) and traverse layer by layer in spiral order until all elements are covered.


import java.util.*;
class Arrays28{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int a[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j]=sc.nextInt();
            }
        }
        List<Integer> res=new ArrayList<>();
        int top=0, bottom=n-1;
        int left=0, right=m-1;
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                res.add(a[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                res.add(a[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    res.add(a[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    res.add(a[i][left]);
                }
                left++;
            }
        }
        System.out.println(res);
    }
}