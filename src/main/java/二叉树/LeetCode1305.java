package 二叉树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode1305.java
 * @Description 两棵二叉搜索树中的所有元素
 * @createTime 2022年05月01日 16:42:00
 */
public class LeetCode1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ansList = new ArrayList<>();
        getElementByPostOrder(root1, ansList);
        getElementByPostOrder(root2, ansList);
        return ansList.stream().sorted().collect(Collectors.toList());
    }

    /**
     * 递归实现
     *
     * @param root       树
     * @param resultList 返回的list
     */
    void getElementValue(TreeNode root, List<Integer> resultList) {
        if (root == null) {
            return;
        }
        getElementValue(root.left, resultList);
        getElementValue(root.right, resultList);
        resultList.add(root.val);
    }

    /**
     * 循环实现 中序遍历
     *
     * @param root       树
     * @param resultList 结果
     */
    void getElementVal(TreeNode root, List<Integer> resultList) {
        Stack<TreeNode> tmp = new Stack<>();
        if (root == null) return;
        while (root != null || !tmp.isEmpty()) {
            while (root != null) {
                tmp.push(root);
                root = root.left;
            }
            root = tmp.pop();
            resultList.add(root.val);
            root = root.right;
        }
    }

    /**
     * 后序遍历
     *
     * @param root       树
     * @param resultList 结果
     */
    void getElementByPostOrder(TreeNode root, List<Integer> resultList) {
        Stack<TreeNode> tmp = new Stack<>();
        TreeNode tmpNode = null;
        while (root != null || !tmp.isEmpty()) {
            while (root != null) {
                tmp.push(root);
                root = root.left;
            }
            root = tmp.pop();
            if (root.right == null || tmpNode == root.right) {
                resultList.add(root.val);
                tmpNode = root;
                root = null;
            } else {
                tmp.push(root);
                root = root.right;
            }
        }
    }

    @Test
    public void main() {
        System.out.print(getAllElements(TreeNode.initTree(), TreeNode.initTree()).toString());
    }
}
