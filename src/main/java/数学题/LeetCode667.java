package 数学题;

import org.junit.Test;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode667.java
 * @Description 优美的排列 II
 * @createTime 2022年05月04日 13:18:00
 */
public class LeetCode667 {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int len = n-k;
        int max = n;
        boolean flag = false;
        for (int i = 0; i < n ; i++) {
            if (len!=0){
                res[i] = max--;
                len--;
            }else {
                if (flag)res[i] = res[i-1]+k;
                else res[i] = res[i-1]-k;
                flag = !flag;
                k--;
            }
        }
        return res;
    }

    @Test
    public void main() {
        int[] arr = constructArray(3, 3);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
