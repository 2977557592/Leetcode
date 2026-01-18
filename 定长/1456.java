//https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
//初始化前k-1个，然后使用begin,end指针往后进行遍历，
class Solution {
    public int maxVowels(String s, int k) {
        int maxnum = 0,i=0;
        int begin=0;
        for(;i<k;i++)
        {
            if(panduan(s.charAt(i)))
                maxnum++;
        }
        int cur=maxnum;
        for(i=k;i<s.length();i++)
        {
            if(panduan(s.charAt(begin)))
                cur--;
            if(panduan(s.charAt(i)))
                cur++;
            if(cur>maxnum)
                maxnum=cur;
            begin++;
        }
        return maxnum;
    }
    public boolean panduan(char c)
    {
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
            return true;
        else
            return false;
    }
}
