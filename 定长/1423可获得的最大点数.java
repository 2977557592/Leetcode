//1423. 可获得的最大点数
//https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/description/
//先正顺序拿k张，再每次进行k-1，k-2....从后面依次拿1，2,3...
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int end=0,l=cardPoints.length-1;
        int ans=0,s=0;
        for(;end<k;end++)
        {
            s+=cardPoints[end];
        }
        ans=s;
        end=end-1;
        for(;end>=0;end--){
            s=s-cardPoints[end]+cardPoints[l];
            ans=Math.max(s,ans);
            l--;
        }
        return ans; 
    }
}
