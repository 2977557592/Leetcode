//2024. 考试的最大困扰度
//https://leetcode.cn/problems/maximize-the-confusion-of-an-exam/description/
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] ak = answerKey.toCharArray();
        int[] a=new int[2];
        int ans=0,begin=0;
        for(int i=0;i<ak.length;i++)
        {
            if(ak[i]=='T')a[0]++;else a[1]++;
            while(a[0]>k&&a[1]>k)
            {
                if(ak[begin]=='T')a[0]--;else a[1]--;
                begin++;
            }     
            ans=Math.max(ans,a[0]+a[1]);    
        }
        return ans;
    }

}
