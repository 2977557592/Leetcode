//https://leetcode.cn/problems/maximum-average-subarray-i/
//先计算前k个值的和，使用begin、end遍历，比较当前和和最大和的大小
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxsum=0,cursum=0;
        int i=0;
        for(;i<k;i++)
        {
            cursum += nums[i];
        }
        maxsum=cursum;
        int begin=0,end=i;
        while(end<nums.length)
        {
            cursum=cursum-nums[begin]+nums[end];
            if(cursum>maxsum)
                maxsum = cursum;
            begin++;
            end++;
        }
        return maxsum/k;
    }
}
