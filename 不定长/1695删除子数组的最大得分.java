//1695删除子数组的最大得分.java
//https://leetcode.cn/problems/maximum-erasure-value/
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int ans=0,begin=0,sum=0;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            map.merge(nums[i],1,Integer::sum);
            while(map.get(nums[i])>1)
            {
                map.merge(nums[begin],-1,Integer::sum);
                sum-=nums[begin];
                begin++;     
            }
            ans=Math.max(sum,ans);
        }
        return ans;
    }
}
