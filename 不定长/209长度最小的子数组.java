//209. 长度最小的子数组
//https://leetcode.cn/problems/minimum-size-subarray-sum/description/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int begin=0,sum=0,count=0,ans=nums.length,flag=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            count++;
            while(sum>=target)
            {
                sum-=nums[begin];
                begin++;
                count--; 
                ans=Math.min(ans,count);
                flag=1;
            }
        }
        return flag==0?0:Math.min(ans,count)+1;
    }
}
