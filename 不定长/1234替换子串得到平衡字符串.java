//1234. 替换子串得到平衡字符串
//https://leetcode.cn/problems/replace-the-substring-for-balanced-string/description/
class Solution {
    public int balancedString(String s) {
        char[] arr = s.toCharArray();
        int[] cnt=new int['X'];
        for(char c : arr)
        {
            cnt[c]++;
        }
        int m = s.length()/4;
        if(cnt['Q']==m&&cnt['W']==m&&cnt['E']==m&&cnt['R']==m)
            return 0;
        int ans = s.length();
        int left=0;
        for(int right=0;right<s.length();right++){
            cnt[arr[right]]--;
            while(cnt['Q']<=m&&cnt['W']<=m&&cnt['E']<=m&&cnt['R']<=m)
            {
                ans=Math.min(ans,right-left+1);
                cnt[arr[left]]++;
                left++;
            }
        }
        return ans;
    }
}
