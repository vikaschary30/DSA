    // Capacity to Ship Packages within D Days - Problem statement : You are the owner of a Shipment company. You use conveyor belts to ship packages from one port to another. The packages must be shipped within 'd' days.
    //                                                               The weights of the packages are given in an array 'of weights'. The packages are loaded on the conveyor belts every day in the same order as they appear in the array. The loaded weights must not exceed the maximum weight capacity of the ship.
    //                                                               Find out the least-weight capacity so that you can ship all the packages within 'd' days.
    //                                           1) brute force - TC:O((sum-max)*n) Check every capacity from the maximum single package weight to the total weight and return the smallest capacity that allows shipping within d days.
    //                                           2) optimal - TC:O((sum-max)*logn) Use binary search between max weight and total weight to find the smallest capacity that allows shipping within d days by checking with a greedy day-count function.


    import java.util.*;
    class BS19{
        public static int noofdays(int[] a, int cap, int n){
            int day=1, load=0;
            for(int i=0;i<n;i++){
                if(load+a[i]>cap){
                    day++;
                    load=a[i];
                }
                else{
                    load+=a[i];
                }
            }
            return day;
        }
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int a[]=new int[n];
            int max=Integer.MIN_VALUE;
            int sum=0;
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
                max=Math.max(max, a[i]);
                sum+=a[i];
            }
            int d=sc.nextInt();

            //brute force
            // int ans=0;
            // for(int i=max;i<=sum;i++){
            //     int days=noofdays(a,i,n);
            //     if(days<=d){
            //         ans=i;
            //         break;
            //     }
            // }
            // System.out.println(ans);

            //optimal
            int low=max, high=sum;
            while(low<=high){
                int mid=(low+high)/2;
                int days=noofdays(a, mid, n);
                if(days<=d){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            System.out.println(low);
        }
    }
