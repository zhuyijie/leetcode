public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        boolean[] dp = new boolean[s.length() + 1]; dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (i < word.length()) {
                    continue;
                }
                if (dp[i - word.length()] && s.substring(0, i).endsWith(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

