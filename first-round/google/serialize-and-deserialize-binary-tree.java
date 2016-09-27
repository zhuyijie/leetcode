import static java.lang.Math.*;
public class Codec {
    public static final String NULL = "null";
    public String serialize(TreeNode root) {
        int h = findHeight(root);
        int size = (int) pow((double)2, (double)h) - 1;
        String[] arr = new String[size];
        build(arr, 0, root);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] == null ? NULL : arr[i]);
            if (i != arr.length - 1) { sb.append(","); }
        }
        return sb.toString();
    }
    void build(String[] arr, int i, TreeNode root) {
        if (root == null) {return;}
        arr[i] = String.valueOf(root.val);
        build(arr, 2*i + 1, root.left);
        build(arr, 2*i + 2, root.right);
    }
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {return null;}
        String[] arr = data.split(","); 
        return construct(arr, 0);
    }
    TreeNode construct(String[] arr, int i) {
        if (i >= arr.length || arr[i].equals(NULL)) {return null;}
        TreeNode retVal = new TreeNode(Integer.parseInt(arr[i]));
        retVal.left = construct(arr, 2*i+1);
        retVal.right = construct(arr, 2*i+2);
        return retVal;
    }
    int findHeight(TreeNode root) {
        if (root == null) {return 0;}
        return 1 + max(findHeight(root.left), findHeight(root.right));
    }
}
