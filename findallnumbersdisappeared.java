class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len=nums.length;
        // boolean flag=false;
        ArrayList<Integer> al=new ArrayList<>();
        // for(int i=1;i<=len;i++){
        //     flag=false;
        //     for(int j=0;j<len;j++){
        //         if(nums[j]==i){
        //             flag=true;
        //             break;
        //         }
        //     }
        //     if(!flag){
        //         al.add(i);
        //     }
        // }
        // return al;
        // int temp=0;
        // for(int i=0;i<nums.length;i++){
        //     while(nums[i]!=nums[nums[i]-1]){
        //         temp=nums[i];
        //         nums[i]=nums[nums[i]-1];
        //         nums[temp-1]=temp;
        //     }
        // }
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]!=i+1){
        //         al.add(i+1);
        //     }
        // }
        // return al;
        for(int i=0;i<nums.length;i++){
            int id=Math.abs(nums[i])-1;
            if(nums[id]>0){
                nums[id]=nums[id]*-1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                al.add(i+1);
            }
        }
        return al;
    }
    // public boolean binarysearch(int[] ar,int st,int end,int target){
    //     while(st<=end){
    //         int mid=end+(st-end)/2;
    //         if(ar[mid]==target){
    //             return true;
    //         }
    //         else if(ar[mid]<target){
    //             st=mid+1;
    //         }
    //         else{
    //             end=mid-1;
    //         }
    //     }
    //     return false;
    // }
}