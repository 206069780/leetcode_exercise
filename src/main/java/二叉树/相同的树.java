package 二叉树;

import org.junit.Test;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName 相同的树.java
 * @Description TODO
 * @createTime 2022年04月22日 23:08:00
 */
public class 相同的树 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    @Test
    public void main(){

    }
}
