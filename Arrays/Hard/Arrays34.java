//Length of the longest subarray with zero sum -- 1) brute force - TC:O(N^2) SC:O(1)  generate all subarrays and check sum, track the longest.  
//                                                2) optimal   - TC:O(N) SC:O(N)  use HashMap to store first occurrence of prefix sums; if the same sum repeats, subarray between indices has sum = 0, update max length. 
import java.util.*;
class Arrays34{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        }
        // int len=0,sum=0,maxlen=0;
        // for(int i=0;i<n;i++){
        //     len=0;
        //     sum=0;
        //     for(int j=i;j<n;j++){
        //         sum+=a[j];
        //         if(sum==0){
        //             len=(j-i)+1;
        //             maxlen=Math.max(maxlen, len);
        //         }
        //     }
        // }
        
        HashMap<Integer,Integer> hm=new HashMap<>();
        int maxlen=0,sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
            if(sum==0){
                maxlen=Math.max(maxlen, i+1);
            }
            int rem=sum-0;
            if(hm.containsKey(rem)){
                int len=i-hm.get(rem);
                maxlen=Math.max(maxlen, len);
            }
            if(!hm.containsKey(sum)){
                hm.put(sum, i); 
            }
        }
        System.out.println(maxlen);
    }
}