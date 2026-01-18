//https://leetcode.cn/problems/k-radius-subarray-averages/

class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        int windowLen = 2 * k + 1; // 窗口固定长度
        
        // 边界条件：数组长度不足窗口长度，所有位置都是-1
        if (n < windowLen) {
            // 填充-1并返回
            for(int i = 0; i < n; i++) res[i] = -1;
            return res;
        }

        // 初始化所有位置为-1，后续只覆盖有效位置
        for(int i = 0; i < n; i++) res[i] = -1;

        // 1. 初始化第一个窗口的总和：nums[0] ~ nums[2k]
        long sum = 0; // 必须用long！防止int溢出（nums[i]<=10^5，n<=10^5，总和会超int范围）
        for (int i = 0; i < windowLen; i++) {
            sum += nums[i];
        }

        // 第一个有效中心的位置是k，赋值第一个平均值
        res[k] = (int) (sum / windowLen);

        // 2. 滑动窗口遍历剩余所有有效窗口
        int begin = 0;
        for (int end = windowLen; end < n; end++) {
            sum = sum - nums[begin++] + nums[end]; // 先出左边界，再入右边界
            int mid = begin + k; // 窗口[begin, end]的中心，等价于(begin+end)/2
            res[mid] = (int) (sum / windowLen);
        }

        return res;
    }
}
