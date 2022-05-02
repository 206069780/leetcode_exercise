package 二叉树;

import org.junit.Test;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName 二叉树的最小深度.java
 * @Description
 * @createTime 2022年04月02日 20:05:00
 */
public class 二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    @Test
    public void main() {
        System.out.println(minDepth(TreeNode.initTree()));
    }
}
