//2461. 长度为 K 子数组中的最大和
//https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans=0;
        long s=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            s+=nums[i];
            Integer in=nums[i];
            map.merge(in,1,Integer::sum);
            if(i-k+1<0)
            {
                continue;
            }
            if(map.size()==k){
                ans = Math.max(ans,s);
            }
            int index = i-k+1;
            int out=nums[index];
            s-=out;
            if(map.get(out)>1){
                map.merge(out,-1,Integer::sum);
            }
            else
                map.remove(out);
        }
        return ans;
    }
}
