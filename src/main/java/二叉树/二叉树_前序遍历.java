package 二叉树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static 二叉树.TreeNode.initTree;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode144.java
 * @Description 二叉树的前序遍历
 * @createTime 2022年04月01日 21:59:00
 */
public class  二叉树_前序遍历 {


    public List<Integer> preorderTraversal(TreeNode root) {
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
        ans.add(root.val);
        hleper(root.left, ans);
        hleper(root.right, ans);
    }

    @Test
    public void main() {
        TreeNode node = initTree();
//        System.out.println(preorderTraversal(node));
        System.out.println(preorderTraversal(null));
    }

}
