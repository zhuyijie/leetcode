public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return rec(root, false);
    }
    int rec(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (isLeaf(root)) {
            return isLeft ? root.val : 0;
        } 
        return rec(root.left, true) + rec(root.right, false);
    }
    boolean isLeaf(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }
}
