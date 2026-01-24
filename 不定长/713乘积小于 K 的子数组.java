//713. 乘积小于 K 的子数组
//https://leetcode.cn/problems/subarray-product-less-than-k/
//计数的关键在于满足left,right区间内的乘积小于k,那么就会有right-left+1种组合满足这种情况。

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int flag=0;
        for(int index=0;index<nums.length;index++){
            if(nums[index]<k){
                flag++;
            }
        }
        if(flag==0){return 0;}
        int ans=0;
        int sum=1;
        int left=0;
        for(int right=0;right<nums.length;right++){
            sum*=nums[right];
            while(sum>=k)
            {
                sum/=nums[left++];
            }
            ans+=right-left+1;
        }
        return ans;
    }
}
