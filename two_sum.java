class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[]=new int[2];
        int l=nums.length;
        // for(int i=0;i<l;i++){
        //     for(int j=i+1;j<l;j++){
        //         if((nums[i]+nums[j])==target){
        //             ans[0]=i;
        //             ans[1]=j;
        //         }
        //     }
        // }
        // return ans;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<l;i++){
            int d=target-nums[i];
            if(hm.containsKey(d)){
                return new int[] {hm.get(d),i};
            }
            hm.put(nums[i],i);
        }
        return new int[] {};
    }
}
