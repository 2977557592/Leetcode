//1052. 爱生气的书店老板
//https://leetcode.cn/problems/grumpy-bookstore-owner/description/

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans=0;
        int s=0;
        //先计算不生气的时间段内有多少满意的人
        for(int i=0;i<grumpy.length;i++)
        {
            if(grumpy[i]==0)
                s+=customers[i];
        }
        //用两个指针指向minutes的开始和结束
        int begin=0,end=0;
        for(;end<grumpy.length;end++)
        {
            //如果这时间在minutes之内
            if(grumpy[end]==1)
            {
                s=s+customers[end];
            }
            //如果修改的长度小于3，继续
            if(end-begin<minutes-1)
            {
                continue;
            }
            //计算最大值
            ans=Math.max(s,ans);
            //窗口开始后移，如果原本不是满意的客户，需要减去
            if(grumpy[begin]==1)
                s-=customers[begin];
            begin++;
        }
        return ans;  
    }
}
