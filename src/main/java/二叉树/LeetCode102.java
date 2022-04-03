package 二叉树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode102.java
 * @Description 二叉树的层次遍历
 * @createTime 2022年03月31日 22:55:00
 */
public class LeetCode102 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return ans;
        }
        helper(root, 0);
        return ans;
    }

    /**
     * 深度优先遍历
     *
     * @param root  节点
     * @param level 深度
     */
    private void helper(TreeNode root, int level) {
        if (ans.size() == level) {
            ans.add(new ArrayList<Integer>());
        }
        ans.get(level).add(root.val);
        if (root.left != null) {
            helper(root.left, level+1 );
        }
        if (root.right != null) {
            helper(root.right, level+1);
        }
    }

    private List<List<Integer>> levelOrderList(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 首节点入队操作
        queue.offer(root);

        while (!queue.isEmpty()) {

            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();

            for (int i = 1; i <= currentLevelSize; i++) {
                // 出队
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }



    @Test
    public void main() {
        TreeNode node1 = new TreeNode(3);

        TreeNode node2 = new TreeNode(9);

        TreeNode node3 = new TreeNode(20);

        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(levelOrder(node1));

    }

}
