package 二叉树;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode101.java
 * @Description 对称二叉树
 * @createTime 2022年03月31日 22:51:00
 */
public class LeetCode101 {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode root, TreeNode root1) {

        if (root == null && root1 == null) {
            return true;
        }

        if (root1 == null || root == null) {
            return false;
        }
        return (root.val == root1.val) && isMirror(root.right, root1.left) && isMirror(root1.right, root.left);
    }

    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
