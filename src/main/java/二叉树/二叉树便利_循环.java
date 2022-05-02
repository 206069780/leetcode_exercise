package 二叉树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName 二叉树便利_循环.java
 * @Description
 * @createTime 2022年04月23日 17:59:00
 */
public class 二叉树便利_循环 {
    /**
     * 先序列遍历
     *
     * @param root 遍历目标
     */
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                ans.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return ans;
    }

    /**
     * 后序遍历
     *
     * @param root 遍历目标
     * @return 遍历结果
     */
    public List<Integer> innerOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> tmp = new Stack<>();
        while (root != null || !tmp.isEmpty()) {
            while (root != null) {
                tmp.push(root);
                root = root.left;

            }
            root = tmp.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }

    /**
     * 后序遍历
     *
     * @param root 遍历目标
     * @return 遍历结果
     */
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> tmp = new Stack<>();
        TreeNode tmpRoot = null;
        while (root != null || !tmp.isEmpty()) {
            while (root != null) {
                tmp.push(root);
                root = root.left;
            }
            root = tmp.pop();
            if (root.right == null || tmpRoot == root.right) {
                ans.add(root.val);
                tmpRoot = root;
                root = null;
            } else {
                tmp.push(root);
                root = root.right;
            }
        }
        return ans;
    }

    @Test
    public void main() {
        System.out.println(preOrder(TreeNode.initTree()).toString());
        System.out.println(innerOrder(TreeNode.initTree()).toString());
        System.out.println(postOrder(TreeNode.initTree()).toString());
    }
}
