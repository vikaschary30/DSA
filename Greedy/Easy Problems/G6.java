// N meetings in one room - Problem Statement : There is one meeting room in a firm. You are given two arrays, start and end each of size N.For an index ‘i’, start[i] denotes the starting time of the ith meeting while end[i]  will denote the ending time of the ith meeting. Find the maximum number of meetings that can be accommodated if only one meeting can happen in the room at a  particular time. Print the order in which these meetings will be performed.
//                          1) optimal - TC:O(N+NlogN) SC:O(N)Sort meetings by their end times and greedily select each meeting that starts after the last selected one ends, recording their order.


import java.util.*;
class Data{
    int st,end,pos;
    public Data(int st, int end, int pos) {
        this.st=st;
        this.end=end;
        this.pos=pos;
    }
}
class meetingComparator implements Comparator<Data>{
    @Override
    public int compare(Data a, Data b){
        if(a.end<b.end){
            return -1;
        }
        else if(a.end>b.end){
            return 1;
        }
        else if(a.pos<b.pos){
            return -1;
        }
        return 1;   
    }
}
class G6{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int st[]=new int[n];
        for(int i=0;i<n;i++){
            st[i]=sc.nextInt();
        }
        int end[]=new int[n];
        for(int i=0;i<n;i++){
            end[i]=sc.nextInt();
        }

        ArrayList<Data> meet=new ArrayList<>();
        for(int i=0;i<n;i++){
            meet.add(new Data(st[i],end[i],i+1));
        }
        meetingComparator mc=new meetingComparator();
        Collections.sort(meet,mc);
        ArrayList<Integer> res=new ArrayList<>();
        res.add(meet.get(0).pos);
        int freetime=meet.get(0).end;
        int c=0;                                         //if asked the number of meetings to return
        for(int i=0;i<n;i++){
            if(meet.get(i).st>freetime){
                c++;
                freetime=meet.get(i).end;
                res.add(meet.get(i).pos);
            }
        }
        System.out.println(res);
    }
}