//Find the Majority Element that occurs more than N/2 times -- 1) brute force - iterate through all the array elements and count the freq of each element and compare it with the half of the length.
//                                                             2) better - use hashmap and store the freq in values and retreive the key if c is greater than len/2.
//                                                             3) moore's voting algorithm - O(N) Moore’s Voting Algorithm finds the majority element by keeping a running candidate and a counter, incrementing the counter when the current element matches the candidate and decrementing it when it doesn’t, ensuring that if a majority exists, it will be the final candidate.


import java.util.*;
class Arrays18{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        // int valid=n/2;
        // int c=0,ans=0;
        // for(int i=0;i<n;i++){
        //     c=0;
        //     for(int j=0;j<n;j++){
        //         if(a[i]==a[j]){
        //             c++;
        //         }
        //     }
        //     if(c>valid){
        //         ans=a[i];
        //         break;
        //     }
        // }


        // HashMap<Integer,Integer> hm=new HashMap<>();
        // for(int i=0;i<n;i++){
        //     int c=hm.getOrDefault(a[i], 0)+1;
        //     hm.put(a[i], c);
        //     if(c>n/2){
        //         System.out.println(a[i]);
        //         break;
        //     }

        int c=0;
        int ele=0;
        for(int i=0;i<n;i++){
            if(c==0){
                c=1;
                ele=a[i];
            }
            else if(a[i]==ele){
                c++;
            }
            else{
                c--;
            }
        }
        int c1=0;
        for(int i=0;i<n;i++){
            if(a[i]==ele){
                c1++;
            }
        }
        if(c1>n/2){
            System.out.println(ele);
        }
        else{
            System.out.println("-1");
        }
    }
}