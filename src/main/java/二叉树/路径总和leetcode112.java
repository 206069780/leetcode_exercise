package 二叉树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName 路径总和leetcode112.java
 * @Description TODO
 * @createTime 2022年04月04日 12:27:00
 */
public class 路径总和leetcode112 {
    /**
     * 判读事发存在满足条件的路径
     *
     * @param root 二叉树
     * @param sum  目标值
     * @return 返回结果
     * - true
     * - false
     */
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    List<List<Integer>> tmp = new ArrayList<>();
    Deque<Integer> result = new LinkedList<>();

    /**
     * 获取所有满足条件的结果
     *
     * @param root 二叉树
     * @param sum  目标值
     */
    public void getTotalPath(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        result.offer(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            tmp.add(new LinkedList<>(result));
        }
        getTotalPath(root.left, sum);
        getTotalPath(root.right, sum);

        result.pollLast();
    }

    @Test
    public void main() {
        getTotalPath(TreeNode.initTree(), 38);
        System.out.println(tmp.toString());
    }
}
