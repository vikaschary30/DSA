// Allocate Minimum Number of Pages - Problem statement : Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of pages in the ‘i-th’ book. There are a ‘m’ number of students, and the task is to allocate all the books to the students.
//                                                        Allocate books in such a way that:
//                                                        Each student gets at least one book.Each book should be allocated to only one student.Book allocation should be in a contiguous manner.
//                                                        You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum. If the allocation of books is not possible. return -1
//                                    1) brute force - TC:O((sum-max)*n) Try every possible maximum pages value from max(arr) to sum(arr) and pick the smallest that can allocate all books to m students.
//                                    2) optimal - TC:O(log(sum-max)*n) Use binary search between max(arr) and sum(arr) to find the minimum possible maximum pages allocation that satisfies the m students constraint.



import java.util.*;
class BS22{
    public static int noofstudents(int[] a, int pages, int n, int m){
        int std=1, pagesstd=0;
        for(int i=0;i<n;i++){
            if(a[i]+pagesstd<=pages){
                pagesstd+=a[i];
            }
            else{
                std++;
                pagesstd=a[i];
            }
        }
        return std;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            max=Math.max(a[i], max);
            sum+=a[i];
        }
        int m=sc.nextInt();
        if(m>n){
            System.out.println("-1");
            return;
        }

        //brute force
        // int ans=0;
        // for(int i=max;i<=sum;i++){
        //     int std=noofstudents(a,i,n,m);
        //     if(std==m){
        //         ans=i;
        //         break;
        //     }
        // }
        // System.out.println(ans);

        //optimal
        int ans=-1;
        int low=max,high=sum;
        while(low<=high){
            int mid=(low+high)/2;
            int std=noofstudents(a, mid, n, m);
            if(std<=m){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        System.out.println(ans);    
    }
}