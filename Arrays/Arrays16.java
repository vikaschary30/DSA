// Two sum -- i) return boolean                      -- 1) brute force - O(N^2) iterate through all the array while having one element.
//    |                                                 2) better - O(N) use hashset and store the values, if k-a[i] is present in the hashset then return true.             
//    |                                                 3) optimal - O(N) use 2 pointer technique i.e i from 0 and j from n-1, then add them up and compare with the target.
//    |
//    |
//    |------ ii) return the indices of the elements -- 1) brute force - O(N^2) iterate through all the array while having one element and store the indices.
//                                                      2) optimal - O(N) use hashmap and store the values with indices, if k-a[i] is present in the hashmap then store the indices of the elements through hashmap.             


import java.util.*;
class Arrays16{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        } 
        int k=sc.nextInt();

        // FIRST VARIANT:

                // brute force:
                // int f=0;
                // for(int i=0;i<n;i++){
                //     for(int j=i+1;j<n;j++){
                //         if((a[i]+a[j])==k){
                //             f=1;
                //             break;
                //         }
                //     }
                // }
                // if(f==1){
                //     System.out.println("Yes");
                // }
                // else{
                //     System.out.println("No");
                // }

                // better:
                // int f=0;
                // HashSet<Integer> hs=new HashSet<>();
                // for(int i=0;i<n;i++){
                //     int rem=k-a[i];
                //     if(hs.contains(rem)){
                //        f=1;
                //        break; 
                //     }
                //     hs.add(a[i]);
                // }
                // if(f==1){
                //     System.out.println("Yes");
                // }
                // else{
                //     System.out.println("No");
                // }

                //optimal:
                // int sum=0;
                // int i=0,j=n-1,f=0;
                // while(i<j){
                //     sum=a[i]+a[j];
                //     if(sum==k){
                //         f=1;
                //         break;
                //     }
                //     else if(sum<k){
                //         i++;
                //     }
                //     else{
                //         j--;
                //     }
                // }
                // if(f==1){
                //     System.out.println("Yes");
                // }
                // else{
                //     System.out.println("No");
                // }


        // SECOND VARIANT
                // brute force:
                // int f=0;
                // int res[]=new int[2];
                // for(int i=0;i<n;i++){
                //     for(int j=i+1;j<n;j++){
                //         if((a[i]+a[j])==k){
                //             f=1;
                //             res[0]=i;
                //             res[1]=j;
                //             break;
                //         }
                //     }
                // }
                // System.out.print(res[0]+" "+res[1]);


                //optimal
                HashMap<Integer,Integer> hm=new HashMap<>();
                int res[]=new int[2];
                res[0]=-1;
                res[1]=-1;
                for(int i=0;i<n;i++){
                    int rem=k-a[i];
                    if(hm.containsKey(rem)){
                        res[0]=hm.get(rem);
                        res[1]=i;
                        break;
                    }
                    hm.put(a[i], i);
                }
                System.out.print(res[0]+" "+res[1]);
    }
}