import static java.lang.Math.*;

public class Solution {
    public int longestConsecutive(TreeNode root) {
        return rec(root, 1, root.val);
    }
    int rec(TreeNode root, int len, int prev) {
        if (root == null) {
            return 0;
        } 
        int lenEnd = prev + 1 == root.val ? len + 1 : 1;
        int childLen = max(rec(root.left, lenEnd, root.val), rec(root.right, lenEnd, root.val));
        return max(lenEnd, childLen);
    }
}
