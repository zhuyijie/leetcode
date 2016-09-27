import static java.lang.Math.*;
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] map = new int[128];
        int fast = 0, slow = 0, counter = 0, maxi = 0;
        while (fast <= s.length()) {
            if (counter == k && (fast == s.length() || map[(int) s.charAt(fast)] == 0)) {
                maxi = max(maxi, fast - slow);
                while (counter == k) {
                    if (--map[])
                }
            }
            if (map[(int) s.charAt(fast)]++ == 0) {
                counter++;
            }
            while (counter == k + 1) {
                
            }
        }
    }
}
