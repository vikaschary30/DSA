class Solution {
    public int missingNumber(int[] nums) {
        int len=nums.length;
        // boolean flag=false;
        // for(int i=0;i<=len;i++){
        //     flag=false;
        //     for(int j=0;j<len;j++){
        //         if(nums[j]==i){
        //             flag=true;
        //             break;
        //         }
        //     }
        //     if(!flag){
        //         return i;
        //     }
        // }
        // return len;
        int s1=(len*(len+1))/2;
        int s2=0;
        for(int i=0;i<len;i++){
            s2+=nums[i];
        }
        int ans=s1-s2;
        return ans;
    }
}
