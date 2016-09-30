
public class Solution {

    public boolean isMatch(String s, String p) {
        return dfs(s, 0, p, 0);
    }

    boolean dfs(String s, int si, String p, int pi){
         if (si == s.length() && pi == p.length()) {
            return true;
         }
         if (pi == p.length()) {
            return false;
         }
         if (pi + 1 == p.length() || p.charAt(pi + 1) != '*') {
            if (p.charAt(pi) == '.' || (si < s.length() && s.charAt(si) == p.charAt(pi))) {
                return dfs(s, si + 1, p, pi + 1);
            } else {
                return false;
            }
         }
         boolean result = dfs(s, si, p, pi + 2);
         if (!result && si < s.length() && (p.charAt(pi) == '.' || p.charAt(pi) == s.charAt(si))) {
             result = dfs(s, si + 1, p, pi);
         }
         return result;
    }

}
