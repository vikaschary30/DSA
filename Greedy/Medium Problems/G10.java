// Job Sequencing Problem - Problem Statement : You are given a set of N jobs where each job comes with a deadline and profit. The profit can only be earned upon completing the job within its deadline. Find the number of jobs done and the maximum profit that can be obtained. Each job takes a single unit of time and only one job can be performed at a time.
//                          1) optimal - TC:O(NlogN+maxdeadline*n) SC:O(maxdeadline) It sorts jobs by profit in descending order and greedily assigns each job to the latest available time slot before its deadline, maximizing total profit and counting how many jobs are done.


import java.util.*;
class Data{
    int id,deadline,profit;
    public Data(int id, int deadline, int profit) {
        this.id=id;
        this.deadline=deadline;
        this.profit=profit;
    }
}
class G10{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Data> arr=new ArrayList<>();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            arr.add(new Data(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(arr,(a,b)->(b.profit-a.profit));
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,arr.get(i).deadline);
        }
        int res[]=new int[max+1];
        for(int i=0;i<res.length;i++){
            res[i]=-1;
        }
        int c=0, totalprofit=0;
        for(int i=0;i<n;i++){
            for(int j=arr.get(i).deadline;j>0;j--){
                if(res[j]==-1){
                    c++;
                    res[j]=arr.get(i).id;
                    totalprofit+=arr.get(i).profit;
                    break;
                }
            }
        }
        System.out.println(c+" "+totalprofit);
    }
}