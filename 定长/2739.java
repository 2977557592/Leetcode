
//https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int begin=0,end,wsum=0,maxsum;
        for(end=0;end<k;end++)
        {
            if(blocks.charAt(end)=='W')
            {
                wsum++;
            }
        }
        maxsum=wsum;
        while(end<blocks.length())
        {
            if(blocks.charAt(begin)=='W')
                wsum--;
            if(blocks.charAt(end)=='W')
                wsum++;
            if(maxsum>wsum)
                maxsum=wsum;
            begin++;
            end++;
        }
        return maxsum;     
    }
}
