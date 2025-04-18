class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         if(i!=j && nums[j]<nums[i]){
        //             ans[i]++;
        //         }
        //     }
        // }
        // return ans;
        int cnt[]=new int[101];
        for(int i=0;i<n;i++){
            cnt[nums[i]]++;
        }
        for(int i=1;i<101;i++){
            cnt[i]+=cnt[i-1];
        }
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                ans[i]=0;
            }
            else{
                ans[i]=cnt[nums[i]-1];  
            }
        }
        return ans;
    }
}