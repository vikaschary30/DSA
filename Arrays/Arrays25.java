// Longest consecutive sequence -- 1) brute force - take an element and linear search its next element in the array and find the longest.
//                                 2) better - Sort the array and count the length of consecutive increasing elements while skipping duplicates to find the longest sequence.
//                                 3) optimal - Store all elements in a HashSet and, for each number that has no predecessor (num-1), expand forward to count its consecutive sequence length, tracking the maximum.

import java.util.*;
class Arrays25{
    public static boolean lsearch(int a[], int k, int n){
        for(int i=0;i<n;i++){
            if(a[i]==k){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }

        //brute force
        // int maxlen=1;
        // for(int i=0;i<n;i++){
        //     int curr=a[i];
        //     int c=1;
        //     while(lsearch(a,curr+1,n)){
        //         curr+=1;
        //         c++;
        //         maxlen=Math.max(maxlen, c);
        //     }
        // }

        // better
        // Arrays.sort(a);
        // int maxlen=1, lastsmaller=Integer.MIN_VALUE, c=0;
        // for(int i=0;i<n;i++){
        //     if(a[i]-1==lastsmaller){
        //         c++;
        //         lastsmaller=a[i];
        //     }
        //     else if(a[i]!=lastsmaller){
        //         c=1;
        //         lastsmaller=a[i];
        //     }
        //     maxlen=Math.max(maxlen, c);
        // }

        // optimal
        if(n==0){
            System.out.println("0");
        }
        HashSet<Integer> hs=new HashSet<>();
        int maxlen=1;
        for(int i=0;i<n;i++){
            hs.add(a[i]);
        }
        for(int num: hs){
            if(!hs.contains(num-1)){
                int c=1;
                int curr=num;
                while(hs.contains(curr+1)){
                    c++;
                    curr++;
                }
                maxlen=Math.max(maxlen, c);
            }
        }
        System.out.println(maxlen);
    }
}