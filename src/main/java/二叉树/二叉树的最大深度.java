package 二叉树;

import org.junit.Test;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName 二叉树的最大深度.java
 * @createTime 2022年04月02日 19:53:00
 */
public class 二叉树的最大深度 {
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;

    }

    @Test
    public void main(){
        System.out.println(maxDepth(TreeNode.initTree()));
    }
}
