//https://leetcode.cn/problems/longest-substring-without-repeating-characters///
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0, maxsum = 0;
        for (int end = 0; end < s.length(); end++) {
            char curChar = s.charAt(end);
            if (map.containsKey(curChar) && map.get(curChar) >= begin) {
                begin = map.get(curChar) + 1;
            }
            map.put(curChar, end);
            maxsum = Math.max(maxsum, end - begin + 1);
        }
        return maxsum;
    }
}
