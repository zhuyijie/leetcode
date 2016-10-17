public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int lo = 0, hi = 0, longest = 0;
        while (hi < s.length()) {
            while (map[s.charAt(hi)] > 0) {
                map[s.charAt(lo++)]--;
            }
            map[s.charAt(hi++)]++;
            longest = Math.max(longest, hi - lo);
        }
        return longest;
    }
}
