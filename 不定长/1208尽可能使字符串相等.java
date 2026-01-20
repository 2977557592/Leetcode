//1208 尽可能使字符串相等
//https://leetcode.cn/problems/get-equal-substrings-within-budget/
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        //将字符串转换为数组
        char[] t1 = t.toCharArray();
        char[] s1 = s.toCharArray();
        //cur记录当前花费，begin记录窗口的左位置，ans目标答案
        int cur=0,begin=0,ans=0;
        for(int i=0;i<t1.length;i++)
        {
            //计算当前字符花销
            cur+=Math.abs((int)(t1[i]-s1[i]));
            //如果当前字符花销大于最大可花销，进行减法，左指针右移窗口
            while(cur>maxCost)
            {
                cur-=Math.abs((int)(t1[begin]-s1[begin]));
                begin++;
            }
            //获取最大值
            ans=Math.max(ans,i-begin+1);
        }
        return ans;
    }
}
