import static java.lang.Math.*;

public class Solution {
    int length;
    public int longestConsecutive(TreeNode root) {
        length = 0;
        rec(root); 
        return length;
    }
    public int rec(TreeNode root) {
        if (root == null) {
            return 0;
        } 
        int maxi = 1;
        int left = rec(root.left), right = rec(root.right);
        if (left != 0 && root.left.val == root.val + 1) {
            maxi = max(maxi, left + 1);
        }
        if (right != 0 && root.right.val == root.val + 1) {
            maxi = max(maxi, right + 1);
        }
        length = max(maxi, length);
        return maxi;
    }
}
