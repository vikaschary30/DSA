//Majority Elements(&gt;N/3 times) -- 1) brute force - TC:O(N^2) SC:O(1) For each element, count its frequency in the array and add it to the result if it appears more than ⌊n/3⌋ times.
//                                    2) better - TC:O(N) SC:O(N) Use a HashMap to count frequencies of elements in O(n), then collect those occurring more than ⌊n/3⌋ times.
//                                    3) optimal - TC:O(N) SC:O(1) Use the Extended Boyer–Moore Voting Algorithm to identify up to 2 candidates in one pass, then verify their frequencies in a second pass.



import java.util.*;
class Arrays31{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        List<Integer> res=new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     int curr=a[i];
        //     if(res.contains(curr)){
        //         continue;
        //     }
        //     int c=1;
        //     for(int j=i+1;j<n;j++){
        //         if(a[j]==curr){
        //             c++;
        //         }
        //         if(c>Math.floor((n/3))){
        //             res.add(curr);
        //             break;
        //         }
        //     }
        // }

        //better
        // HashMap<Integer,Integer> hm=new HashMap<>();
        // for(int i=0;i<n;i++){
        //     int c=hm.getOrDefault(a[i], 0)+1;
        //     hm.put(a[i],c);
        //     if(c>(n/3) && !res.contains(a[i])){
        //         res.add(a[i]);
        //     }
        // }

        //optimal
        int c1=0,c2=0;
        int ele1=Integer.MIN_VALUE,ele2=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(c1==0 && a[i]!=ele2){
                c1++;
                ele1=a[i];
            }
            else if(c2==0 && a[i]!=ele1){
                c2++;
                ele2=a[i];
            }
            else if(a[i]==ele1){
                c1++;
            }
            else if(a[i]==ele2){
                c2++;
            }
            else{
                c1--;
                c2--;
            }
        }
        c1=0;
        c2=0;
        for(int i=0;i<n;i++){
            if(a[i]==ele1){
                c1++;
            }
            else if(a[i]==ele2){
                c2++;
            }
        }
        if(c1>(n/3)){
            res.add(ele1);
        }
        if(c2>(n/3)){
            res.add(ele2);
        }
        Collections.sort(res);
        System.out.println(res);
    }
}