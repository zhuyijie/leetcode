import static java.lang.Math.*;
public class Solution {
    public int lengthLongestPath(String input) {
        int[] lengthMap = new int[input.length() + 1];
        String[] tokens = input.split("\n");
        int maxi = 0;
        for (String token : tokens) {
            int level = getLevel(token);
            lengthMap[level+1] = lengthMap[level] + getLength(token);
            if (isFile(token)) {
                maxi = max(maxi, lengthMap[level + 1] + level);
            }
        }
        return maxi;
    }
    int getLevel(String token) {
        int level = 0;
        while (level < token.length() && token.charAt(level) == '\t') {
            level++;
        }
        return level;
    }
    int getLength(String token) {
        return token.length() - getLevel(token);
    }
    boolean isFile(String token) {
        return token.indexOf('.') != -1;
    }
}
