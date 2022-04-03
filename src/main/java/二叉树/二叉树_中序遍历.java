package 二叉树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode94.java
 * @Description 二叉树的中虚序遍历
 * @createTime 2022年04月01日 22:46:00
 */
public class 二叉树_中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }
        helper(root, ans);
        return ans;
    }

    private void helper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        helper(root.left, ans);
        ans.add(root.val);
        helper(root.right, ans);
    }


    private void helperPre(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                System.out.print(node.val+" ");
                stack.push(node);
                node=node.left;
            }else {
                TreeNode tmp = stack.pop();

                node = tmp.right;
            }
        }
    }

    @Test
    public void main(){
//        System.out.println(inorderTraversal(TreeNode.initTree()));

        helperPre(TreeNode.initTree());
    }


}
