//2958最多 K 个重复元素的最长子数组.java
//https://leetcode.cn/problems/length-of-longest-subarray-with-at-most-k-frequency/description/
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans=0,begin=0,sum=0;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            map.merge(nums[i],1,Integer::sum);
            sum++;
            while(map.get(nums[i])>k)
            {
                map.merge(nums[begin],-1,Integer::sum);
                if(map.get(nums[begin])==0)
                    map.remove(nums[begin]);
                begin++;
                sum--;
            }
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}
