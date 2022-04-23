package 二叉树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode145.java
 * @Description 二叉树的后序遍历
 * @createTime 2022年04月01日 22:26:00
 */
public class 二叉树_续遍历_递归 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        hleper(root, ans);
        return ans;
    }

    private void hleper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        hleper(root.left, ans);
        hleper(root.right, ans);
        ans.add(root.val);
    }

    @Test
    public void main(){
        System.out.println(postorderTraversal(TreeNode.initTree()));
    }

}
