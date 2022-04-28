package arrary;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName Leetcode268.java
 * @Description 丢失的数字
 * @createTime 2022年04月26日 22:40:00
 */
public class Leetcode268 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    @Test
    public void main() {
        int[] arr = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(arr));
    }
}
