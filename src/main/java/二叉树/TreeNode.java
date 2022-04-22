package 二叉树;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode initTree() {

        TreeNode node1 = new TreeNode(3);

        TreeNode node2 = new TreeNode(9);

        TreeNode node3 = new TreeNode(20);

        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        TreeNode node6 = new TreeNode(18);
        TreeNode node7 = new TreeNode(8);

        node1.left = node2;
        node2.left = node6;
        node6.right = node7;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
//        node5.left = node2;
        return node1;
    }
}