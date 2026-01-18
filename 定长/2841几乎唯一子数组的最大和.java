//2841. 几乎唯一子数组的最大和
//https://leetcode.cn/problems/maximum-sum-of-almost-unique-subarray/description/

class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        long maxsum=0,cursum=0,begin=0,end=0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.size();i++){
            //计算当前和
            cursum+=nums.get(i);
            //对当前值计数
            map.merge(nums.get(i), 1, Integer::sum);

            //所取数组长度不足k
            if(i-k+1<0)
                continue;

            //满足至少有m个不同的数就更新maxsum
            if(map.size()>=m)
            {
                maxsum=Math.max(maxsum,cursum);
            }
            //取出第一个数
            cursum-=nums.get(i-k+1);
            //更新计数。
            if(map.get(nums.get(i-k+1))>1){
                map.put(nums.get(i-k+1),map.get(nums.get(i-k+1))-1);
            }
            else
            {
                map.remove(nums.get(i-k+1));
            }
        }
        return maxsum;
    }
}
