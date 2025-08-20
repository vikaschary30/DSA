// 4 sum -- 1) brute force - TC:O(N^4) SC:O(#number of Quadraplets) checks all possible quadruples with 4 nested loops and uses a HashSet to avoid duplicate combinations.
//          2) better - TC:O(N^3) SC:O(N) fixes two numbers and uses a HashSet to find the other two, avoiding duplicates with a result set.
//          3) optimal - TC:O(N^2) SC:O(1) sorts array, fixes two numbers, then applies two-pointer technique to find the remaining pair while skipping duplicates.


import java.util.*;
class Arrays33{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int t=sc.nextInt();

        //brute force
        // Set<List<Integer>> hs=new HashSet<>();
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         for(int k=j+1;k<n;k++){
        //             for(int l=k+1;l<n;l++){
        //                 if(a[i]+a[j]+a[k]+a[l]==t){
        //                     List<Integer> temp=Arrays.asList(a[i],a[j],a[k],a[l]);
        //                     temp.sort(null);
        //                     hs.add(temp);
        //                 }
        //             }
        //         }
        //     }
        // }

        // better
        // Set<List<Integer>> hs=new HashSet<>();
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         Set<Integer> s=new HashSet<>();
        //         for(int k=j+1;k<n;k++){
        //             int rem=t-(a[i]+a[j]+a[k]);
        //             if(s.contains(rem)){
        //                 List<Integer> temp=Arrays.asList(a[i],a[j],a[k],rem);
        //                 temp.sort(null);
        //                 hs.add(temp);
        //             }
        //             else{
        //                 s.add(a[k]);
        //             }
        //         }
        //     }
        // }


        //optimal
        Arrays.sort(a);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i!=0 && a[i]==a[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(j!=i+1 && a[j]==a[j-1]) continue;
                int k=j+1;
                int l=n-1;
                while(k<l){
                    int sum=a[i]+a[j]+a[k]+a[l];
                    if(sum==t){
                        List<Integer> temp=Arrays.asList(a[i],a[j],a[k],a[l]);
                        res.add(temp);
                        k++;
                        l--;
                        while(k<l && a[k]==a[k-1]) k++;
                        while(k<l && a[l]==a[l+1]) l--;
                    }
                    else if(sum<t){
                        k++;
                    }
                    else{
                        l--;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
