// pascal's triangle -- 1) variation 1 - Computes a single binomial coefficient (n-1 c r-1 ) efficiently without factorials.
//                      2) variation 2 - Generates the entire n-th row of Pascal’s triangle using iterative nCr.
//                      3) variation 3 - Builds the full Pascal’s triangle up to row n by collecting all rows.



import java.util.*;
class Arrays30{
    
    //variation 1
    public static int ncr(int n, int r){
        int ans=1;
        for(int i=0;i<r;i++){
            ans=ans*(n-i);
            ans=ans/(i+1);
        }
        return ans;
    } 

    //variation 2
    public static List<Integer> pascalrow(int n){
        int ans=1;
        List<Integer> res=new ArrayList<>();
        res.add(1);
        for(int i=1;i<n;i++){
            ans=ans*(n-i);
            ans=ans/(i);
            res.add(ans);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int r=sc.nextInt();
        int c=sc.nextInt();
        // int var1 = ncr(r-1,c-1);
        // System.out.println(var1);


        //variation 3
        List<List<Integer>> res=new ArrayList<>();
        for(int i=1;i<=n;i++){
            res.add(pascalrow(i));
        }
        
        System.out.println(res);
    }
}