package arrary;

import org.junit.Test;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode369.java
 * @Description 旋转函数
 * @createTime 2022年04月22日 07:41:00
 */
public class LeetCode369 {

    public int maxRotateFunction(int[] nums) {
        int i = 0, j = nums.length - 1, k = j, ans = Integer.MIN_VALUE;
        int[] tmp = new int[nums.length];
        int numIndex = 0;
        // 数组旋转一次
        while (i <= k) {
            if (j < nums.length) {
                tmp[i++] = nums[j++];
            } else {
                tmp[i++] = nums[numIndex++];
            }
        }
        for (int num : tmp) {
            System.out.print(num + " ");
        }
        return Integer.MIN_VALUE;
    }

    @Test
    public void main() {
        int[] arr = {4, 3, 5, 6};
        maxRotateFunction(arr);
    }
}
