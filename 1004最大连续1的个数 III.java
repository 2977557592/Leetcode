//1004最大连续1的个数 III.java
//https://leetcode.cn/problems/max-consecutive-ones-iii/description/
class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans=0,sum=0,begin=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            while(i-begin+1-sum>k)
            {
                sum-=nums[begin];
                begin++;
            }
            ans=Math.max(ans,i-begin+1);
        }
        return ans;
    }
}
