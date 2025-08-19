// 3 sum -- 1) brute force - TC:O(N^3) SC:O(#number of triplets) Try all possible triplets and use a set to store unique ones whose sum is zero.
//          2) better - TC:O(N^2) SC:O(N) Fix one element and solve 2-Sum using a hashset, storing unique triplets in a set.
//          3) optimal - TC:O(N^2) SC:O(1) Sort the array and use two pointers for each fixed element to find unique triplets.



import java.util.*;
class Arrays32{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        // Set<List<Integer>> hs=new HashSet<>();
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         for(int k=j+1;k<n;k++){
        //             if(a[i]+a[j]+a[k]==0){
        //                 List<Integer> temp=Arrays.asList(a[i],a[j],a[k]);
        //                 temp.sort(null);
        //                 hs.add(temp);
        //             }
        //         }
        //     }
        // }

        // Set<List<Integer>> hs=new HashSet<>();
        // for(int i=0;i<n;i++){
        //     HashSet<Integer> s= new HashSet<>();
        //     for(int j=i+1;j<n;j++){
        //         int rem=-(a[i]+a[j]);
        //         if(s.contains(rem)){
        //             List<Integer> temp=Arrays.asList(a[i],a[j],rem);
        //             temp.sort(null);
        //             hs.add(temp);
        //         }
        //         else{
        //             s.add(a[j]);
        //         }
        //     }
        // }
        
        
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(a);
        for(int i=0;i<n;i++){
            if(i!=0 && a[i]==a[i-1]) continue;
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=a[i]+a[j]+a[k];
                if(sum<0){
                    j++;
                }
                else if(sum>0){
                    k--;
                }
                else{   
                    List<Integer> temp=Arrays.asList(a[i],a[j],a[k]);
                    res.add(temp);
                    j++;
                    k--;
                    while(j<k && a[j]==a[j-1]) j++;
                    while(j<k && a[k]==a[k+1]) k--;
                }
            }
        }

        System.out.println(res);
    }
}