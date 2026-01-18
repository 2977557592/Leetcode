//https://leetcode.cn/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
//与643一样的思路
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int num=0,sum=0;
        int n=arr.length,i=n-1;
        for(;i>n-k-1;i--)
        {
            sum+=arr[i];
        }
        if(sum>=threshold*k)
            num++;
        int begin=i,end=n-1;
        while(begin>=0)
        {
            sum+=-arr[end]+arr[begin];
            if(sum>=threshold*k)
                num++;
            end--;
            begin--;
        }
        return num;
    }
}
