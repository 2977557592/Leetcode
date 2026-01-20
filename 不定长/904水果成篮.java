//904水果成篮
//https://leetcode.cn/problems/fruit-into-baskets/
class Solution {
    public int totalFruit(int[] fruits) {
        int ans=0,left=0;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<fruits.length;i++)
        {
            map.merge(fruits[i],1,Integer::sum);
            while(map.size()>2)
            {
                if(map.get(fruits[left])>1)
                    map.merge(fruits[left],-1,Integer::sum);
                else 
                    map.remove(fruits[left]);
                left++;
            }
            ans=Math.max(ans,i-left+1);
        }
        return ans;
    }
}
