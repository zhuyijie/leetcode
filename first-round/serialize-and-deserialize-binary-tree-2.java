import static java.lang.Math.*;
public class Codec {
    public static final String NULL = "null";
    public String serialize(TreeNode root)
    {
        if (root == null) {return NULL;}
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + ":" + left.length() + ":" + right.length() + ":" + left + right;
    }
    public TreeNode deserialize(String data) 
    {
        if (NULL.equals(data)) {return null;}
        int idx = data.indexOf(":");
        TreeNode root = new TreeNode(Integer.parseInt(data.substring(0, idx)));
        int leftLenIdx = data.indexOf(":", idx + 1);
        int leftLen = Integer.parseInt(data.substring(idx + 1, leftLenIdx));
        int rightLenIdx = data.indexOf(":", leftLenIdx + 1);
        int rightLen = Integer.parseInt(data.substring(leftLenIdx + 1, rightLenIdx));
        TreeNode leftBranch = deserialize(data.substring(rightLenIdx + 1, rightLenIdx + 1 + leftLen));
        TreeNode rightBranch = deserialize(data.substring(rightLenIdx + 1 + leftLen, rightLenIdx + 1 + leftLen + rightLen));
        root.left = leftBranch;
        root.right = rightBranch;
        return root;
    }
}
